Scroll Block
============

Overview
--------

Scroll Block is a modern, open-source Android distraction blocker designed to reduce doom scrolling by blocking infinite short-form content on platforms like YouTube Shorts and Instagram. Enjoy a clean, Material You experience. No root required.

Caution
-------

Google Play Protect is blocking some people from installing/updating Scroll Block because it uses **Accessibility Permission**. It uses a false pretext of _"this app may try to access sensitive information"_ without any concrete basis.

If this happens to you, consider [**temporarily disabling Play Protect**](https://www.airdroid.com/quick-guides/disable-google-play-protect) during installation. You can enable it again afterward.

We understand this introduces unnecessary friction, but there is nothing we can do about it. Google does not favor third-party apps that fill gaps in its own ecosystem.

Direct Download
---------------


Allow the permissions in app before setting up block time.
[Click here](https://drive.google.com/file/d/1gZaUpwJUCuZikivDbmOXITiQRoFyu80E/view?usp=sharing) to download the release apk directly.

If you want to build the apk yourself, follow the following steps:
------------------------------------------------------------------

Tech Stack
----------

*   React Native
    
*   Android (Gradle)
    
*   JavaScript / TypeScript
    

Prerequisites
-------------

*   Node.js (LTS)
    
*   npm or yarn
    
*   Android Studio
    
*   Android SDK & Emulator or Physical Device
    
*   JDK 17+
    

Clone the Repository
--------------------

```
git clone https://github.com/tanwar-div/JailAndroid
cd JailAndroid
```
Install Dependencies
--------------------

```
npm install
```

Permissions Required
--------------------

**Before setting up the app for the first time, the following permissions must be allowed:**

1.  **Accessibility Settings Permission** - Required for app locking functionality
    
2.  **Usage Access Permission** - Required to block delete.
    

These permissions are essential for AppLock to function properly and must be granted before proceeding with time configuration.

Run on Android (Debug)
----------------------

Make sure an emulator or physical device is running.

```
npx react-native run-android
```

Generate Debug APK
------------------

```
cd android
./gradlew assembleDebug
```

**APK output:**

```
android/app/build/outputs/apk/debug/app-debug.apk
```
Generate Release APK
--------------------

Navigate to android directory:

```
cd android
```

Build release APK:

```
./gradlew assembleRelease
```
**APK output:**

```
android/app/build/outputs/apk/release/app-release.apk
```
(Optional) Clean Build
----------------------

```
cd android
./gradlew clean
```

Permissions Used
----------------

*   **Accessibility Settings Permission** - Required for app locking functionality
    
*   **Usage Access Permission** - Required to block delete.
