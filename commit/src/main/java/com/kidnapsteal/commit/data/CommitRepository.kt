package com.kidnapsteal.commit.data

import com.kidnapsteal.commit.API
import com.kidnapsteal.commit.data.entity.Commit
import io.reactivex.Single
import javax.inject.Inject

interface CommitRepository {
    fun getCommits(user: String, repos: String, limit: Int): Single<List<Commit>>
}

class CommitRepositoryImpl @Inject constructor(private val api: API) : CommitRepository {
    override fun getCommits(user: String, repos: String, limit: Int): Single<List<Commit>> {
        return api.getCommit(user, repos, limit).flatMapIterable { it }
                .map { it.commit }
                .toList()
    }

}