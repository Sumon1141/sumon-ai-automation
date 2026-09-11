package com.sumonai.automation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sumonai.automation.databinding.ActivityApiKeyManagerBinding
import com.sumonai.automation.security.EncryptedPreferences

class ApiKeyManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApiKeyManagerBinding
    private lateinit var encryptedPreferences: EncryptedPreferences

    private val apiServices = listOf(
        "Gemini", "Claude", "OpenAI", "Groq", "DeepSeek",
        "ElevenLabs", "Tavily", "OpenWeatherMap", "HuggingFace"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiKeyManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        encryptedPreferences = EncryptedPreferences(this)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            backBtn.setOnClickListener { finish() }

            saveBtn.setOnClickListener {
                saveApiKeys()
            }

            // Initialize UI for each API key
            geminiKeyInput.setText(encryptedPreferences.getApiKey("gemini") ?: "")
            claudeKeyInput.setText(encryptedPreferences.getApiKey("claude") ?: "")
            openaiKeyInput.setText(encryptedPreferences.getApiKey("openai") ?: "")
            groqKeyInput.setText(encryptedPreferences.getApiKey("groq") ?: "")
            deepseekKeyInput.setText(encryptedPreferences.getApiKey("deepseek") ?: "")
            elevenLabsKeyInput.setText(encryptedPreferences.getApiKey("elevenlabs") ?: "")
            tavilyKeyInput.setText(encryptedPreferences.getApiKey("tavily") ?: "")
            weatherKeyInput.setText(encryptedPreferences.getApiKey("openweathermap") ?: "")
            huggingfaceKeyInput.setText(encryptedPreferences.getApiKey("huggingface") ?: "")
        }
    }

    private fun saveApiKeys() {
        binding.apply {
            encryptedPreferences.saveApiKey("gemini", geminiKeyInput.text.toString())
            encryptedPreferences.saveApiKey("claude", claudeKeyInput.text.toString())
            encryptedPreferences.saveApiKey("openai", openaiKeyInput.text.toString())
            encryptedPreferences.saveApiKey("groq", groqKeyInput.text.toString())
            encryptedPreferences.saveApiKey("deepseek", deepseekKeyInput.text.toString())
            encryptedPreferences.saveApiKey("elevenlabs", elevenLabsKeyInput.text.toString())
            encryptedPreferences.saveApiKey("tavily", tavilyKeyInput.text.toString())
            encryptedPreferences.saveApiKey("openweathermap", weatherKeyInput.text.toString())
            encryptedPreferences.saveApiKey("huggingface", huggingfaceKeyInput.text.toString())

            Toast.makeText(this@ApiKeyManagerActivity, "✅ API Keys saved securely!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
