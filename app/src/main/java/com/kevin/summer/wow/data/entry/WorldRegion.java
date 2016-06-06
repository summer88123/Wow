package com.kevin.summer.wow.data.entry;

import com.google.gson.annotations.SerializedName;

import android.support.annotation.Nullable;

import com.kevin.summer.wow.*;

import io.realm.RealmObject;

/**
 * Created by summery on 2016/5/17.
 */
public class WorldRegion extends RealmObject {
    /**
     * area : 21
     * controlling-faction : 0
     * status : 0
     * next : 1463503192282
     * 13581640395003
     */

    private int area;
    /**
     * 区域归属
     * 0: Alliance
     * 1: Horde
     * 2: Neutral
     */
    @SerializedName("controlling-faction")
    private int controlling_faction;
    /**
     * 状态
     * -1: Unknown
     * 0: Idle
     * 1: Populating
     * 2: Active
     * 3: Concluded
     */
    private int status;
    /**
     * 下场开始时间
     */
    private long next;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getControlling_faction() {
        return controlling_faction;
    }

    public void setControlling_faction(int controlling_faction) {
        this.controlling_faction = controlling_faction;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }
}
