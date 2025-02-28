package edu.iesam.laligatracker.features.clubs.presentation.clubs.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.databinding.FragmentPlayersListBinding

class PlayersListFragment : Fragment() {

    private var _binding: FragmentPlayersListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayersListBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            playersToolbar.toolbar.title = requireContext().getString(R.string.jugadores)
        }
    }
}