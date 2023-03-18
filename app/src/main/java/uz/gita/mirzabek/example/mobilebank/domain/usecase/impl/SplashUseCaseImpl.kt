package uz.gita.mirzabek.example.mobilebank.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.mobilebank.data.local.pref.AppPref
import uz.gita.mirzabek.example.mobilebank.domain.repository.SplashRepository
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SplashUseCase
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    val repository: SplashRepository,
) : SplashUseCase {
    override fun openScreen(): Flow<Int> = flow {
        if (repository.openScreen() == "LOGIN") {
            emit(1)
        } else {
            emit(2)
        }
    }
}