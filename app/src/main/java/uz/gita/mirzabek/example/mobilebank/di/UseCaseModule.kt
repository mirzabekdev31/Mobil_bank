package uz.gita.mirzabek.example.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.mirzabek.example.mobilebank.domain.usecase.*
import uz.gita.mirzabek.example.mobilebank.domain.usecase.impl.*

/*
@Binds
    fun getBookScreenUseCase(impl:BookScreenUseCaseImpl):BookScreenUseCase
 */

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun getSignInUseCase(impl:SignInUseCaseImpl):SignInUseCase

    @Binds
    fun getSignInVerifyUseCase(impl:SignInVerifyUseCaseImpl):SignInVerifyUseCase

    @Binds
    fun getSignUpUseCase(impl: SignUpUseCaseImpl):SignUpUseCase

    @Binds
    fun getSignUpVerifyUseCase(impl:SignUpVerifyUseCaseImpl):SignUpVerifyUseCase

    @Binds
    fun getSplashUseCase(impl:SplashUseCaseImpl):SplashUseCase

}