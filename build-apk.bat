@echo off
REM Sumon AI - Automatic APK Builder & Installer (Windows)
REM This batch script builds and installs the APK automatically

echo.
echo Sumon AI - APK Builder (Windows)
echo ==================================
echo.

REM Step 1: Clone repo if not exists
if not exist "sumon-ai-automation" (
    echo 📥 Cloning repository...
    git clone https://github.com/Sumon1141/sumon-ai-automation.git
)

cd sumon-ai-automation

REM Step 2: Build APK
echo 🔨 Building APK...
call gradlew.bat assembleDebug

REM Step 3: Get APK path
set APK_PATH=app\build\outputs\apk\debug\app-debug.apk

if exist "%APK_PATH%" (
    echo ✅ APK Built Successfully!
    echo 📂 Location: %APK_PATH%
    echo.
    echo Next steps:
    echo 1. Transfer this APK to your Android phone
    echo 2. Open file manager and tap the APK
    echo 3. Tap 'Install'
    echo.
    echo OR install via ADB:
    echo   adb install %APK_PATH%
) else (
    echo ❌ Build failed. Check errors above.
    exit /b 1
)

echo.
echo 🎉 Done!
pause
