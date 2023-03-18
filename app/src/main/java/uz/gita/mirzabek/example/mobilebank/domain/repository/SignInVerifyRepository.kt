package uz.gita.mirzabek.example.mobilebank.domain.repository
import kotlinx.coroutines.flow.Flow

interface SignInVerifyRepository {
    fun verifySignIn(code:String): Flow<Result<Unit>>
}