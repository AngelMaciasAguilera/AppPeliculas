package com.dev.tvmania.model.api

import com.dev.tvmania.model.tvshow.TvShowDto
import com.dev.tvmania.model.tvshowdetail.TvShowDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    /**
     *  Get The list of Tvh shows with pagination
     *
     *  @param page [Int] page number to be fetched
     *  @return [List]<[TvShowDto]>
     */
    @GET("shows")
    suspend fun getTvShows(
        @Query("page") page: Int
    ): List<TvShowDto>

    /**
     *  Get the detail about a tv show with cast
     *
     *  @param id [Int] the id of the tv show
     *  @return [TvShowDetailDto]?
     */
    @GET("shows/{id}?embed=cast")
    suspend fun getTvShowDetail(
        @Path("id") id: Long
    ): TvShowDetailDto?
}