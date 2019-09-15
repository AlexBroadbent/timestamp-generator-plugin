package io.github.ajab.tsgen.config

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ConfigConfigurable : Configurable {

    private var configForm: ConfigForm? = null

    override fun createComponent(): JComponent? {
        configForm = configForm ?: ConfigForm()
        return configForm?.component()
    }

    override fun isModified(): Boolean {
        return configForm?.isModified ?: false
    }

    override fun apply() {
        val settings = TimestampGeneratorSettings.instance
        configForm?.applyToConfigForm(settings)
    }

    override fun reset() {
        configForm?.loadSettings()
    }

    override fun disposeUIResources() {
        configForm = null
    }

    override fun getDisplayName(): String = "Timestamp Generator"
}
