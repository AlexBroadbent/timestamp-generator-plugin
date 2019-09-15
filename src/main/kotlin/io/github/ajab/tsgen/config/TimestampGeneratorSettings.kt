package io.github.ajab.tsgen.config

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "Settings", storages = [(Storage("timestamp_generator.xml"))])
class TimestampGeneratorSettings : PersistentStateComponent<TimestampGeneratorSettings> {

    var format: TimestampFormat = TimestampFormat.ISO_8601

    override fun getState(): TimestampGeneratorSettings = this

    override fun loadState(state: TimestampGeneratorSettings) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        val instance: TimestampGeneratorSettings
            get() = ServiceManager.getService(TimestampGeneratorSettings::class.java)
    }
}
