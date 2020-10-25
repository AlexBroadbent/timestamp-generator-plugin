package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampFormatMap
import io.github.alexbroadbent.tsgen.config.TimestampFormatTitle
import io.github.alexbroadbent.tsgen.config.TimestampGeneratorSettings

fun settings(
    title: TimestampFormatTitle = TimestampFormatTitle.ISO_8601
) = TimestampGeneratorSettings.create(TimestampFormatMap.getFormat(title))