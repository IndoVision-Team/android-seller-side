package com.indovision.belanjaseller.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.indovision.belanjaseller.databinding.ActivitySplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val intentHomepage = Intent()
        lifecycleScope.launch(Dispatchers.IO) {
            delay(TIMEOUT)
            withContext(Dispatchers.Main) {
                startActivity(intentHomepage)
                finish()
            }
        }
    }

    companion object {
        private const val TIMEOUT = 3000L
    }
}
