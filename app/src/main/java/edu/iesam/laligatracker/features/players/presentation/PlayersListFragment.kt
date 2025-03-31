package edu.iesam.laligatracker.features.players.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.databinding.FragmentPlayersListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayersListFragment : Fragment() {

    private var _binding: FragmentPlayersListBinding? = null
    private val binding get() = _binding!!

    private val playerAdapter = PlayerAdapter()

    private val viewModel: PlayersViewModel by viewModel()

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
            playerList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            playerList.adapter = playerAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.fetchPlayers()
    }

    private fun setupObserver() {
        val playerObserver = Observer<PlayersViewModel.UiState> {
            it.players?.let {
                playerAdapter.submitList(it)
            }

            it.error.let {}

            if (it.isLoading) {
                Log.d("@dev", "Loading")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, playerObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}