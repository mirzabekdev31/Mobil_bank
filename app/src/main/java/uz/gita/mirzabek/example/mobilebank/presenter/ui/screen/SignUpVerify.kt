package uz.gita.mirzabek.example.mobilebank.presenter.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.mobilebank.R
import uz.gita.mirzabek.example.mobilebank.databinding.ScreenVerifySignUpBinding
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl.SignUpVerifyViewModelImpl

@AndroidEntryPoint
class SignUpVerify :Fragment(R.layout.screen_verify_sign_up){
    private val binding by viewBinding(ScreenVerifySignUpBinding::bind)
    private val viewModel by viewModels<SignUpVerifyViewModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openMainScreenLiveData.observe(viewLifecycleOwner,openMainScreenLiveDataObserver)
        binding.verifyBtn.setOnClickListener{
            viewModel.verifySignUp(binding.firstPinView.text.toString())
        }
    }

    private val openMainScreenLiveDataObserver=Observer<Unit>{
        findNavController().navigate(R.id.action_signUpVerify_to_mainScreen)
    }
}