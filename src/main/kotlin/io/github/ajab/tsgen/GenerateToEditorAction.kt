package io.github.ajab.tsgen

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class GenerateToEditorAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getData(CommonDataKeys.PROJECT)
        val editor = e.getData(CommonDataKeys.EDITOR)

        if (project == null || editor == null) {
            return
        }

        WriteCommandAction.runWriteCommandAction(project) {
            editor.caretModel.allCarets.forEach {
                EditorDocumentUtils.insertTextAtCaret(it, TimestampGenerator.generateTimestamp())
            }
        }
    }
}
