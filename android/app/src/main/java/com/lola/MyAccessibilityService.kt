package com.lola

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.util.Log
import android.widget.Toast 
import android.view.accessibility.AccessibilityNodeInfo
import android.content.Context
import java.io.File

class MyAccessibilityService : AccessibilityService() {
    
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            val packageName = it.packageName?.toString() ?: "N/A"

            val contentDesc = event.contentDescription?.toString()

            val className = it.className?.toString() ?: "N/A"

            val firstText = it.text?.firstOrNull()?.toString() ?: "N/A"

            if((packageName == "com.instagram.android" && contentDesc != null && contentDesc.contains("Reels")) || (firstText == "Shorts" && (packageName == "com.google.android.youtube" || packageName == "com.android.youtube") && className == "android.widget.Button")){
                performGlobalAction(GLOBAL_ACTION_BACK)
            }
        }
    }

    fun findShortsTab(node: AccessibilityNodeInfo) {
        if ((node.text?.contains("Shorts", ignoreCase=true) == true) ||
            (node.contentDescription?.contains("Shorts", ignoreCase=true) == true)) {
            toastput("found shorts")
        }
        
        for (i in 0 until node.childCount) {
            node.getChild(i)?.let { findShortsTab(it) }
        }
    }  

    fun appendToFile(context: Context, filename: String, content: String) {
        try {
            val file = File(context.filesDir, filename)
            file.appendText("\n\n\n\n\n$content")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    } 
    
    private fun toastput(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    
    override fun onInterrupt() {
    }
}