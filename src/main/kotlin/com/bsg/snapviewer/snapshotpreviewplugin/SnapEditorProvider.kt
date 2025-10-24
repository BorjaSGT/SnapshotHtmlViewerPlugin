package com.bsg.snapviewer.snapshotpreviewplugin

import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.project.DumbAware

class SnapEditorProvider : FileEditorProvider, DumbAware {
    override fun accept(project: Project, file: VirtualFile): Boolean {
        return file.extension == "snap"
    }

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return SnapPreviewEditor(file)
    }

    override fun getEditorTypeId(): String = "snap-preview-editor"
    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.HIDE_DEFAULT_EDITOR
}