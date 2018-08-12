package com.kidnapsteal.base

import android.view.View

fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}