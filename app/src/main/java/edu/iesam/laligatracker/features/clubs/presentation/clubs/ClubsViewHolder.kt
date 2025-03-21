package edu.iesam.laligatracker.features.clubs.presentation.clubs

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.laligatracker.app.extensions.loadUrl
import edu.iesam.laligatracker.databinding.ViewClubsItemBinding
import edu.iesam.laligatracker.features.clubs.domain.Club

class ClubsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewClubsItemBinding

    fun bind(club: Club) {
        binding = ViewClubsItemBinding.bind(view)
        binding.apply {
            clubName.text = club.name
            clubImage.loadUrl(club.image)
        }
    }
}