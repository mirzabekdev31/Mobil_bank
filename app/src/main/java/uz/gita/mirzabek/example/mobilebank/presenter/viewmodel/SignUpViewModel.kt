package uz.gita.mirzabek.example.mobilebank.presenter.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.mirzabek.example.mobilebank.data.models.SignUpData

interface SignUpViewModel {
    val openVerifyScreenLiveData: LiveData<Unit>
    val progressLiveData: LiveData<Boolean>
    val messageLiveData:LiveData<String>
    val backLiveData:LiveData<Unit>

    fun register(signUpData: SignUpData)

    fun backPop()

}