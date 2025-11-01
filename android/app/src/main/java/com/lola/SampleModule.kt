package com.lola

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import android.accessibilityservice.AccessibilityService
import android.content.ComponentName // For ComponentName
import android.app.admin.DevicePolicyManager // For DevicePolicyManager

import com.facebook.fbreact.specs.NativeSampleModuleSpec

var feat_working: Boolean = false;
var blocktime: Double = 0.0;
var lastime: Double = 0.0;

@ReactModule(name = NativeSampleModuleSpec.NAME) 
class SampleModule(reactContext: ReactApplicationContext) : NativeSampleModuleSpec(reactContext) {

    override fun getName() = NativeSampleModuleSpec.NAME

    override fun reverseString(input: Boolean): Boolean {
        openAccessibilitySettings(reactApplicationContext)
        return true
    }

    override fun setsara(ab: Boolean, btime: Double){
        feat_working = ab
        blocktime = btime
        lastime = System.currentTimeMillis().toDouble()
        currentActivity?.let {
            requestDeviceAdminPermission(
                it,
                ComponentName(it, MyDeviceAdminReceiver::class.java),
                "We need this permission to block your access to distracting apps."
            )
        }
    }

    fun openAccessibilitySettings(context: Context) {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun requestDeviceAdminPermission(context: Context, adminComponent: ComponentName, explanation: String? = null) {
        val devicePolicyManager = reactApplicationContext.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
    
    // Corrected line 49: Use reactApplicationContext as the Context argument
    val adminComponent = ComponentName(reactApplicationContext, MyDeviceAdminReceiver::class.java)
    
    val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
        putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminComponent)
        putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Additional explanation why this admin is needed")
    }
        // val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        // intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminComponent)
        // explanation?.let {
        //     intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, it)
        // }
        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }


}