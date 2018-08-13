package com.kidnapsteal.commit.data.remote

import com.kidnapsteal.commit.data.entity.GithubCommit
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    @GET("repos/{user}/{repos}/commits")
    fun getCommit(@Path("user") user: String,
                  @Path("repos") repo: String,
                  @Query("per_page") limit: Int): Observable<List<GithubCommit>>

}