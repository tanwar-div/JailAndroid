// com/your-app/MyPackage.kt
package com.lola

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.fbreact.specs.NativeSampleModuleSpec
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class MyPackage : TurboReactPackage() {
    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
        return if (name == NativeSampleModuleSpec.NAME) {
            SampleModule(reactContext)
        } else {
            null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        return ReactModuleInfoProvider {
            mapOf(
                NativeSampleModuleSpec.NAME to ReactModuleInfo(
                    NativeSampleModuleSpec.NAME,
                    NativeSampleModuleSpec.NAME,
                    false, // canOverrideExistingModule
                    false, // needsEagerInit
                    true,  // hasConstants
                    false, // isCxxModule
                    true   // isTurboModule
                )
            )
        }
    }
}