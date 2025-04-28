package edu.iesam.laligatracker.features.clubs.presentation.market

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.laligatracker.app.extensions.loadUrl
import edu.iesam.laligatracker.databinding.ViewClubsItemBinding
import edu.iesam.laligatracker.databinding.ViewMarketValueClubsItemBinding
import edu.iesam.laligatracker.features.clubs.domain.Club

class MarketValueViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewMarketValueClubsItemBinding

    fun bind(club: Club) {
        binding = ViewMarketValueClubsItemBinding.bind(view)
        binding.apply {
            clubName.text = club.name
            clubImage.loadUrl(club.image)
            clubValue.text = club.marketValue.toString()
        }
    }
}