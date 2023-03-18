package uz.gita.mirzabek.example.mobilebank.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignInRequest
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignUpRequest
import uz.gita.mirzabek.example.mobilebank.data.remote.request.VerifySigInRequest
import uz.gita.mirzabek.example.mobilebank.data.remote.request.VerifySigUpRequest
import uz.gita.mirzabek.example.mobilebank.data.remote.response.SigUpVerifyResponse
import uz.gita.mirzabek.example.mobilebank.data.remote.response.SignInVerifyResponse
import uz.gita.mirzabek.example.mobilebank.data.remote.response.TokenResponse
import uz.gita.mirzabek.example.mobilebank.data.remote.response.TokenSignInResponse

interface AuthApi {

    @POST("auth/sign-up")
    suspend fun signUp(@Body singUpRequest: SignUpRequest): Response<TokenResponse>

    @POST("auth/sign-in")
    suspend fun signIn(@Body signInRequest: SignInRequest):Response<TokenSignInResponse>

    @POST("sign-up/verify")
    suspend fun verifySignUp(@Body token:String,verifySigUpRequest: VerifySigUpRequest):Response<SigUpVerifyResponse>

    @POST("sign-in/verify")
    suspend fun verifySignIn(@Body token:String,verifySigInRequest: VerifySigInRequest):Response<SignInVerifyResponse>
}