package io.github.ajab.tsgen

import io.github.ajab.tsgen.config.TimestampGeneratorSettings
import java.time.Instant

object TimestampGenerator {

    fun generateTimestamp(
        instant: Instant = Instant.now(),
        settings: TimestampGeneratorSettings = TimestampGeneratorSettings.instance
    ): String = settings.formatter().format(instant)
}
