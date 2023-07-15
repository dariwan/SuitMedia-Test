package com.dariwan.suitmediatestapk.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.dariwan.suitmediatestapk.apihelper.ApiService
import com.dariwan.suitmediatestapk.data.paging.MaterialPagingSource
import com.dariwan.suitmediatestapk.response.AllUsersResponse

class UserRepository private constructor(
    private val apiService: ApiService,
    private val context: Context) {


    fun getAllUsers(): LiveData<PagingData<AllUsersResponse.ListUsers>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                MaterialPagingSource(apiService)
            }
        ).liveData
    }

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null

        fun getInstance(apiService: ApiService, context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserRepository(apiService, context)
            }.also { INSTANCE = it }

        private const val TAG = "UserRepository"
    }
}