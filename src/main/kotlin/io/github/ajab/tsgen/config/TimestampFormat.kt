package io.github.ajab.tsgen.config

import java.time.format.DateTimeFormatter

enum class TimestampFormat(
    val title: String,
    val formatter: DateTimeFormatter
) {

    ISO_8601("ISO-8601", DateTimeFormatter.ISO_DATE_TIME),
    ISO_LOCAL_DATE("ISO_LOCAL_DATE", DateTimeFormatter.ISO_LOCAL_DATE),
    ISO_LOCAL_TIME("ISO_LOCAL_TIME", DateTimeFormatter.ISO_LOCAL_TIME),
    ISO_LOCAL_DATE_TIME("ISO_LOCAL_DATE_TIME", DateTimeFormatter.ISO_LOCAL_DATE_TIME),
    ISO_INSTANT("ISO-INSTANT", DateTimeFormatter.ISO_INSTANT),
    RFC_1123_DATE_TIME("RFC_1123_DATE_TIME", DateTimeFormatter.ISO_INSTANT),
    ISO_ZONED_DATE_TIME("ISO_ZONED_DATE_TIME", DateTimeFormatter.ISO_ZONED_DATE_TIME),
}
