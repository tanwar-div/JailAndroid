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
            if(feat_working == false){
                return
            }
            
            if(lastime + blocktime < System.currentTimeMillis()){
                return
            }

            val packageName = it.packageName?.toString() ?: "N/A"

            val contentDesc = event.contentDescription?.toString()

            val className = it.className?.toString() ?: "N/A"

            val firstText = it.text?.firstOrNull()?.toString() ?: "N/A"

            val requiredFlags = AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT or AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE

            if((packageName == "com.instagram.android" && contentDesc != null && contentDesc.contains("Reels")) || ((packageName == "com.google.android.youtube" || packageName == "com.android.youtube") && (event.contentChangeTypes == requiredFlags))){
                performGlobalAction(GLOBAL_ACTION_BACK)
                toastput("Get back to work fatso!")
            }

            // if((packageName == "com.instagram.android" && contentDesc != null && contentDesc.contains("Reels")) || (firstText == "Shorts" && (packageName == "com.google.android.youtube" || packageName == "com.android.youtube") && className == "android.widget.Button")){
            //     performGlobalAction(GLOBAL_ACTION_BACK)
            // }
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
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
    
    override fun onInterrupt() {
    }
}