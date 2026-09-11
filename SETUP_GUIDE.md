# Sumon AI - Installation & Setup Guide

## 📦 System Requirements

- **Android Device:** Android 8.0 (API Level 26) or higher
- **RAM:** Minimum 2GB (4GB+ recommended)
- **Storage:** 100MB free space
- **Internet:** Active Wi-Fi or mobile data connection

---

## 🔧 Build Instructions

### Using Android Studio (Recommended)

1. **Clone Repository:**
   ```bash
   git clone https://github.com/Sumon1141/sumon-ai-automation.git
   cd sumon-ai-automation
   ```

2. **Open Project:**
   - Launch Android Studio
   - File → Open → Select the project directory
   - Wait for Gradle sync to complete

3. **Build APK:**
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
   - OR use command:
   ```bash
   ./gradlew assembleDebug
   ```

4. **Run on Device:**
   - Connect Android device via USB
   - Enable USB Debugging (Settings → Developer Options → USB Debugging)
   - Click "Run" button in Android Studio
   - OR use command:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

### Using Command Line

```bash
# Clone repository
git clone https://github.com/Sumon1141/sumon-ai-automation.git
cd sumon-ai-automation

# Build debug APK
./gradlew assembleDebug

# Build release APK (requires signing key)
./gradlew assembleRelease

# Install on device
adb install app/build/outputs/apk/debug/app-debug.apk

# Launch app
adb shell am start -n com.sumonai.automation/.MainActivity
```

---

## ⚙️ Configuration Steps

### Step 1: Grant Accessibility Permission

**On Your Android Device:**
1. Open **Settings**
2. Go to **Accessibility**
3. Find **Services** section
4. Look for **"Sumon AI"** or **"Accessibility Service"**
5. Tap to open its settings
6. Toggle **"ON"**
7. Tap **"Allow"** on the permission prompt
8. Return to the app

**OR In-App:**
1. Open Sumon AI
2. If accessibility is disabled, tap **"Enable Accessibility Service"** button
3. Tap **"Allow"** on the settings redirect

### Step 2: Input API Keys

**Get Your API Keys:**

| Service | Website | Free Tier |
|---------|---------|----------|
| Google Gemini | https://ai.google.dev/ | Yes (60 requests/min) |
| Claude | https://console.anthropic.com/ | Yes ($5 free credit) |
| OpenAI | https://platform.openai.com/ | Yes ($5 free credit) |
| Groq | https://console.groq.com/ | Yes (unlimited for registered users) |
| DeepSeek | https://www.deepseek.com/ | Yes (free trial) |
| ElevenLabs | https://elevenlabs.io/ | Yes (10k free characters) |
| Tavily | https://tavily.com/ | Yes (1k free searches/month) |
| OpenWeatherMap | https://openweathermap.org/api | Yes (free tier available) |
| HuggingFace | https://huggingface.co/ | Yes (free access) |

**In Sumon AI App:**
1. Tap **"🔑 API Key Manager"** button
2. Enter each API key in its field
3. Fields are optional - app works with any combination
4. Tap **"💾 Save All API Keys"**
5. Keys are encrypted and stored securely

### Step 3: Grant Required Permissions

When prompted, grant these permissions:
- ✅ Microphone (for voice input)
- ✅ Contacts (for WhatsApp search)
- ✅ Location (for weather)
- ✅ Storage (for file operations)

**To manage permissions later:**
1. Settings → Apps → Sumon AI
2. Tap "Permissions"
3. Enable/disable as needed

### Step 4: Configure Settings

1. Open Sumon AI
2. Tap **"⚙️ Settings"** button
3. Select **Language:** English (en-US) or Bengali (bn-BD)
4. Select **Primary AI Model:** Gemini, Claude, or OpenAI
5. Toggle optional features:
   - Enable Accessibility Automation
   - Enable Web Search Integration
   - Enable Weather Updates
6. Tap **"Save Settings"**

---

## 🎤 Testing Voice Commands

