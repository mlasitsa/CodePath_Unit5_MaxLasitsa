package com.example.unit5


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.unit5.databinding.FragmentDashboardBinding
import androidx.navigation.fragment.findNavController


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HealthMetricViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HealthMetricViewModel::class.java]

        // Initialize your RecyclerView adapter
        val adapter = MetricListAdapter()
        binding.recyclerView.adapter = adapter

        // Observe the LiveData list of metrics from your ViewModel and update the RecyclerView
        viewModel.allMetrics.observe(viewLifecycleOwner) { metrics ->
            // Submit the list to the adapter
            adapter.submitList(metrics)
        }

        binding.addNewFoodButton.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToCreateEntryFragment())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}