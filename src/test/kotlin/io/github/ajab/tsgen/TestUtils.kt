package io.github.ajab.tsgen

import io.github.ajab.tsgen.config.TimestampFormatMap
import io.github.ajab.tsgen.config.TimestampFormatTitle
import io.github.ajab.tsgen.config.TimestampGeneratorSettings

fun settings(
    title: TimestampFormatTitle = TimestampFormatTitle.ISO_8601
) = TimestampGeneratorSettings.create(TimestampFormatMap.getFormat(title))