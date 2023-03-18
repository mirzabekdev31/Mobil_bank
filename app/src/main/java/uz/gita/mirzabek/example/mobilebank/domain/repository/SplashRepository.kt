package uz.gita.mirzabek.example.mobilebank.domain.repository

interface SplashRepository {
    suspend fun openScreen():String
}