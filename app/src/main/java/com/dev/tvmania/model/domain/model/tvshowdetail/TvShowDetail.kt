package com.dev.tvmania.model.domain.model.tvshowdetail

import com.dev.tvmania.model.domain.model.tvshow.Image
import com.dev.tvmania.model.domain.model.tvshow.Rating

data class TvShowDetail(
    val id: Long,
    val url: String,
    val name: String,
    val genres: List<String>,
    val premiered: String,
    val officialSite: String?,
    val rating: Rating,
    val image: Image,
    val summary: String,
    val updated: Long,
    val actors: List<Person>
)
