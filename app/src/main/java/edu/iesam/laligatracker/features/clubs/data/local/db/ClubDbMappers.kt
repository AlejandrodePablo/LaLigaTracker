package edu.iesam.laligatracker.features.clubs.data.local.db

import edu.iesam.laligatracker.features.clubs.domain.Club

fun Club.toEntity(): ClubEntity = ClubEntity(
    this.id,
    this.name,
    this.image
)

fun ClubEntity.toDomain(): Club = Club(
    this.id,
    this.name,
    this.image
)