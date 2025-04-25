package com.mkapps.habitflow.util

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

object LocaleUtils {
    fun applyLocale(base: Context, langCode: String): Context {
        val locale = Locale(langCode)
        Locale.setDefault(locale)

        val config = Configuration(base.resources.configuration).apply {
            setLocale(locale)
        }

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            base.createConfigurationContext(config)
        } else {
            @Suppress("DEPRECATION")
            base.resources.updateConfiguration(config, base.resources.displayMetrics)
            base
        }
    }
}