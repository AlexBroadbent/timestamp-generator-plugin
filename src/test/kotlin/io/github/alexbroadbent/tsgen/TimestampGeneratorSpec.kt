package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampFormatTitle
import io.kotest.matchers.longs.shouldBeInRange
import java.time.Instant

class TimestampGeneratorSpec : BaseSpec({
    context("Check generated timestamp") {
        should("use the current time") {
            val before = Instant.now().toEpochMilli()
            val timestamp = TimestampGenerator.generateTimestamp(settings = settings())
            val after = Instant.now().toEpochMilli()

            Instant.parse(timestamp).toEpochMilli() shouldBeInRange (before..after)
        }
        should("use the current time with given settings") {
            val settings = settings(title = TimestampFormatTitle.ISO_8601)

            val before = Instant.now().toEpochMilli()
            val timestamp = TimestampGenerator.generateTimestamp(settings = settings)
            val after = Instant.now().toEpochMilli()

            Instant.parse(timestamp).toEpochMilli() shouldBeInRange (before..after)
        }
    }
})
