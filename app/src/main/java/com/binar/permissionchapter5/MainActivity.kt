package com.binar.permissionchapter5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binar.permissionchapter5.databinding.ActivityMainBinding
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(MainActivity::class.java.simpleName, "onCreate() Dijalankan")

        Glide.with(this)
            .load("https://img.icons8.com/plasticine/2x/flower.png")
            .into(binding.ivFlower)

        binding.btnCheckLocation.setOnClickListener {
//            val permissionCheck = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            val permissionCheck = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)

            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Location DIIZINKAN", Toast.LENGTH_LONG).show()
                getLongLat()
            } else {
                Toast.makeText(this, "Permission Location DITOLAK", Toast.LENGTH_LONG).show()
                requestLocationPermission()
            }
        }

        binding.btnPindahActivity.setOnClickListener {
            val intentKeActivityKedua = Intent(this, ActivityKedua::class.java)
            startActivity(intentKeActivityKedua)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(MainActivity::class.java.simpleName, "onStart() Dijalankan")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MainActivity::class.java.simpleName, "onResume() Dijalankan")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MainActivity::class.java.simpleName, "onPause() Dijalankan")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MainActivity::class.java.simpleName, "onStop() Dijalankan")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MainActivity::class.java.simpleName, "onRestart() Dijalankan")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MainActivity::class.java.simpleName, "onDestroy() Dijalankan")
    }

    private fun requestLocationPermission() {
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 201)
    }


    @SuppressLint("MissingPermission")
    fun getLongLat() {
        val locationManager =
            applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val location: Location? =
            locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        val latLongText = "Lat: ${location?.latitude} Long : ${location?.longitude}"
        Log.d(MainActivity::class.simpleName, latLongText)
        Toast.makeText(
            this,
            latLongText,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            201 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION
                ) {
                    Toast.makeText(this, "Permissions for Location Permitted", Toast.LENGTH_LONG)
                        .show()
                    getLongLat()
                } else {
                    Toast.makeText(this, "Permissions for Location Denied", Toast.LENGTH_LONG)
                        .show()
                }
            }
            else -> {
                Toast.makeText(this, "The request code doesn't match", Toast.LENGTH_LONG).show()
            }
        }
    }
}