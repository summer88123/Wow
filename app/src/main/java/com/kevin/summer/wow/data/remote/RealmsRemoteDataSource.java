package com.kevin.summer.wow.data.remote;

import com.google.gson.JsonObject;

import com.kevin.summer.wow.data.entry.RealmInfo;
import com.kevin.summer.wow.data.response.RealmResponse;
import com.kevin.summer.wow.data.source.RealmsDataSource;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by summery on 2016/5/18.
 */
public class RealmsRemoteDataSource   {

    private APIService api;

    public RealmsRemoteDataSource(APIService api) {
        this.api = api;
    }


    public RealmInfo getRealm(String name) {
        return null;
    }

}
