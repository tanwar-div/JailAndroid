package com.lola

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import android.accessibilityservice.AccessibilityService

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
    }

    fun openAccessibilitySettings(context: Context) {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

}