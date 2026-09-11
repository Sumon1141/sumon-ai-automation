package com.sumonai.automation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.lifecycle.lifecycleScope
import com.sumonai.automation.databinding.ActivityMainBinding
import com.sumonai.automation.services.VoiceCommandService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        checkAccessibilityService()
    }

    private fun setupUI() {
        binding.apply {
            // Voice Input Button
            voiceInputBtn.setOnClickListener {
                startVoiceInput()
            }

            // Settings Button
            settingsBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, com.sumonai.automation.ui.SettingsActivity::class.java))
            }

            // API Key Manager Button
            apiKeyManagerBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, com.sumonai.automation.ui.ApiKeyManagerActivity::class.java))
            }

            // System Status Button
            systemStatusBtn.setOnClickListener {
                updateSystemStatus()
            }
        }
    }

    private fun startVoiceInput() {
        val intent = Intent(this, VoiceCommandService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        } else {
            startService(intent)
        }
    }

    private fun checkAccessibilityService() {
        if (!isAccessibilityServiceEnabled()) {
            binding.accessibilityStatus.text = "⚠️ Accessibility Service: Not Enabled"
            binding.enableAccessibilityBtn.apply {
                visibility = android.view.View.VISIBLE
                setOnClickListener {
                    startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
                }
            }
        } else {
            binding.accessibilityStatus.text = "✅ Accessibility Service: Enabled"
            binding.enableAccessibilityBtn.visibility = android.view.View.GONE
        }
    }

    private fun isAccessibilityServiceEnabled(): Boolean {
        val accessibilityManager = getSystemService<android.view.accessibility.AccessibilityManager>()
        return accessibilityManager?.isEnabled ?: false
    }

    private fun updateSystemStatus() {
        lifecycleScope.launch {
            // Update network, bluetooth, wifi status
            binding.apply {
                wifiStatus.text = "📡 Wi-Fi: ${getWifiStatus()}"
                bluetoothStatus.text = "🔵 Bluetooth: ${getBluetoothStatus()}"
                volumeStatus.text = "🔊 Volume: ${getVolumeStatus()}"
            }
        }
    }

    private fun getWifiStatus(): String {
        val connectivityManager = getSystemService<android.net.ConnectivityManager>()
        val network = connectivityManager?.activeNetwork
        return if (network != null) "Connected" else "Disconnected"
    }

    private fun getBluetoothStatus(): String {
        val bluetoothAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter()
        return if (bluetoothAdapter?.isEnabled == true) "On" else "Off"
    }

    private fun getVolumeStatus(): String {
        val audioManager = getSystemService<android.media.AudioManager>()
        val volume = audioManager?.getStreamVolume(android.media.AudioManager.STREAM_MUSIC) ?: 0
        val maxVolume = audioManager?.getStreamMaxVolume(android.media.AudioManager.STREAM_MUSIC) ?: 15
        return "$volume/$maxVolume"
    }
}
