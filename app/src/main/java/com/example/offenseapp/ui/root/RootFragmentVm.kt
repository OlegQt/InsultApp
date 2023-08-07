package com.example.offenseapp.ui.root

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.offenseapp.data.network.RetrofitNetworkClient
import com.example.offenseapp.data.repository.InsultRepositoryImpl
import com.example.offenseapp.domain.usecase.LoadInsultUseCase
import com.example.offenseapp.util.Resource

class RootFragmentVm:ViewModel() {
    private val handler = Handler(Looper.getMainLooper())
    private val repo = InsultRepositoryImpl(RetrofitNetworkClient())
    private val useCase = LoadInsultUseCase(repository = repo)

    val insultText = MutableLiveData<String>()


    fun loadNewInsult() {
        useCase.execute() {
            when (it) {
                is Resource.Success -> {
                    handler.post {
                        insultText.value = it.data?.insult
                    }
                }

                else -> {}
            }
        }
    }
}