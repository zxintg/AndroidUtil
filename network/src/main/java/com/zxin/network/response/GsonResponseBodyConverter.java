package com.zxin.network.response;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.zxin.network.exception.ResultException;
import com.zxin.zxinlib.util.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by hy on 2017/10/19.
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;
    private String tag="";

    public GsonResponseBodyConverter(Gson gson, Type type,String tag) {
        this.type = type;
        this.tag = tag;
    }

    /**
     * @param value
     * @return
     * @throws IOException
     */
    @Override
    public T convert(ResponseBody value) {
        try {
            String result = value.string();
            if (tag.equals("BeiKe")){
                JSONObject jsonDatas = new JSONObject(result);
                int code = jsonDatas.optInt("errno");
                if (code==0){
                    return new Gson().fromJson(result,type);
                }
                throw new ResultException(-1,jsonDatas.optString("error"));
            }else if (tag.equals("JiuXian")){
                JSONObject jsonDatas = new JSONObject(result);
                long code = Long.parseLong(jsonDatas.optString("success"));
                if (code==1){
                    return new Gson().fromJson(result,type);
                }
                throw new ResultException(-1,jsonDatas.optString("errMsg"));
            } else if (tag.equals("Jdxsxp")||tag.equals("MeiZiYoWu")){
                return new Gson().fromJson(result,type);
            }
            JSONObject jsonDatas = new JSONObject(result);
            String code = jsonDatas.optString("code");
            if (code.equals("1")||code.equals("10")||code.equals("1028")||code.equals("1059")){
                return new Gson().fromJson(result,type);
            }else
                throw new ResultException(-1,jsonDatas.optString("message"));
        } catch (IOException e) {
            throw new ResultException(0, "数据解析异常");
        } catch (RuntimeException e) {
            throw new ResultException(400, "系统异常");
        } catch (JSONException e) {
            throw new ResultException(0, "数据解析异常");
        }
    }
}
