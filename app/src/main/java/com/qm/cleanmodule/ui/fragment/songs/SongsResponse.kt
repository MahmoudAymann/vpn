package com.qm.cleanmodule.ui.fragment.songs


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.qm.cleanmodule.base.view.BaseParcelable
import com.qm.cleanmodule.ui.fragment.songs.SongsResponse.SongsResponseItem
import java.util.Calendar

class SongsResponse : ArrayList<SongsResponseItem>(){
    @Parcelize
    data class SongsResponseItem(
        @SerializedName("additionalArtists")
        val additionalArtists: List<String?>?,
        @SerializedName("adfunded")
        val adfunded: Boolean?,
        @SerializedName("bundleOnly")
        val bundleOnly: Boolean?,
        @SerializedName("cover")
        val cover: Cover?,
        @SerializedName("duration")
        val duration: Int?,
        @SerializedName("genres")
        val genres: List<String?>?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("idBag")
        val idBag: IdBag?,
        @SerializedName("label")
        val label: String?,
        @SerializedName("mainArtist")
        val mainArtist: MainArtist?,
        @SerializedName("mainRelease")
        val mainRelease: Boolean?,
        @SerializedName("natures")
        val natures: List<String?>?,
        @SerializedName("numberOfTracks")
        val numberOfTracks: Int?,
        @SerializedName("partialStreamable")
        val partialStreamable: Boolean?,
        @SerializedName("publishingDate")
        val publishingDate: String?,
        @SerializedName("release")
        val release: Release?,
        @SerializedName("statistics")
        val statistics: Statistics?,
        @SerializedName("streamable")
        val streamable: Boolean?,
        @SerializedName("streamableTracks")
        val streamableTracks: Int?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("trackNumber")
        val trackNumber: Int?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("variousArtists")
        val variousArtists: Boolean?,
        @SerializedName("volumeNumber")
        val volumeNumber: Int?
    ) : Parcelable ,BaseParcelable{
        @Parcelize
        data class Cover(
            @SerializedName("default")
            val default: String?,
            @SerializedName("large")
            val large: String?,
            @SerializedName("medium")
            val medium: String?,
            @SerializedName("small")
            val small: String?,
            @SerializedName("template")
            val template: String?,
            @SerializedName("tiny")
            val tiny: String?
        ) : Parcelable
    
        @Parcelize
        data class IdBag(
            @SerializedName("isrc")
            val isrc: String?,
            @SerializedName("roviId")
            val roviId: String?,
            @SerializedName("roviTrackId")
            val roviTrackId: String?
        ) : Parcelable
    
        @Parcelize
        data class MainArtist(
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?
        ) : Parcelable
    
        @Parcelize
        data class Release(
            @SerializedName("id")
            val id: Int?,
            @SerializedName("title")
            val title: String?
        ) : Parcelable
    
        @Parcelize
        data class Statistics(
            @SerializedName("estimatedRecentCount")
            val estimatedRecentCount: Int?,
            @SerializedName("estimatedTotalCount")
            val estimatedTotalCount: Int?,
            @SerializedName("popularity")
            val popularity: Int?
        ) : Parcelable

        override fun unique(): Any {
            return Calendar.getInstance().timeInMillis
        }
    }
}