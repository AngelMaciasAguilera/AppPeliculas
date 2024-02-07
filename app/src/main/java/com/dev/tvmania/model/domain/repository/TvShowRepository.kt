package com.dev.tvmania.model.domain.repository

import androidx.paging.PagingData
import com.dev.tvmania.model.domain.model.tvshow.TvShow
import com.dev.tvmania.model.domain.model.tvshowdetail.TvShowDetail
import com.dev.tvmania.view.util.Resource
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {

    fun getTvShows(pageSize: Int): Flow<PagingData<TvShow>>

    suspend fun getTvShowDetail(id: Long): Resource<TvShowDetail?>


}