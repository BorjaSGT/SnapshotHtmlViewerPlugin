package com.bsg.snapviewer.snapshotpreviewplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.icons.AllIcons

class SnapFileType : LanguageFileType(SnapLanguage) {
    override fun getName() = "Snap File"
    override fun getDescription() = "Snap preview file"
    override fun getDefaultExtension() = "snap"
    override fun getIcon() = AllIcons.FileTypes.Html // o un icono personalizado
}