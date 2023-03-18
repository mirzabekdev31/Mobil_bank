package uz.gita.mirzabek.example.mobilebank.domain.usecase

interface SignInVerifyUseCase {
    suspend  fun verifySignIn(code:String)
}