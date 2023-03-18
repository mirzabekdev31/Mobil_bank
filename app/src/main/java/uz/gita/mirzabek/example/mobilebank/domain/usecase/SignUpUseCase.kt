package uz.gita.mirzabek.example.mobilebank.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mirzabek.example.mobilebank.data.models.SignUpData
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignUpRequest


interface SignUpUseCase {
    fun register(signUpData: SignUpData): Flow<Result<Unit>>
}