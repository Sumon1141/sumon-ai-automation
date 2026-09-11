# 🤖 Sumon AI - Voice-Controlled AI Automation Agent

## 📱 Overview
Sumon AI is a production-ready Android application that functions as an **On-Device Voice-Controlled AI Automation Agent**. It integrates multiple LLM APIs, provides system automation through accessibility services, and supports voice commands in both Bengali (bn-BD) and English.

### ✨ Key Features
- 🎤 **Voice Command Recognition** - Bengali & English language support
- 🧠 **Multi-LLM Engine** - Gemini, Claude, OpenAI, Groq, DeepSeek with automatic fallback
- 🤖 **AI Automation** - WhatsApp, Facebook, Telegram, browser automation
- 📊 **Real-time Data** - Weather, web search, system status
- 🔐 **Secure API Storage** - Encrypted Shared Preferences
- ⚙️ **System Control** - Wi-Fi, Bluetooth, Volume, Notifications

---

## 🚀 Quick Start Guide

### Prerequisites
- Android Studio (latest version)
- Android SDK 26+ (Target SDK 34)
- Git
- 9 API Keys (optional but recommended):
  - Google Gemini API
  - Anthropic Claude API
  - OpenAI API
  - Groq API
  - DeepSeek API
  - ElevenLabs API
  - Tavily Search API
  - OpenWeatherMap API
  - HuggingFace API

### Step 1: Clone the Repository
```bash
git clone https://github.com/Sumon1141/sumon-ai-automation.git
cd sumon-ai-automation
```

### Step 2: Open in Android Studio
1. Launch Android Studio
2. Click **File → Open**
3. Select the `sumon-ai-automation` directory
4. Wait for Gradle to sync

### Step 3: Build the APK

#### Option A: Debug APK (For Testing)
```bash
./gradlew assembleDebug
```
The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

#### Option B: Release APK (For Production)
```bash
./gradlew assembleRelease
```
The APK will be generated at: `app/build/outputs/apk/release/app-release.apk`

#### Option C: Build Using Android Studio
1. Navigate to **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait for the build to complete
3. Click **Locate** to open the APK folder

### Step 4: Install on Android Device

#### USB Connection Method
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

#### Manual Installation
1. Transfer the APK file to your Android device
2. Open file manager and tap the APK
3. Tap **Install**
4. Grant necessary permissions

---

## 🔑 Configuring API Keys

### How to Add API Keys

1. **Launch Sumon AI** on your Android device
2. Tap **🔑 API Key Manager** button
3. Enter your API keys for each service:
   - **Gemini API**: https://ai.google.dev/
   - **Claude API**: https://console.anthropic.com/
   - **OpenAI API**: https://platform.openai.com/
   - **Groq API**: https://console.groq.com/
   - **DeepSeek API**: https://www.deepseek.com/
   - **ElevenLabs API**: https://elevenlabs.io/
   - **Tavily API**: https://tavily.com/
   - **OpenWeatherMap API**: https://openweathermap.org/api
   - **HuggingFace API**: https://huggingface.co/
4. Tap **💾 Save All API Keys**
5. Keys are stored in encrypted SharedPreferences

⚠️ **Security Note**: API keys are encrypted using Android's Security library (AES-256-GCM)

---

## 📲 Enabling Accessibility Service (CRITICAL)

The Accessibility Service is required for:
- Screen automation (tap, scroll, type)
- App automation (WhatsApp, Facebook, Telegram)
- System control (Wi-Fi, Bluetooth, volume)

### Manual Activation
1. On your Android device, open **Settings**
2. Navigate to **Accessibility → Services**
3. Find **Sumon AI** in the list
4. Toggle **ON**
5. Tap **Allow** on the permission popup

### In-App Activation
1. Open **Sumon AI**
2. If accessibility is not enabled, you'll see a warning
3. Tap **Enable Accessibility Service** button
4. This will redirect you to Settings → Accessibility → Services
5. Find **Sumon AI** and enable it

---

## 🎤 Voice Command Examples

### English Commands
```
"Send WhatsApp message to John: Hello"
"What's the weather today?"
"Search for best restaurants near me"
"Toggle Wi-Fi"
"Read my notifications"
"Open Facebook"
"Set alarm for 7 AM"
```

### Bengali Commands (bn-BD)
```
"হোয়াটসঅ্যাপে জনকে বার্তা পাঠাও"
"আজকের আবহাওয়া কেমন?"
"আমার কাছাকাছি রেস্তোরাঁ খুঁজুন"
"ওয়াই-ফাই টগল করো"
"আমার বিজ্ঞপ্তি পড়ুন"
"ফেসবুক খুলুন"
```

---

## ⚙️ Architecture Overview

### Core Components

#### 1. **MainActivity** (`MainActivity.kt`)
- Main UI entry point
- Voice input trigger
- System status display
- Settings navigation

#### 2. **API Manager** (`api/ApiManager.kt`)
- Multi-LLM routing
- API key management
- Fallback engine logic
- HTTP client configuration

