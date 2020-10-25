package io.github.ajab.tsgen.config

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class ConfigConfigurable : Configurable {

    private var settingsForm: SettingsForm? = null

    override fun createComponent(): JComponent? {
        settingsForm = settingsForm ?: SettingsForm()
        return settingsForm?.component()
    }

    override fun isModified(): Boolean {
        return settingsForm?.isModified ?: false
    }

    override fun apply() {
        val settings = TimestampGeneratorSettings.instance
        settingsForm?.applyConfigFormToSettings(settings)
    }

    override fun reset() {
        settingsForm?.loadSettings()
    }

    override fun disposeUIResources() {
        settingsForm = null
    }

    @Nls
    override fun getDisplayName(): String = "Timestamp Generator"
}
