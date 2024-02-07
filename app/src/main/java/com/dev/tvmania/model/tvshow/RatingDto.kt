package com.dev.tvmania.model.tvshow

import android.os.Parcelable
import com.dev.tvmania.model.domain.model.tvshow.Rating
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingDto(
    val average: Double?
): Parcelable{

    fun toRating(): Rating {
        return Rating(average = average ?: 0.0)
    }
}