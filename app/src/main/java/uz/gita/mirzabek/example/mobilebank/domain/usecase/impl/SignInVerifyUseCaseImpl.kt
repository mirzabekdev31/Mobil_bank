package uz.gita.mirzabek.example.mobilebank.domain.usecase.impl

import uz.gita.bookappauth.utils.ConnectionUtil
import uz.gita.mirzabek.example.mobilebank.domain.repository.SignInVerifyRepository
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SignInVerifyUseCase
import javax.inject.Inject

class SignInVerifyUseCaseImpl @Inject constructor(
    private val repository: SignInVerifyRepository,
    private val connectionUtil: ConnectionUtil
) : SignInVerifyUseCase {
    override suspend fun verifySignIn(code: String) {
        if (connectionUtil.isConnected()) {
            repository.verifySignIn(code)
        }
    }
}