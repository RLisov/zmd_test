package com.shaq.zmd_test.presenters.cats;

import com.shaq.zmd_test.api.ServerCommunicator;
import com.shaq.zmd_test.dao.CatsDAO;
import com.shaq.zmd_test.model.CatsRealm;
import com.shaq.zmd_test.presenters.main.MainPresenter;
import com.shaq.zmd_test.shared.ZmdApp;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CatsPresenter extends MainPresenter implements CatsContract.Presenter {

    private ZmdApp mApp;
    private ServerCommunicator mServerCommunicator;

    public CatsPresenter(ZmdApp app, ServerCommunicator serverCommunicator) {
        mApp = app;
        mServerCommunicator = serverCommunicator;
    }


    public Single<List<CatsRealm>> loadCats() {
        List<CatsRealm> cats = CatsDAO.getInstance().getCats(getRealm());
        if (!cats.isEmpty()) {
            return Single.just(cats);
        } else {
            return mServerCommunicator.getCats()
                    .doOnSuccess(catsList -> CatsDAO.getInstance().addCats(catsList, getRealm()));
        }
    }
}
