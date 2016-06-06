package com.kevin.summer.wow.data.remote;

import com.google.gson.JsonObject;

import com.kevin.summer.wow.data.response.RealmResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by summery on 2016/5/7.
 */
public interface APIService {
    String BASE_URL = "https://api.battlenet.com.cn/";

    String a = "https://api.battlenet.com.cn/wow/auction/data/阿拉希?locale=zh_CN&apikey=";
    String b = "https://api.battlenet.com.cn/wow/item/10111?locale=zh_CN&apikey=";
    String c = "https://api.battlenet.com.cn/wow/achievement/2144?locale=zh_CN&apikey=";
    String d = "https://api.battlenet.com.cn/";
    String icon = "http://media.blizzard.com/wow/icons/36/{icon}.jpg";

    String apikey = "uet488jqcfkqe4gja3sn5gbzmcdmv4w9";
    String locale = "zh_CN";
    @GET("wow/realm/status")
    Call<RealmResponse> getRealms(@QueryMap Map<String, String> map);
    @GET("wow/item/{id}")
    Call<JsonObject> getItem(@Path("id") int id, @QueryMap Map<String, String> map);

    class APIServiceFactory{
        public static Map<String ,String> defaultMap = new HashMap<>();

        static {
            defaultMap.put("locale", locale);
            defaultMap.put("apikey", apikey);
        }
        public static APIService api;

        public static APIService get(){
            if (api == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(APIService.class);
            }
            return api;
        }
    }

}
