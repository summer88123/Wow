package com.kevin.summer.wow.data.entry;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 成就实体类
 * Created by summery on 2016/6/6.
 */
public class Achievement extends RealmObject{
    /**
     * id : 2144
     * title : 千奇百怪的漫长旅行
     * points : 50
     * description : 完成下列世界事件成就。
     * reward : 奖励：紫色始祖幼龙
     * rewardItems : [{"id":44177,"name":"紫色始祖幼龙的缰绳","icon":"ability_mount_drake_proto","quality":4,"itemLevel":70,"tooltipParams":{"timewalkerLevel":0},"stats":[],"armor":0,"context":"","bonusLists":[]}]
     * icon : achievement_bg_masterofallbgs
     * criteria : [{"id":7553,"description":"尊敬长者","orderIndex":0,"max":1},{"id":7561,"description":"爱情冲昏头","orderIndex":1,"max":1},{"id":9880,"description":"复活节的贵族","orderIndex":2,"max":1},{"id":7555,"description":"为了孩子","orderIndex":3,"max":1},{"id":0,"description":"护焰者/护火者","orderIndex":4,"max":1},{"id":7564,"description":"酒仙","orderIndex":5,"max":1},{"id":7558,"description":"神圣之名","orderIndex":6,"max":1},{"id":7566,"description":"欢乐使者","orderIndex":7,"max":1}]
     * accountWide : true
     * factionId : 2
     */

    /**
     * 成就ID
     */
    @PrimaryKey
    private int id;
    /**
     * 标题
     */
    private String title;
    /**
     * 成就点数
     */
    private int points;

    /**
     * 描述
     */
    private String description;
    /**
     * 奖励描述
     */
    private String reward;
    /**
     * 图标
     */
    private String icon;
    private boolean accountWide;
    private int factionId;
    /**
     * 奖励详情
     * id : 44177
     * name : 紫色始祖幼龙的缰绳
     * icon : ability_mount_drake_proto
     * quality : 4
     * itemLevel : 70
     * tooltipParams : {"timewalkerLevel":0}
     * stats : []
     * armor : 0
     * context :
     * bonusLists : []
     */
    private RealmList<RewardItems> rewardItems;
    /**
     * 前置关联成就
     * id : 7553
     * description : 尊敬长者
     * orderIndex : 0
     * max : 1
     */
    private RealmList<Criteria> criteria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isAccountWide() {
        return accountWide;
    }

    public void setAccountWide(boolean accountWide) {
        this.accountWide = accountWide;
    }

    public int getFactionId() {
        return factionId;
    }

    public void setFactionId(int factionId) {
        this.factionId = factionId;
    }

    public List<RewardItems> getRewardItems() {
        return rewardItems;
    }

    public void setRewardItems(RealmList<RewardItems> rewardItems) {
        this.rewardItems = rewardItems;
    }

    public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(RealmList<Criteria> criteria) {
        this.criteria = criteria;
    }

    public static class RewardItems extends RealmObject{
        private int id;
        private String name;
        private String icon;
        private int quality;
        private int itemLevel;
        /**
         * timewalkerLevel : 0
         */

        private TooltipParams tooltipParams;
        private int armor;
        private String context;
        private List<?> stats;
        private List<?> bonusLists;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public int getItemLevel() {
            return itemLevel;
        }

        public void setItemLevel(int itemLevel) {
            this.itemLevel = itemLevel;
        }

        public TooltipParams getTooltipParams() {
            return tooltipParams;
        }

        public void setTooltipParams(TooltipParams tooltipParams) {
            this.tooltipParams = tooltipParams;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public List<?> getStats() {
            return stats;
        }

        public void setStats(List<?> stats) {
            this.stats = stats;
        }

        public List<?> getBonusLists() {
            return bonusLists;
        }

        public void setBonusLists(List<?> bonusLists) {
            this.bonusLists = bonusLists;
        }

        public static class TooltipParams {
            private int timewalkerLevel;

            public int getTimewalkerLevel() {
                return timewalkerLevel;
            }

            public void setTimewalkerLevel(int timewalkerLevel) {
                this.timewalkerLevel = timewalkerLevel;
            }
        }
    }

    public static class Criteria extends RealmObject {
        private int id;
        private String description;
        private int orderIndex;
        private int max;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(int orderIndex) {
            this.orderIndex = orderIndex;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }
}
