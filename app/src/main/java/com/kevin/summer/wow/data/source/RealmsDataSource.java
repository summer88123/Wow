package com.kevin.summer.wow.data.source;

import com.kevin.summer.wow.data.entry.RealmInfo;

import java.util.List;

/**
 * Created by summery on 2016/5/17.
 */
public interface RealmsDataSource {
    List<RealmInfo> getRealms();

    RealmInfo getRealm(String name);
}

