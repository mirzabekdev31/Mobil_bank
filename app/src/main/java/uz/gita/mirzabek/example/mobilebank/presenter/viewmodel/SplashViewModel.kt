package uz.gita.mirzabek.example.mobilebank.presenter.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface SplashViewModel {
    val openLoginScreenLiveData: LiveData<Unit>
    val openContactScreenLiveData: LiveData<Unit>
}