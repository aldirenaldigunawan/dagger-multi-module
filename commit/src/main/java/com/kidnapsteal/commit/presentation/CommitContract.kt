package com.kidnapsteal.commit.presentation

import com.kidnapsteal.base.BasePresenter
import com.kidnapsteal.base.BaseView
import com.kidnapsteal.commit.data.entity.Commit

interface CommitContract {
    interface Presenter : BasePresenter<View>{
        fun loadCommit(limit: Int)
    }

    interface View : BaseView {
        fun renderCommits(commits: List<Commit>)
    }
}