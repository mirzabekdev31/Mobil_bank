package uz.gita.mirzabek.example.mobilebank.domain.repository

import kotlinx.coroutines.flow.Flow


interface SignInRepository {
    fun login(phone:String,password:String): Flow<Result<Unit>>
}