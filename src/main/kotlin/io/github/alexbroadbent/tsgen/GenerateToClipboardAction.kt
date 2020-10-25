package io.github.alexbroadbent.tsgen

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.wm.WindowManager
import com.intellij.ui.awt.RelativePoint
import com.intellij.util.ui.TextTransferable

class GenerateToClipboardAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val timestamp = TimestampGenerator.generateTimestamp()

        CopyPasteManager.getInstance().setContents(TextTransferable(timestamp))

        event.getData(CommonDataKeys.PROJECT)?.let {
            val statusBar = WindowManager.getInstance().getStatusBar(it)

            JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder("$timestamp copied to clipboard", MessageType.INFO, null)
                .setFadeoutTime(5000)
                .createBalloon()
                .show(RelativePoint.getCenterOf(statusBar.component), Balloon.Position.atRight)
        }
    }
}
