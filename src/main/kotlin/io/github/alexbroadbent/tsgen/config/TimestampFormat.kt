package io.github.alexbroadbent.tsgen.config

import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.SignStyle
import java.time.temporal.ChronoField
import java.util.Locale

class TimestampFormat(
    val title: TimestampFormatTitle,
    val format: DateTimeFormatter
)

object TimestampFormatMap {

    val ISO_8601 = TimestampFormat(TimestampFormatTitle.ISO_8601, DateTimeFormatter.ISO_DATE_TIME.addLocaleAndZone())

    private val EPOCH_SECONDS_FORMATTER = DateTimeFormatterBuilder()
        .appendValue(ChronoField.INSTANT_SECONDS, 1, 19, SignStyle.NEVER)
        .toFormatter()
    private val EPOCH_MILLISECONDS_FORMATTER = DateTimeFormatterBuilder()
        .appendValue(ChronoField.INSTANT_SECONDS, 1, 19, SignStyle.NEVER)
        .appendValue(ChronoField.MILLI_OF_SECOND, 3)
        .toFormatter()

    private val map: Map<TimestampFormatTitle, DateTimeFormatter> = mapOf(
        TimestampFormatTitle.ISO_8601 to DateTimeFormatter.ISO_DATE_TIME.addLocaleAndZone(),
        TimestampFormatTitle.ISO_LOCAL_DATE to DateTimeFormatter.ISO_LOCAL_DATE.addLocaleAndZone(),
        TimestampFormatTitle.ISO_LOCAL_TIME to DateTimeFormatter.ISO_LOCAL_TIME.addLocaleAndZone(),
        TimestampFormatTitle.ISO_LOCAL_DATE_TIME to DateTimeFormatter.ISO_LOCAL_DATE_TIME.addLocaleAndZone(),
        TimestampFormatTitle.ISO_INSTANT to DateTimeFormatter.ISO_INSTANT.addLocaleAndZone(),
        TimestampFormatTitle.RFC_1123_DATE_TIME to DateTimeFormatter.ISO_INSTANT.addLocaleAndZone(),
        TimestampFormatTitle.ISO_ZONED_DATE_TIME to DateTimeFormatter.ISO_ZONED_DATE_TIME.addLocaleAndZone(),
        TimestampFormatTitle.EPOCH_SECONDS to EPOCH_SECONDS_FORMATTER.addLocaleAndZone(),
        TimestampFormatTitle.EPOCH_MILLISECONDS to EPOCH_MILLISECONDS_FORMATTER.addLocaleAndZone(),
    )

    fun getFormat(title: TimestampFormatTitle): TimestampFormat =
        TimestampFormat(title, map[title] ?: error("Unknown format"))
}

private fun DateTimeFormatter.addLocaleAndZone() = this.withLocale(Locale.UK).withZone(ZoneOffset.UTC)

enum class TimestampFormatTitle(val title: String) {
    ISO_8601("ISO 8601"),
    ISO_LOCAL_DATE("ISO Local Date"),
    ISO_LOCAL_TIME("ISO Local Time"),
    ISO_LOCAL_DATE_TIME("ISO Local Date Time"),
    ISO_INSTANT("ISO Instant"),
    RFC_1123_DATE_TIME("RFC11123 Date Time"),
    ISO_ZONED_DATE_TIME("ISO Zoned Date Time"),
    EPOCH_SECONDS("Epoch Seconds"),
    EPOCH_MILLISECONDS("Epoch Milliseconds"),
}
