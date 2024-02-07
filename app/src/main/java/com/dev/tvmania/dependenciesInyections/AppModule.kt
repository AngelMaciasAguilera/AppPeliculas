package com.dev.tvmania.dependenciesInyections

import android.content.Context
import com.dev.tvmania.view.application.TvManiaApplication
import com.dev.tvmania.model.api.Api
import com.dev.tvmania.model.repository.TvShowRepositoryImpl
import com.dev.tvmania.model.domain.repository.TvShowRepository
import com.dev.tvmania.model.usecase.GetTvShowDetail
import com.dev.tvmania.model.usecase.GetTvShows
import com.dev.tvmania.model.usecase.TvShowUseCases
import com.dev.tvmania.view.util.ApiBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Proporciona una instancia de TvManiaApplication para la inyección de dependencias.
    @Singleton
    @Provides
    fun providesTvManiaApplication(
        @ApplicationContext app: Context
    ): TvManiaApplication {
        return app as TvManiaApplication
    }


    // Proporciona una instancia de Api para la inyección de dependencias.
    @Singleton
    @Provides
    fun providesApi(apiBuilder: ApiBuilder): Api {
        return apiBuilder.builder(api = Api::class.java)
    }

    // Proporciona una instancia de TvShowRepository para la inyección de dependencias.
    @Singleton
    @Provides
    fun providesTvShowRepository(api: Api): TvShowRepository {
        return TvShowRepositoryImpl(api = api)
    }

    // Proporciona una instancia de TvShowUseCases para la inyección de dependencias.
    @Singleton
    @Provides
    fun providesTvShowUseCases(repository: TvShowRepository): TvShowUseCases {
        return TvShowUseCases(
            getTvShows = GetTvShows(repository = repository),
            getTvShowDetail = GetTvShowDetail(repository = repository)
        )
    }
}