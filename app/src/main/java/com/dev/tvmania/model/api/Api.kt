package com.dev.tvmania.model.api

import com.dev.tvmania.model.tvshow.TvShowDto
import com.dev.tvmania.model.tvshowdetail.TvShowDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("shows")
    suspend fun getTvShows(
        @Query("page") page: Int
    ): List<TvShowDto>


    @GET("shows/{id}?embed=cast")
    suspend fun getTvShowDetail(
        @Path("id") id: Long
    ): TvShowDetailDto?
}