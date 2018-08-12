package com.kidnapsteal.commit.domain

import com.kidnapsteal.commit.data.entity.Commit
import com.kidnapsteal.commit.data.CommitRepository
import io.reactivex.Single
import javax.inject.Inject

interface GetCommitUseCase {
    fun execute(user: String, repos: String, limit: Int): Single<List<Commit>>
}

class GetCommitUseCaseImpl @Inject constructor(private val repo: CommitRepository) : GetCommitUseCase {
    override fun execute(user: String, repos: String, limit: Int): Single<List<Commit>> {
        return repo.getCommits(user, repos, limit)
    }
}