package com.bsg.snapviewer.snapshotpreviewplugin

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.util.UserDataHolderBase
import javax.swing.JComponent
import javax.swing.JEditorPane
import javax.swing.JScrollPane

class SnapPreviewEditor(private val file: VirtualFile) : UserDataHolderBase(), FileEditor {
    private val component: JComponent

    init {
        val content = String(file.contentsToByteArray())
        component = try {
            val browser = com.intellij.ui.jcef.JBCefBrowser()
            browser.loadHTML(content)
            browser.component
        } catch (e: Throwable) {
            // Si JCEF no está disponible, usa JEditorPane
            val editorPane = JEditorPane("text/html", content)
            editorPane.isEditable = false
            JScrollPane(editorPane)
        }
    }

    override fun getComponent(): JComponent = component
    override fun getPreferredFocusedComponent(): JComponent? = component
    override fun getName(): String = "Snap Preview"

    override fun dispose() {}
    override fun isModified(): Boolean = false
    override fun isValid(): Boolean = true
    override fun setState(state: com.intellij.openapi.fileEditor.FileEditorState) {}
    override fun getCurrentLocation(): com.intellij.openapi.fileEditor.FileEditorLocation? = null
    override fun getFile(): VirtualFile? = file
    override fun addPropertyChangeListener(listener: java.beans.PropertyChangeListener) {}
    override fun removePropertyChangeListener(listener: java.beans.PropertyChangeListener) {}
}