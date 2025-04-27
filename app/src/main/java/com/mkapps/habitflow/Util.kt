package com.mkapps.habitflow

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocaleUtils {
    fun applyLocale(base: Context, langCode: String): Context {
        val locale = Locale(langCode)
        Locale.setDefault(locale)

        val config = Configuration(base.resources.configuration).apply {
            setLocale(locale)
        }

        return base.createConfigurationContext(config)
    }
}