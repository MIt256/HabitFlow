package com.mkapps.habitflow.core.util

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocaleUtil {
    fun applyLocale(base: Context, langCode: String): Context {
        val locale = Locale(langCode)
        Locale.setDefault(locale)

        val config = Configuration(base.resources.configuration).apply {
            setLocale(locale)
        }

        return base.createConfigurationContext(config)
    }
}