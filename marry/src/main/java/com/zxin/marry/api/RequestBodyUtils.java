package com.zxin.marry.api;

import com.google.gson.Gson;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by acer on 2017/12/5.
 */

public class RequestBodyUtils {

    //RequestBody
    public static RequestBody setRequestBody(Map<String,Object> map){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"),new Gson().toJson(map));

    }
}
