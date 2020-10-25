package io.github.ajab.tsgen.config

import java.time.format.DateTimeFormatter

interface TimestampFormatSettings {

    fun title(): String

    fun formatter(): DateTimeFormatter
}