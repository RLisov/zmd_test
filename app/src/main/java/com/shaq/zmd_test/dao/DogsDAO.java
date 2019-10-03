package com.shaq.zmd_test.dao;

import com.shaq.zmd_test.model.CatsRealm;

import java.util.List;

import io.realm.Realm;

public class DogsDAO {

    public static DogsDAO getInstance() {
        return InstanceHolder.instance;
    }

    public void addDogs(List<CatsRealm> list, Realm realm) {
        if (!realm.isInTransaction()) realm.beginTransaction();
        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();
    }

    private static class InstanceHolder {
        private static final DogsDAO instance = new DogsDAO();
    }
}
