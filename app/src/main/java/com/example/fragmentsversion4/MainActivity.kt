package com.example.fragmentsversion4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var formFragment: FormFragment
    private lateinit var dataFragment: DataFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initListeners()
    }

    private fun initFragments(){
        dataFragment = supportFragmentManager.findFragmentById(R.id.dataFragment) as DataFragment
        formFragment = supportFragmentManager.findFragmentById(R.id.formFragment) as FormFragment
    }

    private fun initListeners(){
       //formFragment.onDataListener = MyOnDataListener()
            formFragment.onDataListener = dataFragment
    }

    inner class MyOnDataListener : FormFragment.OnDataListener{
        override fun onData(data: String) {
            Toast.makeText(this@MainActivity,"MainAct.: $data", Toast.LENGTH_LONG).show()
            dataFragment.data = data
        }
    }
}