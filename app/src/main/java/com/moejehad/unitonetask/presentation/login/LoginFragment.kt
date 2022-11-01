package com.moejehad.unitonetask.presentation.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.moejehad.unitonetask.R
import com.moejehad.unitonetask.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.sendCodeButton.setOnClickListener {
            if (binding.mobileNumberEditText.text.toString().isNotEmpty()) {
                viewModel.sendVerifyCode(
                    requireActivity(),
                    binding.mobileNumberEditText.text.toString()
                )
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginToVerficationNumberFragment(
                        viewModel.vId
                    )
                )
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}