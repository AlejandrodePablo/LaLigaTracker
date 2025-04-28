package edu.iesam.laligatracker.features.clubs.presentation.market

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.databinding.FragmentMarketValueBinding
import edu.iesam.laligatracker.features.clubs.presentation.clubs.ClubsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarketValueFragment : Fragment() {

    private var _binding: FragmentMarketValueBinding? = null
    private val binding get() = _binding!!

    private val marketValueAdapter = MarketValueAdapter()

    private val viewModel: MarketValueViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarketValueBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            marketValueToolbar.toolbar.title = requireContext().getString(R.string.valor_mercado)
            marketValueList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            marketValueList.adapter = marketValueAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.fetchClubsByMarketValue()
    }

    private fun setupObserver() {
        val clubObserver = Observer<MarketValueViewModel.UiState> {
            it.clubs?.let { clubs ->
                marketValueAdapter.submitList(clubs)
            }

            it.errorApp.let {}

            if (it.isLoading) {
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loaded market")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, clubObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}