package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampGeneratorSettings
import java.time.Instant

object TimestampGenerator {

    fun generateTimestamp(
        instant: Instant = Instant.now(),
        settings: TimestampGeneratorSettings = TimestampGeneratorSettings.instance
    ): String = settings.formatter().format(instant)
}
