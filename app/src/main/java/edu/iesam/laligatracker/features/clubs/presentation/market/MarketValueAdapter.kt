package edu.iesam.laligatracker.features.clubs.presentation.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.features.clubs.domain.Club

class MarketValueAdapter : ListAdapter<Club, MarketValueViewHolder>(MarketValueDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketValueViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_market_value_clubs_item, parent, false)
        return MarketValueViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: MarketValueViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}