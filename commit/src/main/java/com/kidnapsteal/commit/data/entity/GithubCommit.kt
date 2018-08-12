package com.kidnapsteal.commit.data.entity

data class GithubCommit(val commit: Commit)

data class Commit(val author: Author= Author(),
                  val message: String="",
                  val url: String="",
                  val html_url: String ="")

data class Author(val name: String = "", val email: String = "", val date: String = "")

