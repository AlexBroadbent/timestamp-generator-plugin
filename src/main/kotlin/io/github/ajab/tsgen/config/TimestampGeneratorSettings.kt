package io.github.ajab.tsgen.config

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import java.time.format.DateTimeFormatter

@State(name = "TimestampSettings", storages = [(Storage("timestamp_generator.xml"))])
class TimestampGeneratorSettings : PersistentStateComponent<TimestampGeneratorSettings>, TimestampFormatSettings {

    companion object {
        val instance: TimestampGeneratorSettings
            get() = ServiceManager.getService(TimestampGeneratorSettings::class.java)

        fun create(format: TimestampFormat) = TimestampGeneratorSettings().apply { this.format = format }
    }

    // default value
    var format: TimestampFormat = TimestampFormatMap.ISO_8601

    override fun getState(): TimestampGeneratorSettings = this

    override fun loadState(state: TimestampGeneratorSettings) {
        XmlSerializerUtil.copyBean(state, this)
    }

    override fun title(): String = format.title.title

    override fun formatter(): DateTimeFormatter = format.format
}
