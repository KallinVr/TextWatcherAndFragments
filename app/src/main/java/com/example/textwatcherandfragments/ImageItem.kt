package com.example.textwatcherandfragments

data class ImageItem(
    override var name: String?,
    override var viewType: String?
) : Item()