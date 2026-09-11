package com.sumonai.automation.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.RESULTS_RECOGNITION
import android.content.Context
import androidx.lifecycle.lifecycleScope
import com.sumonai.automation.api.ApiManager
import com.sumonai.automation.security.EncryptedPreferences
import kotlinx.coroutines.launch

class VoiceCommandService : Service() {
    private var speechRecognizer: SpeechRecognizer? = null
    private lateinit var apiManager: ApiManager
    private lateinit var encryptedPreferences: EncryptedPreferences

    override fun onCreate() {
        super.onCreate()
        encryptedPreferences = EncryptedPreferences(this)
        apiManager = ApiManager(encryptedPreferences)
        initSpeechRecognizer()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startListening()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun initSpeechRecognizer() {
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this).apply {
            setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: android.os.Bundle?) {}
                override fun onBeginningOfSpeech() {}
                override fun onRmsChanged(rmsdB: Float) {}
                override fun onBufferReceived(buffer: ByteArray?) {}
                override fun onEndOfSpeech() {}
                override fun onError(error: Int) {
                    // Handle error
                }

                override fun onResults(results: android.os.Bundle?) {
                    val matches = results?.getStringArrayList(RESULTS_RECOGNITION)
                    if (!matches.isNullOrEmpty()) {
                        val recognizedText = matches[0]
                        processVoiceCommand(recognizedText)
                    }
                }

                override fun onPartialResults(partialResults: android.os.Bundle?) {}
                override fun onEvent(eventType: Int, params: android.os.Bundle?) {}
            })
        }
    }

    private fun startListening() {
        val recognizerIntent = Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE, "en-US") // Change to bn-BD for Bengali
            putExtra(android.speech.RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
        }
        speechRecognizer?.startListening(recognizerIntent)
    }

    private fun processVoiceCommand(command: String) {
        // Parse command and execute automation
        when {
            command.contains("whatsapp", ignoreCase = true) -> handleWhatsAppCommand(command)
            command.contains("weather", ignoreCase = true) -> handleWeatherCommand(command)
            command.contains("search", ignoreCase = true) -> handleSearchCommand(command)
            else -> handleGeneralCommand(command)
        }
    }

    private fun handleWhatsAppCommand(command: String) {
        // Parse: "Send WhatsApp message to [Name]: [Message]"
        // Implementation
    }

    private fun handleWeatherCommand(command: String) {
        // Get current location weather
    }

    private fun handleSearchCommand(command: String) {
        // Search web and return results
    }

    private fun handleGeneralCommand(command: String) {
        // Use AI to process general commands
    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer?.destroy()
    }
}
