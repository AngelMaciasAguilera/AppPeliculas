package com.dev.tvmania.model.tvshowdetail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmbeddedDto(
    val cast: List<CastDto>
): Parcelable