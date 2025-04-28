package edu.iesam.laligatracker.features.clubs.presentation.market

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.laligatracker.features.clubs.domain.Club

class MarketValueDiffUtil : DiffUtil.ItemCallback<Club>() {
    override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem == newItem
    }
}