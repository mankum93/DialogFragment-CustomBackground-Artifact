package com.androutils.dialogfragmentexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Type1ErrorsDialogFragment
            .newInstance("There was a problem with the login")
            .show(supportFragmentManager, "dialog")
    }
}