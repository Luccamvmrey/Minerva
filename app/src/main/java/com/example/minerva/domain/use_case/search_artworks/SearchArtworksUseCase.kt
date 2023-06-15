package com.example.minerva.domain.use_case.search_artworks

import com.example.minerva.domain.model.Resource
import com.example.minerva.domain.model.Resource.Error
import com.example.minerva.domain.model.Resource.Loading
import com.example.minerva.domain.model.Resource.Success
import com.example.minerva.domain.model.artwork.ArtworkList
import com.example.minerva.domain.repository.ArtworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchArtworksUseCase @Inject constructor(
    private val repo: ArtworkRepository
) {
    operator fun invoke(query: String): Flow<Resource<ArtworkList>> = flow {
        try {
            emit(Loading<ArtworkList>())

            val filteredQuery = query.lowercase().trim { it <= ' ' }

            val artworks = repo.searchArtworks(filteredQuery)
            emit(Success<ArtworkList>(artworks))
        } catch (e: HttpException) {
            emit(
                Error<ArtworkList>(
                    e.localizedMessage ?: "Ocorreu um erro inesperado!"
                )
            )
        } catch (e: IOException) {
            emit(
                Error<ArtworkList>(
                    "Não foi possível acessar o servidor, por favor, cheque sua conexão" +
                            " com a internet"
                )
            )
        }
    }
}