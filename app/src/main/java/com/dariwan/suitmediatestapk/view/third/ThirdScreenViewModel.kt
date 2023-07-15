package com.dariwan.suitmediatestapk.view.third

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dariwan.suitmediatestapk.data.repository.UserRepository
import com.dariwan.suitmediatestapk.di.Injection
import com.dariwan.suitmediatestapk.response.AllUsersResponse

class ThirdScreenViewModel(userRepository: UserRepository, context: Context): ViewModel() {
    val material : LiveData<PagingData<AllUsersResponse.ListUsers>> = userRepository.getAllUsers().cachedIn(viewModelScope)

    class FoodMaterialFactory(private val context: Context): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ThirdScreenViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return ThirdScreenViewModel(Injection.provideRepository(context), context) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}