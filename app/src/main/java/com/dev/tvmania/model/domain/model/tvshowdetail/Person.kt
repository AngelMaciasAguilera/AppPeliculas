package com.dev.tvmania.model.domain.model.tvshowdetail

import com.dev.tvmania.model.domain.model.tvshow.Image

data class Person(
    val id: Long,
    val image: Image?,
    val name: String,
    val updated: Long,
    val url: String
)