### Test Basic Recognition
1. Tap **"🎤 Start Voice Command"** button
2. Say: "Hello" or "নমস্কার" (Bengali)
3. App should recognize and respond

### Test WhatsApp Automation (if enabled)
1. Say: "Send WhatsApp message to [Contact Name]: Hello"
2. App will:
   - Open WhatsApp
   - Search for contact
   - Type message
   - Send automatically

### Test Weather Command
1. Say: "What's the weather?"
2. App fetches location and weather data
3. Responds with temperature and conditions

### Test Web Search
1. Say: "Search for best restaurants"
2. App searches and returns results

---

## 🔐 Security Best Practices

1. **Protect Your API Keys:**
   - Never share API keys publicly
   - Regenerate keys if exposed
   - Use encrypted backups

2. **Device Security:**
   - Use strong PIN/password
   - Enable two-factor authentication
   - Keep Android updated

3. **App Permissions:**
   - Only grant necessary permissions
   - Review permission usage regularly
   - Disable unused features

4. **Data Privacy:**
   - API keys are encrypted with AES-256
   - No data is sent to Sumon servers
   - All processing is local or via your API accounts

---

## 🐛 Troubleshooting

### Issue: App Won't Install
**Solutions:**
- Check minimum Android version (8.0+)
- Free up storage space (at least 100MB)
- Clear Play Store cache: Settings → Apps → Play Store → Storage → Clear Cache
- Try sideloading the APK manually

### Issue: "Accessibility Service Not Enabled"
**Solutions:**
- Manually enable in Settings → Accessibility → Services
- Ensure you tap "Allow" on permission prompt
- Restart device if still not working

### Issue: Voice Recognition Not Working
**Solutions:**
- Check microphone permission in Settings → Permissions
- Test microphone with another app
- Ensure device has internet connection
- Select correct language in Settings

### Issue: API Key Errors
**Solutions:**
- Verify API key is copied correctly (no spaces)
- Check if API service is active and not rate limited
- Try alternative LLM from fallback engine
- Test API key on service's website

### Issue: WhatsApp Automation Fails
**Solutions:**
- Ensure WhatsApp is installed and updated
- Grant all app permissions to Sumon AI
- Enable Accessibility Service
- Try with exact contact name
- Ensure WhatsApp account is set up

### Issue: App Crashes on Startup
**Solutions:**
```bash
# Clear app data
adb shell pm clear com.sumonai.automation

# Clear cache
adb shell pm cache com.sumonai.automation

# Reinstall app
adb uninstall com.sumonai.automation
adb install app/build/outputs/apk/debug/app-debug.apk
```

---

## 📊 System Status Information

App displays real-time status:
- ✅ Accessibility Service status
- 📱 Wi-Fi connection status
- 🔵 Bluetooth status
- 🔊 Volume level

Tap **"Refresh System Status"** to update information.

---

## 🌍 Language Support

### English (en-US)
- Voice input: "What's the weather?"
- Voice input: "Send WhatsApp message to John"

### Bengali (bn-BD)
- কমান্ড: "আবহাওয়া কি?"
- কমান্ড: "জনকে হোয়াটসঅ্যাপ বার্তা পাঠাও"

**To change language:**
1. Open Settings
2. Select Language: Bengali (bn-BD) or English (en-US)
3. Save and restart app

---

## 📞 Contact & Support

- **GitHub Issues:** https://github.com/Sumon1141/sumon-ai-automation/issues
- **Email:** mdsumon0000000111111@gmail.com
- **GitHub Profile:** https://github.com/Sumon1141

---

## ✅ Verification Checklist

Before using Sumon AI, ensure:
- [ ] Android device is Android 8.0+
- [ ] Accessibility Service is enabled
- [ ] Microphone permission granted
- [ ] At least one API key added
- [ ] Internet connection is active
- [ ] App can recognize voice commands
- [ ] Settings saved successfully

---

**Ready to automate? Start using Sumon AI now! 🚀**
