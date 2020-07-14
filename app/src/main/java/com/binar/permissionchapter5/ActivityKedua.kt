package com.binar.permissionchapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityKedua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kedua)

        Log.d(ActivityKedua::class.java.simpleName,"onCreate() Dijalankan")
    }

    override fun onStart() {
        super.onStart()
        Log.d(ActivityKedua::class.java.simpleName,"onStart() Dijalankan")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ActivityKedua::class.java.simpleName,"onResume() Dijalankan")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ActivityKedua::class.java.simpleName,"onPause() Dijalankan")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ActivityKedua::class.java.simpleName,"onStop() Dijalankan")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ActivityKedua::class.java.simpleName,"onRestart() Dijalankan")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ActivityKedua::class.java.simpleName,"onDestroy() Dijalankan")
    }
}