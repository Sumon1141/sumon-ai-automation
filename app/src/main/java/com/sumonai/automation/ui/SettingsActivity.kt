package com.sumonai.automation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sumonai.automation.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
        }
    }
}
