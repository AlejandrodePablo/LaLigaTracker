package edu.iesam.laligatracker.features.clubs.presentation.clubs

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.laligatracker.features.clubs.domain.Club
import edu.iesam.laligatracker.features.clubs.domain.GetClubsUseCase

class ClubsDiffUtil : DiffUtil.ItemCallback<GetClubsUseCase.ClubFeed>() {
    override fun areItemsTheSame(
        oldItem: GetClubsUseCase.ClubFeed,
        newItem: GetClubsUseCase.ClubFeed,
    ): Boolean {
        return oldItem.club.id == newItem.club.id
    }

    override fun areContentsTheSame(
        oldItem: GetClubsUseCase.ClubFeed,
        newItem: GetClubsUseCase.ClubFeed,
    ): Boolean {
        return oldItem == newItem
    }
}