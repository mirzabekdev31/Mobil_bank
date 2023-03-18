package uz.gita.mirzabek.example.mobilebank.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppPref @Inject constructor(@ApplicationContext context: Context) {
    private  var pref: SharedPreferences = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)

    var startScreen: String
        set(value) = pref.edit().putString("START_SCREEN", value).apply()
        get() = pref.getString("START_SCREEN", "LOGIN")!!

    var token: String
        set(value) = pref.edit().putString("TOKEN", value).apply()
        get() = pref.getString("TOKEN", "")!!

    var accesToken:String
        set(value) = pref.edit().putString("ACCESSTOKEN",value).apply()
        get() = pref.getString("ACCESSTOKEN","")!!

    var refreshToken:String
        set(value) = pref.edit().putString("REFRESHTOKEN",value).apply()
        get() = pref.getString("REFRESHTOKEN","")!!
}