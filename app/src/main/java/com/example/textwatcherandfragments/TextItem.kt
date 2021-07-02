package com.example.textwatcherandfragments

data class TextItem(
    override var name: String?,
    override var viewType: String?
) : Item()