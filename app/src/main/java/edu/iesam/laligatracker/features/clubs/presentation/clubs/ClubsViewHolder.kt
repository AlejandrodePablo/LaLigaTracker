package edu.iesam.laligatracker.features.clubs.presentation.clubs

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.app.extensions.loadUrl
import edu.iesam.laligatracker.databinding.ViewClubsItemBinding
import edu.iesam.laligatracker.features.clubs.domain.Club
import edu.iesam.laligatracker.features.clubs.domain.GetClubsUseCase

class ClubsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewClubsItemBinding

    fun bind(
        clubFeed: GetClubsUseCase.ClubFeed,
        onClick: ((Club) -> Unit)?
    ) {
        binding = ViewClubsItemBinding.bind(view)
        binding.apply {
            clubName.text = clubFeed.club.name
            clubImage.loadUrl(clubFeed.club.image)
            clubItem.setOnClickListener {
                navigateToDetail(clubFeed.club.id)
            }
            favBtn.setImageResource(
                if (clubFeed.isFavorite) R.drawable.ic_favorite
                else R.drawable.ic_favorite_outlined
            )
            onClick?.let {
                favBtn.setOnClickListener {
                    onClick.invoke(clubFeed.club)
                }
            }
        }
    }

    private fun navigateToDetail(clubId: String) {
        findNavController(view).navigate(
            ClubsFragmentDirections.actionFromClubsToPlayers(clubId = clubId)
        )
    }
}