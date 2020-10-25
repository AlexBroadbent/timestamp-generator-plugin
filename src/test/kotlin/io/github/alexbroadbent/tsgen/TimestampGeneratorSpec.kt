package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampFormatTitle
import io.kotlintest.IsolationMode
import io.kotlintest.TestCaseOrder
import io.kotlintest.matchers.numerics.shouldBeInRange
import io.kotlintest.specs.ShouldSpec
import java.time.Instant

class TimestampGeneratorSpec : ShouldSpec() {

    override fun testCaseOrder() = TestCaseOrder.Random
    override fun isolationMode() = IsolationMode.InstancePerTest

    init {
        "Check generated timestamp" {
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
    }
}
