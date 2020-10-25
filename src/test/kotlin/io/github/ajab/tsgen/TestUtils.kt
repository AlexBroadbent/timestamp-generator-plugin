package io.github.ajab.tsgen

import io.github.ajab.tsgen.config.TimestampFormat
import io.github.ajab.tsgen.config.TimestampGeneratorSettings

fun settings(
    format: TimestampFormat = TimestampFormat.ISO_8601
) = TimestampGeneratorSettings.create(format)