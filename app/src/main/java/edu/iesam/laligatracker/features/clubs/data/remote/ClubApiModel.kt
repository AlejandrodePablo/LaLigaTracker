package edu.iesam.laligatracker.features.clubs.data.remote

import com.google.gson.annotations.SerializedName

data class ClubApiModel (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String

)