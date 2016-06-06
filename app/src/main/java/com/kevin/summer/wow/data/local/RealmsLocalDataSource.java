package com.kevin.summer.wow.data.local;

import com.kevin.summer.wow.data.entry.RealmInfo;
import com.kevin.summer.wow.data.source.RealmsDataSource;

import java.util.List;

/**
 * Created by summery on 2016/5/18.
 */
public class RealmsLocalDataSource implements RealmsDataSource {
    private io.realm.Realm mRealm;

    @Override
    public List<RealmInfo> getRealms() {
        mRealm.where(RealmInfo.class).findAll();
        return null;
    }

    @Override
    public RealmInfo getRealm(String name) {
        return null;
    }

}
