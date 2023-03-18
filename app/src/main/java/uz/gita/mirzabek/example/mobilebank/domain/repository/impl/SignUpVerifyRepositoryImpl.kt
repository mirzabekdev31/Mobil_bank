package uz.gita.mirzabek.example.mobilebank.domain.repository.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mirzabek.example.mobilebank.data.local.pref.AppPref
import uz.gita.mirzabek.example.mobilebank.data.remote.api.AuthApi
import uz.gita.mirzabek.example.mobilebank.data.remote.request.VerifySigUpRequest
import uz.gita.mirzabek.example.mobilebank.data.remote.response.MessageResponse
import uz.gita.mirzabek.example.mobilebank.domain.repository.SignUpVerifyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpVerifyRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val pref: AppPref,
    private val gson: Gson
) :
    SignUpVerifyRepository {
    override fun verifySignUp(code: String): Flow<Result<Unit>> = flow {
        val response = authApi.verifySignUp(pref.token, VerifySigUpRequest(code))
        when (response.code()) {
            in 200..299 -> {
                val data = response.body() ?: return@flow
                pref.accesToken = data.accessToken
                pref.refreshToken = data.refreshToken
                emit(Result.success(Unit))
            }
            else -> {
                val errorMessage = gson.fromJson(
                    response.errorBody()?.string().toString(),
                    MessageResponse::class.java
                )
                emit(Result.failure(Exception(errorMessage.message)))
            }
        }
    }.catch { emit(Result.failure(Exception("Internetga ulangaman tarmoqni tekshirib ko'ring!"))) }
        .flowOn(Dispatchers.IO)


}