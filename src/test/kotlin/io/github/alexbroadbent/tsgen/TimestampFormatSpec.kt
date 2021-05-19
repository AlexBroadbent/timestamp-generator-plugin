package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampFormatTitle
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec
import java.time.Instant
import java.time.Month
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.util.*

class TimestampFormatSpec : ShouldSpec() {

    private val fixedTime =
        Instant.from(ZonedDateTime.of(2019, Month.MARCH.value, 18, 10, 30, 20, 1234567, ZoneOffset.UTC))
    private val generator = TimestampGenerator

    init {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7:00"))
        "Check formatting" {
            should("cover ISO 8601 format") {
                generate(TimestampFormatTitle.ISO_8601) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
            should("cover ISO Instant format") {
                generate(TimestampFormatTitle.ISO_INSTANT) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
            should("cover ISO Local Date format") {
                generate(TimestampFormatTitle.ISO_LOCAL_DATE) shouldBe "2019-03-18"
            }
            should("cover ISO Local Time format") {
                generate(TimestampFormatTitle.ISO_LOCAL_TIME) shouldBe "17:30:20.001234567"
            }
            should("cover ISO Local DateTime format") {
                generate(TimestampFormatTitle.ISO_LOCAL_DATE_TIME) shouldBe "2019-03-18T17:30:20.001234567"
            }
            should("cover ISO Zoned Date Time format") {
                generate(TimestampFormatTitle.ISO_ZONED_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
            should("cover RFC 1123 DateTime format") {
                generate(TimestampFormatTitle.RFC_1123_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
        }
    }

    private fun generate(title: TimestampFormatTitle) = TimestampGenerator.generateTimestamp(fixedTime, settings(title))
}
