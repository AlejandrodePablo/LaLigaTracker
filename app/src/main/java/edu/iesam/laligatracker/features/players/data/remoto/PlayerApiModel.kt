package edu.iesam.laligatracker.features.players.data.remoto

import com.google.gson.annotations.SerializedName

data class PlayerApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("number") val number: Int,
    @SerializedName("goals") val amountGoals: String,
)