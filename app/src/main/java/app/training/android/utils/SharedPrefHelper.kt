package app.training.android.utils

import android.content.Context
import androidx.preference.PreferenceManager
import androidx.core.content.edit

class SharedPrefHelper(val context: Context) {

    fun saveString(key: String, value: String){
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        pref.edit {
            putString(key, value)
        }
    }

    fun getString(key: String): String?{
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getString(key, "")
    }

    fun saveBoolean(key: String, value: Boolean){
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        pref.edit {
            putBoolean(key, value)
        }
    }

    fun getBoolean(key: String): Boolean{
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getBoolean(key, false)
    }
}