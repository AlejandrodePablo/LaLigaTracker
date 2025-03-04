package edu.iesam.laligatracker.features.clubs.data.remote

import edu.iesam.laligatracker.features.clubs.domain.Club

fun ClubApiModel.toModel(): Club {
    return Club(this.id, this.name, this.image)
}