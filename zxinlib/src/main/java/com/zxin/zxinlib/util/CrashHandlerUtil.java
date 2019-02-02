package com.zxin.zxinlib.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.zxin.zxinlib.app.BaseApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * UncaughtException处理当程序发生Uncaught异常的时由该类来接管程序,并记录发送错误报给服务器
 * @author duanjianghua
 * 
 */
public class CrashHandlerUtil implements UncaughtExceptionHandler {
	
	public static final String TAG = "CrashHandlerUtil";
	
	//系统默认的UncaughtException处理
	private UncaughtExceptionHandler mDefaultHandler;
	//CrashHandler实例
	private static volatile CrashHandlerUtil INSTANCE = null;
	//程序的Context对象
	private Context mContext;
	//用来存储设备信息和异常信
	private Map<String, String> infos = new HashMap<String, String>();
	//用于格式化日�?作为日志文件名的�?���?
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

	/** 保证只有一个CrashHandler实例 */
	private CrashHandlerUtil() {

	}

	/** 获取CrashHandler实例 ,单例模式 */
	public static CrashHandlerUtil getInstance() {
		if (INSTANCE==null){
			synchronized (CrashHandlerUtil.class){
				if(INSTANCE==null)
					INSTANCE  = new CrashHandlerUtil();
			}
		}
		return INSTANCE;
	}

	/**
	 * 初始�?
	 * 
	 * @param context
	 */
	public void init(Context context) {
		mContext = context;
		//获取系统默认的UncaughtException处理
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		//设置该CrashHandler为程序的默认处理
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (!handleException(ex) && mDefaultHandler != null) {
			//如果用户没有处理则让系统默认的异常处理器来处
			mDefaultHandler.uncaughtException(thread, ex);
			System.exit(0);
		}

	}

	/**
	 * 自定义错误处�?收集错误信息 发�?错误报告等操作均在此完成.
	 * 
	 * @param ex
	 * @return true:如果处理了该异常信息;否则返回false.
	 */
	private boolean handleException(Throwable ex) {
		if (ex == null) {
			return false;
		}
		//使用Toast来显示异常信�?
		
		//收集设备参数信息 
//		collectDeviceInfo(mContext);
		//保存日志文件 
//		saveCrashInfo2File(ex);
		return true;
	}
	
	/**
	 * 收集设备参数信息
	 * @param ctx
	 */
	public void collectDeviceInfo(Context ctx) {
		try {
			PackageManager pm = ctx.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
			if (pi != null) {
				String versionName = pi.versionName == null ? "null" : pi.versionName;
				String versionCode = pi.versionCode + "";
				infos.put("versionName", versionName);
				infos.put("versionCode", versionCode);
			}
		} catch (NameNotFoundException e) {
			Log.e(TAG, "an error occured when collect package info", e);
		}
		Field[] fields = Build.class.getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				infos.put(field.getName(), field.get(null).toString());
				Log.d(TAG, field.getName() + " : " + field.get(null));
			} catch (Exception e) {
				Log.e(TAG, "an error occured when collect crash info", e);
			}
		}
	}

	/**
	 * 保存错误信息到文件中
	 * @param ex
	 * @return	返回文件名称,便于将文件传送到服务
	 */
	private String saveCrashInfo2File(Throwable ex) {
		
		StringBuffer sb = new StringBuffer();
		for (Entry<String, String> entry : infos.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key + "=" + value + "\n");
		}
		
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		Throwable cause = ex.getCause();
		while (cause != null) {
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		printWriter.close();
		String result = writer.toString();
		sb.append(result);
		try {
			long timestamp = System.currentTimeMillis();
			String time = formatter.format(new Date());
			String fileName = "crash-" + time + "-" + timestamp + ".log";
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				String downloadCacheDirectory = Environment.getDownloadCacheDirectory().getPath();
				String externalStorageDirectory = Environment.getExternalStorageDirectory().getPath();
				String dirpath = externalStorageDirectory+"/"+ BaseApplication.getInstance().getPackageName()+downloadCacheDirectory+"/exception/";
				File dir = new File(dirpath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(dirpath + fileName);
				fos.write(sb.toString().getBytes());
				fos.close();
			}
			return fileName;
		} catch (Exception e) {
			Log.e(TAG, "an error occured while writing file...", e);
		}
		return null;
	}
}