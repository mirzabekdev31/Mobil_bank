package uz.gita.mirzabek.example.mobilebank.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SplashUseCase {
    fun openScreen(): Flow<Int>
}