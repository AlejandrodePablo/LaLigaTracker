package edu.iesam.laligatracker.features.clubs.presentation.clubs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.laligatracker.R
import edu.iesam.laligatracker.features.clubs.domain.Club

class ClubsAdapter : ListAdapter<Club, ClubsViewHolder>(ClubsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_clubs_item, parent, false)
        return ClubsViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: ClubsViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}