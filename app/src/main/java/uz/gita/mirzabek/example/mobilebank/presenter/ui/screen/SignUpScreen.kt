package uz.gita.mirzabek.example.mobilebank.presenter.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.room.InvalidationTracker
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.mobilebank.R
import uz.gita.mirzabek.example.mobilebank.data.models.SignUpData
import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignUpRequest
import uz.gita.mirzabek.example.mobilebank.databinding.ScreenSignInBinding
import uz.gita.mirzabek.example.mobilebank.databinding.ScreenSignUpBinding
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl.SignUpViewModelImpl
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl.SplashViewModelImpl

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.screen_sign_up){

    private val binding by viewBinding(ScreenSignUpBinding::bind)
    private val viewModel by viewModels<SignUpViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.backLiveData.observe(viewLifecycleOwner,backLiveDataObserver)
        binding.BackBtn.setOnClickListener {
            viewModel.backPop()
        }
        viewModel.progressLiveData.observe(viewLifecycleOwner,progressLiveDataObserver)
        viewModel.openVerifyScreenLiveData.observe(viewLifecycleOwner,openVerifyScreenLiveDataObserver)
        binding.SignUp.setOnClickListener{
            viewModel.register(
                SignUpData(
                    "+998971114754",
                    "qwertyy",
                    "Mirzabek",
                    "Orziyev",
                    "969822000000",
                    "0"
                )

//                binding.Phone.text.toString(),binding.Password.text.toString(),
//                binding.FirstName.text.toString(),
//                binding.LastName.text.toString(),
//                binding.BornData.text.toString(),
//                binding.Gender.text.toString()
            )
        }
    }

    private val backLiveDataObserver=Observer<Unit>{
        findNavController().navigate(R.id.action_signUpScreen_to_signInScreen)
    }
    private val progressLiveDataObserver= Observer<Boolean> {

    }

    private val openVerifyScreenLiveDataObserver=Observer<Unit>{
        findNavController().navigate(R.id.action_signUpScreen_to_signUpVerify)
    }
}