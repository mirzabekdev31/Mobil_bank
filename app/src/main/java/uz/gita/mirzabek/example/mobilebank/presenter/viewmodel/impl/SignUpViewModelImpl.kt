package uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.mobilebank.data.models.SignUpData
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignUpRequest
import uz.gita.mirzabek.example.mobilebank.domain.usecase.SignUpUseCase
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.SignUpViewModel
import javax.inject.Inject


@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val useCase: SignUpUseCase
) : SignUpViewModel, ViewModel() {
    override val openVerifyScreenLiveData = MutableLiveData<Unit>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val messageLiveData=MutableLiveData<String>()
    override val backLiveData=MutableLiveData<Unit>()

    override fun register(signUpData: SignUpData) {
        useCase.register(signUpData)
            .onEach { progressLiveData.value=false }
            .onEach { it.onSuccess { openVerifyScreenLiveData.value=Unit } }
            .onEach { it.onFailure { i-> messageLiveData.value=i.message } }
            .launchIn(viewModelScope)

        /*
        useCase.singUp(signUpData)
            .onEach { loadingLiveData.value = false }
            .onEach { it.onSuccess { successLiveData.value = Unit } }
            .onEach { it.onFailure { e -> messageLiveData.value = e.message } }
            .launchIn(viewModelScope)
         */

//        useCase.register(signUpRequest)
//            .onEach { progressLiveData.value = false }
//            .onEach {  it.onSuccess { openVerifyScreenLiveData.value = Unit } }
//            .onEach { it.onFailure { Log.d("TTT","Hello") } }
//            .launchIn(viewModelScope)

        /*
             useCase.singUp(signUpData)
            .onEach { loadingLiveData.value = false }
            .onEach { it.onSuccess { successLiveData.value = Unit } }
            .onEach { it.onFailure { e -> messageLiveData.value = e.message } }
            .launchIn(viewModelScope)
         */
    }
    override fun backPop() {
        backLiveData.value=Unit
    }
}