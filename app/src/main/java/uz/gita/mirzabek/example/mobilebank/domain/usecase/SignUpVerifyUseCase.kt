package uz.gita.mirzabek.example.mobilebank.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SignUpVerifyUseCase {
    fun verifySignUp(code:String): Flow<Result<Unit>>
}