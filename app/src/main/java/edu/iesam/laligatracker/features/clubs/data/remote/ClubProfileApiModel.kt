package edu.iesam.laligatracker.features.clubs.data.remote

import com.google.gson.annotations.SerializedName

data class ClubListApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)

data class ClubProfileApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)