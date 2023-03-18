package uz.gita.mirzabek.example.mobilebank.domain.usecase

interface SignInUseCase {
    suspend fun login(phone:String,password:String)
}