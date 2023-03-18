package uz.gita.mirzabek.example.mobilebank.domain.usecase.impl

import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.mobilebank.data.models.SignUpData
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignUpRequest
import uz.gita.mirzabek.example.mobilebank.domain.repository.SignUpRepository
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val repository: SignUpRepository,
) : SignUpUseCase {
    override fun register(signUpData: SignUpData) = repository.register(signUpData)

}