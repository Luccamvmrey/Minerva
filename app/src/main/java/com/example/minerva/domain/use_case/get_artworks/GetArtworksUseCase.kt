package com.example.minerva.domain.use_case.get_artworks

import com.example.minerva.domain.model.artwork.ArtworkList
import com.example.minerva.domain.model.Resource
import com.example.minerva.domain.model.Resource.Error
import com.example.minerva.domain.model.Resource.Loading
import com.example.minerva.domain.model.Resource.Success
import com.example.minerva.domain.repository.ArtworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArtworksUseCase @Inject constructor(
    private val repo: ArtworkRepository
) {
    operator fun invoke(): Flow<Resource<ArtworkList>> = flow {
        try {
            // Emits Loading state for resource
            emit(Loading<ArtworkList>())
            // Tries to get artworks from API
            val artworks = repo.getArtworks()
            // If Successful alters state from Loading to Success and passes artwork list
            emit(Success<ArtworkList>(artworks))
        } catch (e: HttpException) {
            // Emits exception message in case of failure to fetch data
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