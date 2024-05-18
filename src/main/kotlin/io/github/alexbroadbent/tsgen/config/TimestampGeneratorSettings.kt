package io.github.alexbroadbent.tsgen.config

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.components.SimplePersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import java.time.format.DateTimeFormatter

interface TimestampFormatSettings {
    fun title(): String
    fun formatter(): DateTimeFormatter
}

class TimestampFormatState : BaseState() {
    var format by enum<TimestampFormatTitle>(TimestampFormatTitle.ISO_8601)
}

@State(name = "TimestampSettings", storages = [(Storage("timestamp_generator.xml"))])
class TimestampGeneratorSettings : SimplePersistentStateComponent<TimestampFormatState>(TimestampFormatState()), TimestampFormatSettings {

    companion object {
        val instance: TimestampGeneratorSettings
            get() = ApplicationManager.getApplication().getService(TimestampGeneratorSettings::class.java)
    }

    var format: TimestampFormat
        get() = TimestampFormatMap.getFormat(state.format)
        set(value) {
            state.format = value.title
        }

    override fun title(): String = format.title.title

    override fun formatter(): DateTimeFormatter = format.format
}
