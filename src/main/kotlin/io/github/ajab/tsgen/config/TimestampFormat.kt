package io.github.ajab.tsgen.config

import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

enum class TimestampFormat(
    val title: String,
    val formatter: DateTimeFormatter
) {

    ISO_8601("ISO 8601", DateTimeFormatter.ISO_DATE_TIME.addLocaleAndZone()),
    ISO_LOCAL_DATE("ISO Local Date", DateTimeFormatter.ISO_LOCAL_DATE.addLocaleAndZone()),
    ISO_LOCAL_TIME("ISO Local Time", DateTimeFormatter.ISO_LOCAL_TIME.addLocaleAndZone()),
    ISO_LOCAL_DATE_TIME("ISO Local Date Time", DateTimeFormatter.ISO_LOCAL_DATE_TIME.addLocaleAndZone()),
    ISO_INSTANT("ISO Instant", DateTimeFormatter.ISO_INSTANT.addLocaleAndZone()),
    RFC_1123_DATE_TIME("RFC11123 Date Time", DateTimeFormatter.ISO_INSTANT.addLocaleAndZone()),
    ISO_ZONED_DATE_TIME("ISO Zoned Date Time", DateTimeFormatter.ISO_ZONED_DATE_TIME.addLocaleAndZone());
}

private fun DateTimeFormatter.addLocaleAndZone() = this.withLocale(Locale.UK).withZone(ZoneOffset.UTC)