#### 3. **Accessibility Service** (`services/AutomationAccessibilityService.kt`)
- Screen automation
- UI element detection
- Touch simulation
- Text input
- App package management

#### 4. **Voice Command Service** (`services/VoiceCommandService.kt`)
- Speech-to-Text (STT)
- Language detection (en-US, bn-BD)
- Command parsing
- Intent routing

#### 5. **AI Agent Service** (`services/AiAgentService.kt`)
- Intent understanding
- Action planning
- Command execution
- Response generation

#### 6. **Encrypted Preferences** (`security/EncryptedPreferences.kt`)
- Secure API key storage
- AES-256-GCM encryption
- User preference management

---

## 📂 Project Structure

```
sumon-ai-automation/
├── app/
│   ├── src/main/
│   │   ├── java/com/sumonai/automation/
│   │   │   ├── MainActivity.kt
│   │   │   ├── api/
│   │   │   │   └── ApiManager.kt
│   │   │   ├── services/
│   │   │   │   ├── AutomationAccessibilityService.kt
│   │   │   │   ├── VoiceCommandService.kt
│   │   │   │   └── AiAgentService.kt
│   │   │   ├── ui/
│   │   │   │   ├── SettingsActivity.kt
│   │   │   │   └── ApiKeyManagerActivity.kt
│   │   │   └── security/
│   │   │       └── EncryptedPreferences.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_settings.xml
│   │   │   │   └── activity_api_key_manager.xml
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   └── colors.xml
│   │   │   └── xml/
│   │   │       └── accessibility_service_config.xml
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 🔄 Fallback Engine Logic

When a command is received, the AI tries services in this order:

```
1. Google Gemini (Primary)
   ↓ (if fails or rate limited)
2. Anthropic Claude
   ↓ (if fails or rate limited)
3. OpenAI GPT-4o
   ↓ (if fails or rate limited)
4. Groq (Ultra-fast)
   ↓ (all failed)
   → Return error message
```

---

## 🛠️ Troubleshooting

### Problem: "Accessibility Service not enabled"
**Solution:**
1. Go to Settings → Accessibility → Services
2. Find "Sumon AI" and enable it
3. Restart the app

### Problem: "API Key error"
**Solution:**
1. Verify API key is correct
2. Check if service is active (not rate limited)
3. Try alternative API key in fallback service
4. Go to API Key Manager and re-enter the key

### Problem: "Voice input not working"
**Solution:**
1. Check microphone permission: Settings → Permissions → Microphone
2. Test microphone in another app
3. Ensure language is set correctly (English or Bengali)

### Problem: "App crashes on startup"
**Solution:**
1. Clear app cache: Settings → Apps → Sumon AI → Storage → Clear Cache
2. Clear app data: Settings → Apps → Sumon AI → Storage → Clear Storage
3. Reinstall the app

---

## 📋 Permissions Explained

| Permission | Purpose |
|---|---|
| `INTERNET` | API calls to LLM services |
| `RECORD_AUDIO` | Voice input recognition |
| `BIND_ACCESSIBILITY_SERVICE` | Screen automation |
| `SYSTEM_ALERT_WINDOW` | Floating UI elements |
| `CHANGE_WIFI_STATE` | Wi-Fi toggle |
| `BLUETOOTH` | Bluetooth control |
| `SEND_SMS` | WhatsApp/SMS integration |
| `READ_CONTACTS` | Contact search |
| `ACCESS_FINE_LOCATION` | Weather location |

---

## 🚀 Deployment

### Google Play Store
1. Create a signed APK: `./gradlew assembleRelease`
2. Create Google Play Developer account
3. Upload APK to Play Console
4. Fill in app details, screenshots, privacy policy
5. Submit for review

### Direct Distribution
1. Build release APK
2. Host on cloud storage or GitHub Releases
3. Share APK download link with users

---

## 📝 Future Enhancements

- [ ] OCR integration for document reading
- [ ] Custom voice model training
- [ ] Offline mode with edge AI
- [ ] Machine learning for personalized commands
- [ ] Multi-user support
- [ ] Advanced gesture recognition
- [ ] Real-time translation
- [ ] Screen recording for automation logs

---

## 📄 License
Apache License 2.0 - See LICENSE file for details

---

## 👨‍💻 Developer
**Sumon** (@Sumon1141)
- GitHub: https://github.com/Sumon1141
- Email: mdsumon0000000111111@gmail.com

---

## 🤝 Contributing
Contributions are welcome! Feel free to:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

---

## ⚖️ Disclaimer

⚠️ **Important:**
- This app requires Accessibility Service permissions for automation
- Use responsibly and ethically
- Never use for unauthorized access or automation of others' devices
- Keep your API keys secure and never share them
- Respect app Terms of Service (WhatsApp, Facebook, etc.)

---

## 📞 Support

For issues, suggestions, or feature requests:
1. Open an issue on GitHub
2. Provide detailed error logs
3. Describe your device and Android version

---

**Happy Automating! 🎉**
