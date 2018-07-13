package com.adit.camerafragment

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import rebus.permissionutils.*
import rebus.permissionutils.AskAgainCallback.UserResponse


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            askPermission()

    }

    private fun askPermission() {
        PermissionManager.Builder()
                .permission(PermissionEnum.WRITE_EXTERNAL_STORAGE, PermissionEnum.CAMERA, PermissionEnum.READ_EXTERNAL_STORAGE)
                .ask(this)
    }

    override fun onResume() {
        super.onResume()
        btn_change.setOnClickListener {
            askPermission()
            val granted = PermissionUtils.isGranted(this, PermissionEnum.CAMERA)
            if (granted)
                changeFragment(CameraFragment(), "cam")
        }
    }

    fun changeFragment(f: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_content, f, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}
