package com.kevin.summer.wow.data.remote;

import com.kevin.summer.wow.data.entry.RealmInfo;

/**
 * Created by summery on 2016/5/18.
 */
public class RealmsRemoteDataSource   {

    private BattleAPI api;

    public RealmsRemoteDataSource(BattleAPI api) {
        this.api = api;
    }


    public RealmInfo getRealm(String name) {
        return null;
    }

}
