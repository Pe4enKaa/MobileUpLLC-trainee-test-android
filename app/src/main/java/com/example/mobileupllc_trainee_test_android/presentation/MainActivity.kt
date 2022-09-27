package com.example.mobileupllc_trainee_test_android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileupllc_trainee_test_android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
