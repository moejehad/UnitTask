package com.moejehad.unitonetask.presentation.verfication_code

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.moejehad.unitonetask.databinding.FragmentVerficationCodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerficationNumberFragment : Fragment() {

    private var _binding: FragmentVerficationCodeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VerficationNumberViewModel by viewModels()

    private val args by navArgs<VerficationNumberFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVerficationCodeBinding.inflate(inflater, container, false)

        binding.verfiyCode.setOnClickListener {
            viewModel.verifyCode(requireActivity(), binding.codeEditText.text.toString(),args.verifyId)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}