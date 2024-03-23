package com.example.unit5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.unit5.databinding.FragmentCreateEntryBinding

class CreateEntryFragment : Fragment() {

    private var _binding: FragmentCreateEntryBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HealthMetricViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateEntryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HealthMetricViewModel::class.java]

        binding.saveButton.setOnClickListener {
            val foodName = binding.foodNameEditText.text.toString()
            val calories = binding.caloriesEditText.text.toString().toInt()
            viewModel.insert(HealthMetric(foodName = foodName, calories = calories))
            // Navigate back to DashboardFragment after save
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}