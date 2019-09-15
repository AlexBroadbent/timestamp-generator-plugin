package io.github.ajab.tsgen

import com.google.common.annotations.VisibleForTesting
import io.github.ajab.tsgen.config.TimestampFormat
import io.github.ajab.tsgen.config.TimestampGeneratorSettings
import java.time.Instant

object TimestampGenerator {

    private var fixedTime: Instant? = null

    fun generate(): String = getCurrentTime().toString()

    fun generate(format: TimestampFormat): String = format.formatter.format(getCurrentTime())

    fun generate(settings: TimestampGeneratorSettings): String = settings.format.formatter.format(getCurrentTime())

    @VisibleForTesting
    fun setFixedTime(fixedTime: Instant?) {
        this.fixedTime = fixedTime
    }

    private fun getCurrentTime() = fixedTime ?: Instant.now()

}
