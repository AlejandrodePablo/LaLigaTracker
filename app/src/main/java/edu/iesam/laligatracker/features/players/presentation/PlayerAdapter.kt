package edu.iesam.laligatracker.features.players.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.features.players.domain.Player

class PlayerAdapter: ListAdapter<Player, PlayerViewHolder>(PlayerDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_players_item,
                parent,
                false
            )
        return PlayerViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}