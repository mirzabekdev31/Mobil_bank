package uz.gita.mirzabek.example.mobilebank.data.models

import uz.gita.mirzabek.example.mobilebank.data.remote.request.SignUpRequest

data class SignUpData(
    val phone: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val bornDate: String,
    val gender: String
)


fun SignUpData.toRequest() = SignUpRequest(phone, password, firstName, lastName, bornDate, gender)