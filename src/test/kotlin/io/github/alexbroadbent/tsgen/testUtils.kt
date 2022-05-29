package io.github.alexbroadbent.tsgen

import io.github.alexbroadbent.tsgen.config.TimestampFormatMap
import io.github.alexbroadbent.tsgen.config.TimestampFormatTitle
import io.github.alexbroadbent.tsgen.config.TimestampGeneratorSettings
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.core.test.TestCaseOrder

fun settings(
    title: TimestampFormatTitle = TimestampFormatTitle.ISO_8601
) = TimestampGeneratorSettings.create(TimestampFormatMap.getFormat(title))

abstract class BaseSpec(body: ShouldSpec.() -> Unit = {}) : ShouldSpec(body) {
    override fun testCaseOrder() = TestCaseOrder.Random
    override fun isolationMode() = IsolationMode.InstancePerTest
}
