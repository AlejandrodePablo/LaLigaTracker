package edu.iesam.laligatracker.features.players.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.laligatracker.app.extensions.loadUrl
import edu.iesam.laligatracker.databinding.ViewPlayersItemBinding
import edu.iesam.laligatracker.features.players.domain.Player

class PlayerViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewPlayersItemBinding

    fun bind(player: Player) {
        binding = ViewPlayersItemBinding.bind(view)
        binding.apply {
            playerName.text = player.name
            playerImage.loadUrl(player.image)
        }
    }
}