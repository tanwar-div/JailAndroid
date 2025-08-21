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
            val eva = it.toString()
            //toastput(eva)
            //appendToFile(this, "logcheck.txt", eva)

            val packageName = it.packageName?.toString() ?: "N/A"

            val className = it.className?.toString() ?: "N/A"

            val firstText = it.text?.firstOrNull()?.toString() ?: "N/A"
            if(firstText == "Shorts" && (packageName == "com.google.android.youtube" || packageName == "com.android.youtube") && className == "android.widget.Button"){
                toastput("onetime")
            }
            
            /* if (it.eventType == AccessibilityEvent.TYPE_VIEW_CLICKED ||
                it.eventType == AccessibilityEvent.TYPE_VIEW_SELECTED) {
                val triggeredText = it.text?.joinToString().orEmpty()
                val contentDesc = it.contentDescription?.toString().orEmpty()
                toastput(triggeredText)
                toastput(contentDesc)
            }
            val packageName = it.packageName
            if (packageName == "com.android.chrome" || packageName == "com.google.android.youtube") {
                val packageName = it.packageName
                // {
                    // YouTube app has been opened - execute your function
                  //  toastput(packageName)
                //}
                val anotherone = packageName?.toString() ?: "yada"
                


                //--------------------------------------------------------------------------------

                val root = rootInActiveWindow
                root?.let {
                    findShortsTab(it)
                }
            } */
        }
    }

    fun findShortsTab(node: AccessibilityNodeInfo) {
        if ((node.text?.contains("Shorts", ignoreCase=true) == true) ||
            (node.contentDescription?.contains("Shorts", ignoreCase=true) == true)) {
            toastput("found shorts")
            // You may perform actions or highlight the node
        }
        
        for (i in 0 until node.childCount) {
            node.getChild(i)?.let { findShortsTab(it) }
        }
    }  

    fun appendToFile(context: Context, filename: String, content: String) {
        try {
            val file = File(context.filesDir, filename)
            // Add a newline before the new content for better formatting
            file.appendText("\n\n\n\n\n$content")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    } 
    
    private fun toastput(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    
    override fun onInterrupt() {
        // Required override - handle accessibility interruption
    }
}
