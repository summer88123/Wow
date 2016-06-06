package com.kevin.summer.wow.data.source;

import com.kevin.summer.wow.data.entry.RealmInfo;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * 服务器数据容器 Created by summery on 2016/5/18.
 */
public class RealmsRepository implements RealmsDataSource {
    private static RealmsRepository INSTANCE = null;

    private RealmsDataSource mRealmsRemoteDataSource;

    private RealmsDataSource mRealmsLocalDataSource;

    private List<RealmsRepositoryObserver> mObservers = new ArrayList<>();

    private RealmResults<RealmInfo> mCacheRealmInfos;

    private io.realm.Realm mRealm;

    /**
     * 标记缓存是否可用，下一次请求数据时强制更新缓存
     */
    private boolean mCacheIsDirty;

    /**
     * Return the single instance of this class, creating it if necessary
     *
     * @param remote the network data source
     * @param local  the device storage data source
     * @return the {@link RealmsRepository} instance
     */
    public static RealmsRepository getInstance(RealmsDataSource remote, RealmsDataSource local) {
        if (INSTANCE == null) {
            INSTANCE = new RealmsRepository(io.realm.Realm.getDefaultInstance(), remote, local);
        }
        return INSTANCE;
    }

    /**
     * Used to force {@link #getInstance(RealmsDataSource, RealmsDataSource)} to create a new
     * instance next time it's called;
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    public RealmsRepository(io.realm.Realm realm , RealmsDataSource remote, RealmsDataSource local) {
        this.mRealmsRemoteDataSource = remote;
        this.mRealmsLocalDataSource = local;
        this.mRealm = realm;
    }

    public void addContentObserver(RealmsRepositoryObserver observer) {
        if (!mObservers.contains(observer)) {
            mObservers.add(observer);
        }
    }

    public void removeContentObserver(RealmsRepositoryObserver observer) {
        if (mObservers.contains(observer)) {
            mObservers.remove(observer);
        }
    }

    private void notifyContentObserver() {
        for (RealmsRepositoryObserver observer :
                mObservers) {
            observer.onRealmsChanged();
        }
    }

    @Override
    public RealmResults<RealmInfo> getRealms() {
        if (mCacheRealmInfos == null) {
            mCacheRealmInfos = mRealm.where(RealmInfo.class).findAllAsync();
            mCacheRealmInfos.addChangeListener(new RealmChangeListener<RealmResults<RealmInfo>>() {
                @Override
                public void onChange(RealmResults<RealmInfo> element) {
                    if (mCacheRealmInfos.size() != 0) {
                        notifyContentObserver();
                    } else {
                        mRealmsRemoteDataSource.getRealms();
                    }
                }
            });
        }
        return mCacheRealmInfos;
    }

    @Override
    public RealmInfo getRealm(String name) {
        return null;
    }

    public interface RealmsRepositoryObserver {
        void onRealmsChanged();
    }
}
