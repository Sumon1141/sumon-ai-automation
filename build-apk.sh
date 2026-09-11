#!/bin/bash

# Sumon AI - Automatic APK Builder & Installer
# This script builds and installs the APK automatically

echo "🚀 Sumon AI - APK Builder"
echo "========================="

# Step 1: Clone repo if not exists
if [ ! -d "sumon-ai-automation" ]; then
    echo "📥 Cloning repository..."
    git clone https://github.com/Sumon1141/sumon-ai-automation.git
fi

cd sumon-ai-automation

# Step 2: Build APK
echo "🔨 Building APK..."
./gradlew assembleDebug

# Step 3: Get APK path
APK_PATH="app/build/outputs/apk/debug/app-debug.apk"

if [ -f "$APK_PATH" ]; then
    echo "✅ APK Built Successfully!"
    echo "📂 Location: $APK_PATH"
    echo ""
    echo "Next steps:"
    echo "1. Transfer this APK to your Android phone"
    echo "2. Open file manager and tap the APK"
    echo "3. Tap 'Install'"
    echo ""
    echo "OR install via ADB:"
    echo "  adb install $APK_PATH"
else
    echo "❌ Build failed. Check errors above."
    exit 1
fi

echo ""
echo "🎉 Done!"
