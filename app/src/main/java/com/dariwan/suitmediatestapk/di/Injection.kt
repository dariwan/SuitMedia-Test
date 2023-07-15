package com.dariwan.suitmediatestapk.di

import android.content.Context
import com.dariwan.suitmediatestapk.apihelper.ApiConfig
import com.dariwan.suitmediatestapk.data.repository.UserRepository

object Injection {

    fun provideRepository(context: Context): UserRepository{
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService, context)

    }
}