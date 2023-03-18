package uz.gita.mirzabek.example.mobilebank.data.remote.response

import com.google.gson.annotations.SerializedName

data class SignInVerifyResponse (
    @SerializedName("refresh-token")
    val refreshToken:String,
    @SerializedName("access-token")
    val accessToken:String
)