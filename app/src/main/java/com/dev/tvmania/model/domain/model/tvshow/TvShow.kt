package com.dev.tvmania.model.domain.model.tvshow

data class TvShow(
    val id: Long,
    val name: String,
    val genres: List<String>,
    val rating: Rating,
    val image: Image,
    val updated: Long,
)
