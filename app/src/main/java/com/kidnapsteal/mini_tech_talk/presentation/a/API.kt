package com.kidnapsteal.mini_tech_talk.presentation.a

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("orgs/{users}/repos")
    fun getRepos(@Path("users") user: String): Single<List<GithubRepo>>
}