package com.kevin.summer.wow.data.entry;

import java.util.List;

/**
 * Created by summery on 2016/6/6.
 */
public class RealmFile {
    /**
     * url : http://auction-api-cn.worldofwarcraft.com/auction-data/18983665724af8fa1f0972dfdfefc77f/auctions.json
     * lastModified : 1465224481000
     */

    private List<Files> files;

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public static class Files {
        private String url;
        private long lastModified;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getLastModified() {
            return lastModified;
        }

        public void setLastModified(long lastModified) {
            this.lastModified = lastModified;
        }
    }
}
