package com.dicoding.beescrapeapps.activity.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Dashboard page"
    }
    val text: LiveData<String> = _text
}