package uz.gita.mirzabek.example.mobilebank.presenter.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.mobilebank.R
import uz.gita.mirzabek.example.mobilebank.databinding.ScreenSignInBinding


@AndroidEntryPoint
class SignInScreen :Fragment(R.layout.screen_sign_in){

    private val binding by viewBinding(ScreenSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SignUpp.setOnClickListener {
            findNavController().navigate(R.id.action_signInScreen_to_signUpScreen)
        }

    }
}