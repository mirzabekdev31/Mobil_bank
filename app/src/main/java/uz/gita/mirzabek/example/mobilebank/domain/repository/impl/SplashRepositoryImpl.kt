package uz.gita.mirzabek.example.mobilebank.domain.repository.impl

import uz.gita.mirzabek.example.mobilebank.data.local.pref.AppPref
import uz.gita.mirzabek.example.mobilebank.domain.repository.SplashRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashRepositoryImpl @Inject constructor(private val pref: AppPref) : SplashRepository {

    override suspend fun openScreen(): String {
        if (pref.startScreen == "LOGIN") {
            return "LOGIN"
        } else {
            return "Contact"
        }
    }
}