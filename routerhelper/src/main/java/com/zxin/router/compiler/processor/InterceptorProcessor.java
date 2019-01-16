package com.zxin.router.compiler.processor;

import com.google.auto.service.AutoService;
import com.zxin.router.annotation.Interceptor;
import com.zxin.router.compiler.util.RouterLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import com.zxin.router.compiler.util.RouterConsts;

/**
 * {@link Interceptor} annotation processor.
 * <p>
 * Created by zxin on 2017/3/6.
 *
 * 编译时注解的核心依赖APT(Annotation Processing Tools)实现，原理是在某些代码元素上（如类型、函数、字段等）添加注解，在编译时编译器会检查AbstractProcessor的子类，
 * 并且调用该类型的process函数，然后将添加了注解的所有元素都传递到process函数中，使得开发人员可以在编译器进行相应的处理
 *
 * Processor继承自AbstractProcessor类，@SupportedAnnotationTypes中填写待处理的注解全称，@SupportedSourceVersion表示处理的JAVA版本。
 *
 */
@SupportedAnnotationTypes(RouterConsts.INTERCEPTOR_ANNOTATION_TYPE)//@SupportedAnnotationTypes(“<待处理注解类路径>”)
@SupportedOptions(RouterConsts.OPTION_MODULE_NAME)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@AutoService(Processor.class)
public class InterceptorProcessor extends AbstractProcessor {
    private String mModuleName;
    private RouterLogger mLogger;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mModuleName = processingEnvironment.getOptions().get(RouterConsts.OPTION_MODULE_NAME);
        mLogger = new RouterLogger(processingEnvironment.getMessager());
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Interceptor.class);
        if (elements == null || elements.isEmpty()) {
            return true;
        }
        mLogger.info(String.format(">>> %s: InterceptorProcessor begin... <<<", mModuleName));
        // 合法的TypeElement集合
        Set<TypeElement> typeElements = new HashSet<>();
        for (Element element : elements) {
            if (validateElement(element)) {
                typeElements.add((TypeElement) element);
            } else {
                mLogger.error(element, String.format("The annotated element is not a implementation class of %s",RouterConsts.INTERCEPTOR_FULL_NAME));
            }
        }
        if (mModuleName != null) {
            String validModuleName = mModuleName.replace(".", "_").replace("-", "_");
            generateInterceptors(validModuleName, typeElements);
        } else {
            mLogger.info("动态生成路由名称："+mModuleName+"=======》无模块："+RouterConsts.OPTION_MODULE_NAME);
        }
        mLogger.info(String.format(">>> %s: InterceptorProcessor end. <<<", mModuleName));
        return true;
    }

    private boolean validateElement(Element element) {
        return element.getKind().isClass() && processingEnv.getTypeUtils().isAssignable(element.asType(),
                processingEnv.getElementUtils().getTypeElement(RouterConsts.INTERCEPTOR_FULL_NAME).asType());
    }

    private void generateInterceptors(String moduleName, Set<TypeElement> elements) {
        /*
         * params
         */
        TypeElement interceptorType = processingEnv.getElementUtils().getTypeElement(RouterConsts.INTERCEPTOR_FULL_NAME);
        // Map<String, Class<? extends RouteInterceptor>> map
        ParameterizedTypeName mapTypeName = ParameterizedTypeName.get(ClassName.get(Map.class),
                ClassName.get(String.class), ParameterizedTypeName.get(ClassName.get(Class.class),
                        WildcardTypeName.subtypeOf(ClassName.get(interceptorType))));
        ParameterSpec mapParameterSpec = ParameterSpec.builder(mapTypeName, "map").build();
        /*
         * method
         */
        MethodSpec.Builder handleInterceptors = MethodSpec.methodBuilder(RouterConsts.METHOD_HANDLE)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(mapParameterSpec);

        Map<String, String> interceptorRecorder = new HashMap<>();
        for (TypeElement element : elements) {
            mLogger.info(String.format("Found interceptor: %s", element.getQualifiedName()));
            Interceptor interceptor = element.getAnnotation(Interceptor.class);
            String name = interceptor.value();
            if (interceptorRecorder.containsKey(name)) {
                throw new RuntimeException(String.format("Duplicate interceptor name: %s[%s, %s]",
                        name, element.getQualifiedName(), interceptorRecorder.get(name)));
            }
            handleInterceptors.addStatement("map.put($S, $T.class)", name, ClassName.get(element));
            interceptorRecorder.put(name, element.getQualifiedName().toString());
        }

        /*
         * class
         */
        TypeElement interfaceType = processingEnv.getElementUtils().getTypeElement(RouterConsts.INTERCEPTOR_TABLE_FULL_NAME);
        TypeSpec type = TypeSpec.classBuilder(capitalize(moduleName) + RouterConsts.INTERCEPTOR_TABLE)
                .addSuperinterface(ClassName.get(interfaceType))
                .addModifiers(Modifier.PUBLIC)
                .addMethod(handleInterceptors.build())
                .addJavadoc(RouterConsts.CLASS_JAVA_DOC)
                .build();

        try {
            JavaFile.builder(RouterConsts.PACKAGE_NAME, type).build().writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String capitalize(CharSequence self) {
        return self.length() == 0 ? "" :
                "" + Character.toUpperCase(self.charAt(0)) + self.subSequence(1, self.length());
    }

}
