package io.github.alexbroadbent.tsgen.config

import com.intellij.openapi.ui.ComboBox
import io.github.alexbroadbent.tsgen.TimestampGenerator
import java.time.Instant
import javax.swing.DefaultComboBoxModel
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class SettingsForm {

    private val previewTimestamp = Instant.now()
    private val settings = TimestampGeneratorSettings.instance

    private var panel: JPanel? = null
    private var previewLabel: JLabel? = null
    private var formatComboBox: JComboBox<TimestampFormatTitle>? = null

    init {
        loadSettings()
    }

    fun loadSettings() {
        formatComboBox?.selectedItem = settings.format.title

        sequenceOf(
            formatComboBox
        ).filterNotNull().forEach {
            it.addActionListener {
                updatePreviewLabel()
            }
        }

        updatePreviewLabel()
    }

    private fun updatePreviewLabel() {
        val previewSettings = TimestampGeneratorSettings()
        applyConfigFormToSettings(previewSettings)
        previewLabel?.text =
            TimestampGenerator.generateTimestamp(instant = previewTimestamp, settings = previewSettings)
    }

    fun applyConfigFormToSettings(settings: TimestampGeneratorSettings) {
        settings.format = getSelectedFormat()
    }

    fun component(): JComponent? = panel

    private fun createUIComponents() {
        formatComboBox = ComboBox(DefaultComboBoxModel(TimestampFormatTitle.values()))
    }

    private fun getSelectedFormat(): TimestampFormat =
        TimestampFormatMap.getFormat(
            formatComboBox?.selectedItem as? TimestampFormatTitle ?: TimestampFormatTitle.ISO_8601
        )

    val isModified: Boolean
        get() = getSelectedFormat() != settings.format
}
