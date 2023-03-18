package uz.gita.mirzabek.example.mobilebank.presenter.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.mobilebank.R
import uz.gita.mirzabek.example.mobilebank.presenter.viewmodel.impl.SplashViewModelImpl

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen :Fragment(R.layout.screen_splash){

    private val viewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openLoginScreenLiveData.observe(viewLifecycleOwner,openLoginScreenLiveDataObser)
    }

    private val openLoginScreenLiveDataObser=Observer<Unit>{
        findNavController().navigate(R.id.action_splashScreen_to_signInScreen)
    }
}