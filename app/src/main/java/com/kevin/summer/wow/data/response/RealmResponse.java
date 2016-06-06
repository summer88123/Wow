package com.kevin.summer.wow.data.response;

import com.kevin.summer.wow.data.entry.RealmInfo;

import java.util.List;

/**
 * 服务器数据响应对象
 * Created by summery on 2016/5/17.
 */
public class RealmResponse {
    private List<RealmInfo> realms;

    public List<RealmInfo> getRealmInfos() {
        return realms;
    }

    public void setRealmInfos(List<RealmInfo> realmInfos) {
        this.realms = realmInfos;
    }
}
