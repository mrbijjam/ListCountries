package com.countriesinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.countriesinfo.data.model.CountiesInfoResponseItem
import com.countriesinfo.data.network.NetworkStatus
import com.countriesinfo.data.network.repository.CountriesRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CountriesViewModel(private val repository: CountriesRepository): ViewModel() {

    private val _countriesState = MutableStateFlow<NetworkStatus<List<CountiesInfoResponseItem>>>(
        NetworkStatus.Loading)

    val countriesState: MutableStateFlow<NetworkStatus<List<CountiesInfoResponseItem>>> = _countriesState
    init {
        getPostData()
    }

    private fun getPostData(){
        viewModelScope.launch {
            _countriesState.value = NetworkStatus.Loading // Show loading state
            _countriesState.value = repository.getPost()
        }
    }
}