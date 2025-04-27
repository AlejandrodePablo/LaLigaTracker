package edu.iesam.laligatracker.features.players.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.laligatracker.features.players.domain.Player

class PlayerDiffUtil : DiffUtil.ItemCallback<Player>() {
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }
}