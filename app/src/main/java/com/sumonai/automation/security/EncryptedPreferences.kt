package com.sumonai.automation.security

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class EncryptedPreferences(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "sumon_ai_encrypted_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveApiKey(service: String, apiKey: String) {
        sharedPreferences.edit().putString("api_key_$service", apiKey).apply()
    }

    fun getApiKey(service: String): String? {
        return sharedPreferences.getString("api_key_$service", null)
    }

    fun deleteApiKey(service: String) {
        sharedPreferences.edit().remove("api_key_$service").apply()
    }

    fun getAllApiKeys(): Map<String, String> {
        val keys = mapOf(
            "gemini", "claude", "openai", "groq", "deepseek",
            "elevenlabs", "tavily", "openweathermap", "huggingface"
        )
        return keys.associateWith { getApiKey(it) ?: "" }
    }

    fun saveUserPreference(key: String, value: String) {
        sharedPreferences.edit().putString("pref_$key", value).apply()
    }

    fun getUserPreference(key: String): String? {
        return sharedPreferences.getString("pref_$key", null)
    }
}
