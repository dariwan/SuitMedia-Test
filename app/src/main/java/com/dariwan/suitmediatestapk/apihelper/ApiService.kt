package com.dariwan.suitmediatestapk.apihelper

import com.dariwan.suitmediatestapk.response.AllUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/users?")
    suspend fun getAllUsers(
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null,
    ): AllUsersResponse
}