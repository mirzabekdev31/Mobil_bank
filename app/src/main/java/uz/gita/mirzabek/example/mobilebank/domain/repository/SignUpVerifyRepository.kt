package uz.gita.mirzabek.example.mobilebank.domain.repository

import kotlinx.coroutines.flow.Flow

interface SignUpVerifyRepository {
    fun verifySignUp(code:String):Flow<Result<Unit>>
}