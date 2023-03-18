package uz.gita.mirzabek.example.mobilebank.domain.usecase.impl
import uz.gita.bookappauth.utils.ConnectionUtil
import uz.gita.mirzabek.example.mobilebank.domain.repository.SignInRepository
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SignInUseCase
import javax.inject.Inject



class SignInUseCaseImpl @Inject constructor(
    private val repository: SignInRepository,
    private val connectionUtil: ConnectionUtil

) : SignInUseCase {
    override suspend fun login(phone: String, password: String) {
        if (connectionUtil.isConnected()) {
            repository.login(phone, password)
        }
    }
}