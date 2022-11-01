package com.moejehad.unitonetask.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.moejehad.unitonetask.adapters.AllCitiesAdapter
import com.moejehad.unitonetask.adapters.SliderAdapter
import com.moejehad.unitonetask.databinding.FragmentHomeBinding
import com.moejehad.unitonetask.domain.model.AllCities
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var allCitiesAdapter: AllCitiesAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        allCitiesAdapter = AllCitiesAdapter(requireContext())
        sliderAdapter = SliderAdapter(requireContext())
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel.getAllCities()

        viewModel.getAllCities.observe(requireActivity(), Observer { list ->
            setRecyclerView(list)
        })

        viewModel.getAllSliderCities.observe(requireActivity(), Observer { list ->
            setupViewPager(list)
        })

        binding.signIn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToLogin()
            navController.navigate(action)
        }

        return binding.root
    }


    private fun setRecyclerView(list: List<AllCities.DataContent.City>) {
        binding.allCitesRecyclerView.apply {
            allCitiesAdapter.setContentList(list)
            adapter = allCitiesAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupViewPager(list: List<AllCities.DataContent.City>) {
        binding.apply {
            sliderAdapter.setContentList(list)
            viewPager.adapter = sliderAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}