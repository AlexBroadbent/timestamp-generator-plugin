package io.github.ajab.tsgen

import com.intellij.openapi.editor.Caret

object EditorDocumentUtils {

    fun insertTextAtCaret(caret: Caret, text: CharSequence) {
        val textLength = text.length
        val start: Int
        val document = caret.editor.document
        if (caret.hasSelection()) {
            start = caret.selectionStart
            val end = caret.selectionEnd

            document.replaceString(start, end, text)
            caret.setSelection(start, start + textLength)
        } else {
            start = caret.offset

            document.insertString(start, text)
        }
        caret.moveToOffset(start + textLength)
    }
}
