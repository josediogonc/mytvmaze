package com.example.mytvmaze.core.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytvmaze.api.repository.ApiRepository
import com.example.mytvmaze.core.network.retrofit.model.RequestError

//TODO: inserir camda de repositorio
open class BaseViewModel(protected val apiRepository: ApiRepository) : ViewModel() {

    protected val _errorDialog = MutableLiveData<RequestError>()
    val errorDialog: LiveData<RequestError> = _errorDialog

}