package uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SignUpVerifyUseCase
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.SignUpVerifyViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpVerifyViewModelImpl
    @Inject constructor(
        private val useCase:SignUpVerifyUseCase
    )
    :SignUpVerifyViewModel,ViewModel(){
    override val openMainScreenLiveData=MutableLiveData<Unit>()

    override fun verifySignUp(code: String) {
        useCase.verifySignUp(code)
            .onEach { it.onSuccess { openMainScreenLiveData.value=Unit  } }
            .onEach { it.onFailure {i-> Timber.tag("TTT").d("${i}") } }
            .launchIn(viewModelScope)
    }

}