package com.indovision.belanjaseller.ui.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indovision.belanjaseller.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}

interface IOnBackPressed {
    fun onBackPressed(): Boolean
}
