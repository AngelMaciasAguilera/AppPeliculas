package com.dev.tvmania.model.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dev.tvmania.model.api.Api
import com.dev.tvmania.model.repository.paging.TvShowRemotePagingSource
import com.dev.tvmania.model.domain.model.tvshow.TvShow
import com.dev.tvmania.model.domain.model.tvshowdetail.TvShowDetail
import com.dev.tvmania.model.domain.repository.TvShowRepository
import com.dev.tvmania.view.util.RepositoryHelper
import com.dev.tvmania.view.util.Resource
import kotlinx.coroutines.flow.Flow

class TvShowRepositoryImpl(private val api: Api) : TvShowRepository, RepositoryHelper() {

    override fun getTvShows(pageSize: Int): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = pageSize),
            pagingSourceFactory = { TvShowRemotePagingSource(api = api) }
        ).flow
    }

    override suspend fun getTvShowDetail(id: Long): Resource<TvShowDetail?> {
        return when (val response = invokeApi { api.getTvShowDetail(id = id) }) {
            is Resource.Loading -> Resource.Loading()
            is Resource.Success -> Resource.Success(data = response.data?.toTvShowDetail())
            is Resource.Error -> Resource.Error(error = response.error)
        }
    }
}