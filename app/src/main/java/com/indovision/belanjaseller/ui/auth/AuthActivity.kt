package com.indovision.belanjaseller.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indovision.belanjaseller.R
import com.indovision.belanjaseller.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}
