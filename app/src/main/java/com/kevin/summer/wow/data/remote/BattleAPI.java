package com.kevin.summer.wow.data.remote;

import com.google.gson.JsonObject;

import com.kevin.summer.wow.data.entry.Achievement;
import com.kevin.summer.wow.data.entry.RealmFile;
import com.kevin.summer.wow.data.response.RealmResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by summery on 2016/5/7.
 */
public interface BattleAPI {
    String BASE_URL = "https://api.battlenet.com.cn/";

    String d = "https://api.battlenet.com.cn/wow/auction/data/阿拉希?l";
    String icon = "http://media.blizzard.com/wow/icons/36/achievement_bg_masterofallbgs.jpg";

    String apikey = "uet488jqcfkqe4gja3sn5gbzmcdmv4w9";
    String locale = "zh_CN";

    /**
     * 获取指定成就
     * @param id
     * @param map
     * @return
     */
    @GET("wow/achievement/{id}")
    Call<Achievement> getAchievement(@Path("id") int id, @QueryMap Map<String, String> map);

    @GET("wow/auction/data/{realm}")
    Call<RealmFile> getAuctionData(@Path("realm") String name, @QueryMap Map<String, String> map);

    /**
     * 获取所有服务器状态
     */
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
        public static BattleAPI api;

        public static BattleAPI get(){
            if (api == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(BattleAPI.class);
            }
            return api;
        }
    }

}
