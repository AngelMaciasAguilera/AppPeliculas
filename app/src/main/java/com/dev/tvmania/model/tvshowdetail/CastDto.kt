package com.dev.tvmania.model.tvshowdetail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CastDto(
    val person: PersonDto,
): Parcelable