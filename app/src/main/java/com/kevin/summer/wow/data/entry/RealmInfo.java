package com.kevin.summer.wow.data.entry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 服务器对象
 * Created by summery on 2016/5/17.
 */
public class RealmInfo extends RealmObject{


    /**
     * 托尔巴拉德
     */
    @SerializedName("tol-barad")
    private WorldRegion tol_barad;
    /**
     * 冬握湖
     */
    private WorldRegion wintergrasp;
    /**
     * 服务器类型，pve/pvp/角色？
     */
    private String type;
    /**
     * 负载 medium/hight
     */
    private String population;
    /**
     * 是否排队
     */
    private boolean queue;
    /**
     * 状态
     */
    private boolean status;
    /**
     * 服务器名称
     */
    @PrimaryKey
    private String name;
    /**
     * slug : 万色星辰
     */
    private String slug;
    /**
     * 战场组
     */
    private String battlegroup;
    /**
     * 地区
     */
    private String locale;
    /**
     * 时区
     */
    private String timezone;

    public WorldRegion getTol_barad() {
        return tol_barad;
    }

    public void setTol_barad(WorldRegion tol_barad) {
        this.tol_barad = tol_barad;
    }

    public WorldRegion getWintergrasp() {
        return wintergrasp;
    }

    public void setWintergrasp(WorldRegion wintergrasp) {
        this.wintergrasp = wintergrasp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public boolean isQueue() {
        return queue;
    }

    public void setQueue(boolean queue) {
        this.queue = queue;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public RealmInfo() {
    }
}
