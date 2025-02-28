package edu.iesam.laligatracker.features.clubs.presentation.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.databinding.FragmentMarketValueBinding

class MarketValueFragment : Fragment() {

    private var _binding: FragmentMarketValueBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarketValueBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView(){
        binding.apply {
            marketValueToolbar.toolbar.title = requireContext().getString(R.string.valor_mercado)
        }
    }
}