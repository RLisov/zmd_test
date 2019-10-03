package com.shaq.zmd_test.model;

import io.realm.RealmObject;

public class DogsRealm extends RealmObject {

    private String mUrl;
    private String mTitle;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
