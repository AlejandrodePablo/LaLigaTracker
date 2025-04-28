package edu.iesam.laligatracker.features.clubs.data.remote

import edu.iesam.laligatracker.features.clubs.domain.Club

fun ClubProfileApiModel.toModel(): Club {
    return Club(this.id, this.name, this.image, this.marketValue, this.stadiumSeats)
}