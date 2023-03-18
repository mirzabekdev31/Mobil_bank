package uz.gita.mirzabek.example.mobilebank.presenter.viewmodel

import androidx.lifecycle.LiveData

interface SignUpVerifyViewModel {

    val openMainScreenLiveData:LiveData<Unit>

    fun verifySignUp(code:String)
}