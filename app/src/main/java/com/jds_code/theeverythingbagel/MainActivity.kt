package com.jds_code.theeverythingbagel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jds_code.theeverythingbagel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // This was the originally generated 'onCreate().'
/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }*/
}