package uz.gita.mirzabek.example.mobilebank.domain.repository.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mirzabek.example.mobilebank.data.local.pref.AppPref
import uz.gita.mirzabek.example.mobilebank.data.remote.api.AuthApi
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignInRequest
import uz.gita.mirzabek.example.mobilebank.data.remote.response.MessageSignInResponse
import uz.gita.mirzabek.example.mobilebank.domain.repository.SignInRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SignInRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val pref: AppPref,
    private val gson: Gson
) : SignInRepository {
    override fun login(phone: String, password: String): Flow<Result<Unit>> = flow {
        val response = authApi.signIn(SignInRequest(phone, password))

        when (response.code()) {
            in 200..299 -> {
                val data = response.body() ?: return@flow
                pref.token = data.token
                emit(Result.success(Unit))
            }
            else -> {
                val messageResponse = gson.fromJson(
                    response.errorBody()?.string().toString(),
                    MessageSignInResponse::class.java
                )
                emit(Result.failure(Exception(messageResponse.message)))
            }
        }
    }.catch { emit(Result.failure(Exception("Internetga ulangaman tarmoqni tekshirib ko'ring!"))) }
        .flowOn(Dispatchers.IO)

}