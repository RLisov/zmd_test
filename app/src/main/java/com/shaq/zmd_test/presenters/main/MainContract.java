package com.shaq.zmd_test.presenters.main;

import com.shaq.zmd_test.controllers.RetrofitAdapter;

import io.realm.Realm;
import retrofit2.Retrofit;

public interface MainContract {
    interface View {

    }

    interface Presenter {
        Retrofit getRetrofit();
        Realm getRealm();
    }

    interface Repository {

    }
}
