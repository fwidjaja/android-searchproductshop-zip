package com.example.ba_1963.android_searchproduct_mvp.data

import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class SearchRepository: SearchRepositoryInterface {
    override fun getData(q: String?, start: Int): Observable<ResultSearchDataModel> {
        return Observable.create<ResultSearchDataModel> {
            // ini diisi apa yaa :(
            // hit API nya dmana?
        }.subscribeOn(Schedulers.io())
    }
}