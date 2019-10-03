package com.shaq.zmd_test.api;

import com.shaq.zmd_test.model.CatsPojo;
import com.shaq.zmd_test.model.CatsRealm;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("cats")
    Single<List<CatsRealm>> getCats();
}
