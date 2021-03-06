package com.sunnyweather.android.ui.place

import androidx.lifecycle.*


import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.Repository

class PlaceViewModel : ViewModel() {//视图模型的架起桥梁

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }



}