package com.kidnapsteal.commit

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kidnapsteal.base.showToast
import com.kidnapsteal.base.visible
import com.kidnapsteal.commit.data.entity.Commit
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_c.*
import javax.inject.Inject

class CommitActivity : DaggerAppCompatActivity(), CommitContract.View {

    @Inject
    lateinit var presenter: CommitContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        initRecyclerView()

        presenter.let {
            it.attachView(this)
            it.loadCommit(100)
        }
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CommitAdapter()
    }

    override fun renderCommits(commits: List<Commit>) {
        (recyclerView.adapter as CommitAdapter).data = commits
    }

    override fun showProgress(show: Boolean) {
        progressBar.visible(show)
    }

    override fun showError(message: String) {
        showToast(message)
    }

    companion object {
        const val EXTRA_USER_NAME = "CommitActivity.extra_user_name"
        const val EXTRA_USER_REPO = "CommitActivity.extra_user_repo"
    }
}