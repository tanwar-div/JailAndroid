// D:/Testrnativedir/lola/android/app/src/main/java/com/lola/MyDeviceAdminReceiver.kt

package com.lola

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyDeviceAdminReceiver : DeviceAdminReceiver() {

    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        Log.d("DeviceAdmin", "Device Administrator enabled for ${context.packageName}")
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
        Log.d("DeviceAdmin", "Device Administrator disabled for ${context.packageName}")
    }
    
    // You can add overrides for other events like onPasswordChanged, etc., here if needed.
}