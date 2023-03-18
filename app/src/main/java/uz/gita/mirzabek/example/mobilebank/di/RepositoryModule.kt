package uz.gita.mirzabek.example.mobilebank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mirzabek.example.mobilebank.domain.repository.*
import uz.gita.mirzabek.example.mobilebank.domain.repository.impl.*


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun getSignInRepository(impl: SignInRepositoryImpl):SignInRepository

    @Binds
    fun getSignUpRepository(impl:SignUpRepositoryImpl):SignUpRepository

    @Binds
    fun getSignInVerifyRepository(impl:SignInVerifyRepositoryImpl):SignInVerifyRepository

    @Binds
    fun getSignUpVerifyRepository(impl: SignUpVerifyRepositoryImpl):SignUpVerifyRepository

    @Binds
    fun getSplashRepository(impl:SplashRepositoryImpl):SplashRepository
}