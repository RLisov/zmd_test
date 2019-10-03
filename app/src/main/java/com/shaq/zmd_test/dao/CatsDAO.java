package com.shaq.zmd_test.dao;

import com.shaq.zmd_test.model.CatsRealm;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CatsDAO {

    public static CatsDAO getInstance() {
        return InstanceHolder.instance;
    }

    public void addCats(List<CatsRealm> list, Realm realm) {
        if (!realm.isInTransaction()) realm.beginTransaction();
        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();
    }

    public List<CatsRealm> getCats(Realm realm) {
        RealmResults<CatsRealm> all = realm.where(CatsRealm.class).findAll();
        return realm.copyFromRealm(all);
    }


    private static class InstanceHolder {
        private static final CatsDAO instance = new CatsDAO();
    }
}
