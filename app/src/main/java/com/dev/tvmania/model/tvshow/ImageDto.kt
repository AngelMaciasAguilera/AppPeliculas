package com.dev.tvmania.model.tvshow

import android.os.Parcelable
import com.dev.tvmania.model.domain.model.tvshow.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageDto(
    val medium: String,
    val original: String
): Parcelable{

    fun toImage(): Image {
        return Image(
            medium,
            original
        )
    }

}