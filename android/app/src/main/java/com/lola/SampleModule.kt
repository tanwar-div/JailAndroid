package com.lola

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

import com.facebook.fbreact.specs.NativeSampleModuleSpec

@ReactModule(name = NativeSampleModuleSpec.NAME)
class SampleModule(reactContext: ReactApplicationContext) : NativeSampleModuleSpec(reactContext) {

    override fun getName() = NativeSampleModuleSpec.NAME

    override fun reverseString(input: String): String {
        return input.reversed()
    }
}