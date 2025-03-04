package edu.iesam.laligatracker.features.clubs.presentation.clubs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.databinding.FragmentClubsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClubsFragment : Fragment() {

    private var _binding: FragmentClubsBinding? = null
    private val binding get() = _binding!!

    private val clubsAdapter = ClubsAdapter()

    private val viewModel: ClubsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClubsBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            clubsToolbar.toolbar.title = requireContext().getString(R.string.clubes)
            clubsToolbar.imgToolbar.setImageResource(R.drawable.ic_favorite_outlined)
            clubsList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            clubsList.adapter = clubsAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.fetchClubs()
    }

    private fun setupObserver() {
        val clubObserver = Observer<ClubsViewModel.UiState> {
            it.clubs?.let { clubs ->
                clubsAdapter.submitList(clubs)
            }

            it.errorApp.let {}

            if (it.isLoading) {
                Log.d("@dev", "Loading...")
            } else {
                Log.d("@dev", "Loaded")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, clubObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}