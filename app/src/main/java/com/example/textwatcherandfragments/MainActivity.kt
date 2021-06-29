package com.example.textwatcherandfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var buttonChangeFragment: Button
    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText : EditText = findViewById(R.id.title_edit_text)
        editText.addTextChangedListener(EditTextWatcher(findViewById(R.id.title)))

        setFragmentInFrameLayout()

        clickOnButton()
    }


    protected fun setFragmentInFrameLayout(){
        buttonChangeFragment = findViewById(R.id.change_fragment_button)
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainerView, firstFragment )
            commit()
        }
    }

    protected fun clickOnButton(){
        buttonChangeFragment.setOnClickListener{
            if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == firstFragment){
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, secondFragment)
                    commit()
                }
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, firstFragment)
                    commit()
                }
            }
        }
    }


}