package com.adit.camerafragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            changeFragment(CameraFragment(), "cam")
    }

    fun changeFragment(f: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_content, f, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}
