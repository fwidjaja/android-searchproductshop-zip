package com.example.ba_1963.android_searchproduct_mvp.util.extensions

fun <E> MutableList<E>.replace(newData: List<E>) {
    this.clear()
    this.addAll(newData)
}