package com.lola

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.util.Log
import android.widget.Toast 

class MyAccessibilityService : AccessibilityService() {
    
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            if (it.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                val packageName = it.packageName
                if (packageName == "com.android.chrome") {
                    // YouTube app has been opened - execute your function
                    onYouTubeOpened()
                }
            }
        }
    }
    
    private fun onYouTubeOpened() {
        Toast.makeText(this, "YouTube function ran!", Toast.LENGTH_SHORT).show()
    }
    
    override fun onInterrupt() {
        // Required override - handle accessibility interruption
    }
}
