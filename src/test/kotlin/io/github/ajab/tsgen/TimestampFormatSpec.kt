package io.github.ajab.tsgen

import io.github.ajab.tsgen.config.TimestampFormat
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec
import java.time.Instant
import java.time.Month
import java.time.ZoneOffset
import java.time.ZonedDateTime

class TimestampFormatSpec : ShouldSpec() {

    private val generator = TimestampGenerator

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)

        generator.setFixedTime(Instant.from(ZonedDateTime.of(2019, Month.MARCH.value, 18, 10, 30, 20, 1234567, ZoneOffset.UTC)))
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        super.afterTest(testCase, result)

        generator.setFixedTime(null)
    }

    init {
        "Check formatting" {
            should("cover ISO 8601 format") {
                generator.generate(TimestampFormat.ISO_8601) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
            should("cover ISO Instant format") {
                generator.generate(TimestampFormat.ISO_INSTANT) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
            should("cover ISO Local Date format") {
                generator.generate(TimestampFormat.ISO_LOCAL_DATE) shouldBe "2019-03-18"
            }
            should("cover ISO Local Time format") {
                generator.generate(TimestampFormat.ISO_LOCAL_TIME) shouldBe "10:30:20.001234567"
            }
            should("cover ISO Local DateTime format") {
                generator.generate(TimestampFormat.ISO_LOCAL_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567"
            }
            should("cover ISO Zoned Date Time format") {
                generator.generate(TimestampFormat.ISO_ZONED_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
            should("cover RFC 1123 DateTime format") {
                generator.generate(TimestampFormat.RFC_1123_DATE_TIME) shouldBe "2019-03-18T10:30:20.001234567Z"
            }
        }
    }
}
