package io.github.ajab.tsgen.config

import com.intellij.openapi.ui.ComboBox
import io.github.ajab.tsgen.TimestampGenerator
import javax.swing.*

class ConfigForm {

    private var panel: JPanel? = null
    private var previewLabel: JLabel? = null
    private var format: JComboBox<TimestampFormat>? = null

    private val settings = TimestampGeneratorSettings.instance

    init {
        loadSettings()
    }

    val isModified: Boolean
        get() = getSelectedFormat() != settings.format

    fun loadSettings() {
        format?.selectedItem = settings.format

        listOfNotNull(
            format
        ).forEach { it.addItemListener { updatePreviewLabel() } }

        updatePreviewLabel()
    }

    fun applyToConfigForm(settings: TimestampGeneratorSettings) {
        settings.format = getSelectedFormat()
    }

    fun component(): JComponent? = panel

    private fun getSelectedFormat(): TimestampFormat =
        format?.selectedItem as? TimestampFormat ?: TimestampFormat.ISO_8601

    private fun updatePreviewLabel() {
        val previewSettings = TimestampGeneratorSettings()
        applyToConfigForm(previewSettings)
        previewLabel?.text = TimestampGenerator.generate(settings)
    }

    private fun createUIComponents() {
        format = ComboBox(DefaultComboBoxModel<TimestampFormat>(TimestampFormat.values()))
    }
}
