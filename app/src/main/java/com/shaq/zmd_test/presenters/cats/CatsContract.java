package com.shaq.zmd_test.presenters.cats;

import com.shaq.zmd_test.model.CatsRealm;

import java.util.List;

import io.reactivex.Single;

public interface CatsContract {

    interface View  {

        void displayCats(List<CatsRealm> catsRealmList);
        void catsLoaded();
    }

    interface Presenter {

       Single<List<CatsRealm>> loadCats();

    }
}
