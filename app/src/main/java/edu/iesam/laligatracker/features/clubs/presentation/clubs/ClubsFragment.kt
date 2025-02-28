package edu.iesam.laligatracker.features.clubs.presentation.clubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.databinding.FragmentClubsBinding

class ClubsFragment : Fragment() {

    private var _binding: FragmentClubsBinding? = null
    private val binding get() = _binding!!

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
        }
    }
}