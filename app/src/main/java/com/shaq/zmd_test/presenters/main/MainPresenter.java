package com.shaq.zmd_test.presenters.main;



import com.shaq.zmd_test.controllers.RetrofitAdapter;

import io.realm.Realm;
import retrofit2.Retrofit;

public class MainPresenter implements MainContract.Presenter  {

    private Realm mRealm;
    private Retrofit mRetrofit;

    public Realm getRealm() {
        if (mRealm == null) mRealm = Realm.getDefaultInstance();
        return mRealm;
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) mRetrofit = RetrofitAdapter.getInstance();
        return mRetrofit;
    };

}
