package com.indovision.belanjaseller.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indovision.belanjaseller.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding as FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
