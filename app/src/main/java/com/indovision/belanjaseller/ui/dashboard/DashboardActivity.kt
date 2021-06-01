package com.indovision.belanjaseller.ui.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.indovision.belanjaseller.R
import com.indovision.belanjaseller.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityDashboardBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }

    override fun onBackPressed() {
        val fragment = navHostFragment.childFragmentManager.fragments[0]
        (fragment as? IOnBackPressed)?.onBackPressed()?.not().let {
            if (it == true) super.onBackPressed()
        }
    }
}

interface IOnBackPressed {
    fun onBackPressed(): Boolean
}
