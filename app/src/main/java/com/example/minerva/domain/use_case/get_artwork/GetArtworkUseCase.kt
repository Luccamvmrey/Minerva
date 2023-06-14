package com.example.minerva.domain.use_case.get_artwork

import com.example.minerva.domain.model.ArtworkDetail
import com.example.minerva.domain.model.Resource
import com.example.minerva.domain.model.Resource.Loading
import com.example.minerva.domain.model.Resource.Success
import com.example.minerva.domain.repository.ArtworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArtworkUseCase @Inject constructor(
    private val repo: ArtworkRepository
) {
    operator fun invoke(artworkId: String): Flow<Resource<ArtworkDetail>> = flow {
        try {
            emit(Loading<ArtworkDetail>())
            val artwork = repo.getArtworkById(artworkId)
            emit(Success<ArtworkDetail>(artwork))
        } catch (e: HttpException) {
            // Emits exception message in case of failure to fetch data
            emit(
                Resource.Error<ArtworkDetail>(
                    e.localizedMessage ?: "Ocorreu um erro inesperado!"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<ArtworkDetail>(
                    "Não foi possível acessar o servidor, por favor, cheque sua conexão" +
                            " com a internet"
                )
            )
        }
    }
}