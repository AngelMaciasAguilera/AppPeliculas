package com.dev.tvmania.model.tvshowdetail

import android.os.Parcelable
import com.dev.tvmania.model.tvshow.ImageDto
import com.dev.tvmania.model.domain.model.tvshowdetail.Person
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonDto(
    val id: Long,
    val image: ImageDto?,
    val name: String,
    val url: String,
    val updated: Long
) : Parcelable {

    fun toPerson(): Person {
        return Person(
            id,
            image?.toImage(),
            name,
            updated,
            url
        )
    }

}