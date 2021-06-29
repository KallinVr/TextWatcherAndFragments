package com.example.textwatcherandfragments

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView

class EditTextWatcher(view : TextView) : TextWatcher {

    private var textView : TextView = view

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        textView.text = s.toString()
    }

    override fun afterTextChanged(s: Editable?) {

    }
}