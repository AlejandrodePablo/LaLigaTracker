package edu.iesam.laligatracker.features.players.data.remoto

import com.google.gson.annotations.SerializedName

data class PlayerApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("imageUrl") val image: String,
    @SerializedName("shirtNumber") val number: String?,
)

data class PlayerInfoApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("players") val players: List<PlayerApiModel>
)

data class StatsApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("competitionId") val competitionId: String,
    @SerializedName("goals") val amountGoals: Int?,
    @SerializedName("assists") val amountAssists: String?,
)
