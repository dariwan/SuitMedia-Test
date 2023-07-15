package com.dariwan.suitmediatestapk.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class AllUsersResponse (

    @SerializedName("error")
    val error: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<ListUsers>
){
    @Parcelize
    data class ListUsers(

        @SerializedName("id")
        val id: Int,

        @SerializedName("email")
        val email: String,

        @SerializedName("first_name")
        val first_name: String,

        @SerializedName("last_name")
        val last_name: String,

        @SerializedName("avatar")
        val avatar: String,

    ): Parcelable
}