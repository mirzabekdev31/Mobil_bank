package uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl

import android.app.ActivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SplashUseCase
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.SplashViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val useCase:SplashUseCase
) :SplashViewModel,ViewModel(){
    override val openLoginScreenLiveData=MutableLiveData<Unit>()
    override val openContactScreenLiveData=MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            useCase.openScreen().collect{
                delay(2000)
                if (it==1){
                    openLoginScreenLiveData.value=Unit
                }else{
                    openContactScreenLiveData.value=Unit
                }
            }
        }
    }
}