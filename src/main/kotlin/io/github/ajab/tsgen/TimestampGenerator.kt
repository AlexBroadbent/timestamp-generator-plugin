package io.github.ajab.tsgen

import io.github.ajab.tsgen.config.TimestampFormat
import io.github.ajab.tsgen.config.TimestampGeneratorSettings
import java.time.Instant

object TimestampGenerator {

    fun generate(): String = Instant.now().toString()

    fun generate(format: TimestampFormat): String = format.formatter.format(Instant.now())

    fun generate(settings: TimestampGeneratorSettings): String = settings.format.formatter.format(Instant.now())
}
