package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampFormatTitle
import io.kotest.matchers.shouldBe
import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime

class TimestampFormatSpec : BaseSpec({

    context("Check formatting") {
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
            generate(TimestampFormatTitle.ISO_LOCAL_TIME) shouldBe "10:30:20.001234567"
        }
        should("cover ISO Local DateTime format") {
            generate(TimestampFormatTitle.ISO_LOCAL_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567"
        }
        should("cover ISO Zoned Date Time format") {
            generate(TimestampFormatTitle.ISO_ZONED_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567Z"
        }
        should("cover RFC 1123 DateTime format") {
            generate(TimestampFormatTitle.RFC_1123_DATE_TIME) shouldBe "Mon, 18 Mar 2019 10:30:20 GMT"
        }
        should("cover Epoch Seconds format") {
            generate(TimestampFormatTitle.EPOCH_SECONDS) shouldBe "1552905020"
        }
        should("cover Epoch Milliseconds format") {
            generate(TimestampFormatTitle.EPOCH_MILLISECONDS) shouldBe "1552905020001"
        }
    }
}) {

    companion object {
        private val fixedTime = Instant.from(ZonedDateTime.of(2019, 3, 18, 10, 30, 20, 1234567, ZoneOffset.UTC))

        fun generate(title: TimestampFormatTitle) = TimestampGenerator.generateTimestamp(fixedTime, settings(title))
    }
}
