package uz.gita.mirzabek.example.mobilebank.domain.usecase.impl

import kotlinx.coroutines.flow.flow
import uz.gita.bookappauth.utils.ConnectionUtil
import uz.gita.mirzabek.example.mobilebank.domain.repository.SignUpVerifyRepository
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SignUpVerifyUseCase
import javax.inject.Inject

class SignUpVerifyUseCaseImpl @Inject constructor(
    private val repository: SignUpVerifyRepository,
    private val connectionUtil: ConnectionUtil
) : SignUpVerifyUseCase {
    override fun verifySignUp(code: String)= repository.verifySignUp(code)
}
