package com.kidnapsteal.mini_tech_talk.utils

import android.view.View

fun View.onClick(onClick: () -> Unit) {
    this.setOnClickListener { onClick() }
}