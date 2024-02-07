package com.dev.tvmania.model.usecase

import com.dev.tvmania.model.domain.model.tvshowdetail.TvShowDetail
import com.dev.tvmania.model.domain.repository.TvShowRepository
import com.dev.tvmania.view.util.Resource

class GetTvShowDetail(private val repository: TvShowRepository) {

    suspend operator fun invoke(id: Long): Resource<TvShowDetail?> {
        return repository.getTvShowDetail(id = id)
    }

}