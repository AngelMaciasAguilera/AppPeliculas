package com.dev.tvmania.model.usecase

import androidx.paging.PagingData
import com.dev.tvmania.model.domain.model.tvshow.TvShow
import com.dev.tvmania.model.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow

class GetTvShows(private val repository: TvShowRepository) {

    operator fun invoke(pageSize: Int): Flow<PagingData<TvShow>> {
        return repository.getTvShows(pageSize = pageSize)
    }

}
