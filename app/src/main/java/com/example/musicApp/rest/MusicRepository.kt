package com.example.musicApp.rest

import com.example.musicApp.R
import com.example.musicApp.database.MusicDAO
import com.example.musicApp.model.MusicResponse
import com.example.musicApp.model.domain.Rock
import com.example.musicApp.model.domain.mapToRock
import com.example.musicApp.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MusicRepository {
    fun getRocks(): Flow<UIState<MusicResponse>>
    fun getPops(): Flow<UIState<MusicResponse>>
    fun getClassics(): Flow<UIState<MusicResponse>>
//    fun getPreviewUrl(): Flow<UIState<Track>>
//    fun getRockById(trackId: String): Flow<UIState<Rock>>
}

class MusicRepositoryImpl @Inject constructor(
    private val musicApi: MusicApi,
    private var musicDAO: MusicDAO
) : MusicRepository {

    override fun getRocks(): Flow<UIState<MusicResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = musicApi.getListBy("rocks","music","song", "50")
            if (response.isSuccessful) {
                response.body()?.let {
                    UIState.SUCCESS(it).response.results?.let { it -> musicDAO.insertRock(it[0].mapToRock()) }

                   emit(UIState.SUCCESS(it))
                } ?: throw NullRockResponse()
            } else if (musicDAO.getRocks().isNotEmpty()) {
                val rock = musicDAO.getRocks()
                emit(UIState.SUCCESS(rock as MusicResponse))
            }
            else
            {
                    throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getPops(): Flow<UIState<MusicResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = musicApi.getListBy("pops","music","song", "50")
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: throw NullPopsResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getClassics(): Flow<UIState<MusicResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = musicApi.getListBy("classick","music","song", "50")
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(UIState.SUCCESS(it))
                } ?: throw NullClassicsResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

//    override fun getPreviewUrl(): Flow<UIState<Track>> = flow {
//        emit(UIState.LOADING)
//        try {
//            val response = musicApi.getListBy("rocks","music","song", "50")
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    emit(UIState.SUCCESS(it))
////                    emit(UIState.SUCCESS(it.results.mapToRock()))
//                } ?: throw NullRockResponse()
//            } else {
//                throw FailureResponse(response.errorBody()?.string())
//            }
//        } catch (e: Exception) {
//            emit(UIState.ERROR(e))
//        }
//    }

//    override fun getRockById(trackId: String): Flow<UIState<Rock>> = flow {
//        emit(UIState.LOADING)
//
//        try {
//            val response = musicApi.getListBy("rocks","music","song", "50")
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    emit(UIState.SUCCESS(it))
////                    emit(UIState.SUCCESS(it.results.mapToRock()))
//                } ?: throw NullRockResponse()
//            } else {
//                throw FailureResponse(response.errorBody()?.string())
//            }
//        } catch (e: Exception) {
//            emit(UIState.ERROR(e))
//        }
//    }

//    override fun getPops(): Flow<UIState<MusicResponse>> = flow {
//        emit(UIState.LOADING)
//
//        try {
//            val response = musicApi.getPopsAsync().await()
//            if (response.isSuccessful) {
//                response.body()?.let {
//
//                } ?: throw NullPopsResponse()
//            } else {
//                throw FailureResponse(response.errorBody()?.string())
//            }
//        } catch (e: Exception) {
//            emit(UIState.ERROR(e))
//        }
//
//    }
//
//    override fun getPopById(id: String): Flow<UIState<Pop>> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getClassics(): Flow<UIState<MusicResponse>> = flow {
//        emit(UIState.LOADING)
//
//        try {
//            val response = musicApi.getClassics()
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    // todo emit success value
//                } ?: throw NullClassicsResponse()
//            } else {
//                throw FailureResponse(response.errorBody()?.string())
//            }
//        } catch (e: Exception) {
//            emit(UIState.ERROR(e))
//        }
//    }
//
//    override fun getClassicById(id: String): Flow<UIState<Classic>> = flow {
//        emit(UIState.LOADING)
//
//        try {
//            val response = musicApi.getClassicById(id)
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    emit(UIState.SUCCESS(it.result.mapToClassic()))
//                } ?: throw NullRockResponse()
//            } else {
//                throw FailureResponse(response.errorBody()?.string())
//            }
//        } catch (e: Exception) {
//            emit(UIState.ERROR(e))
//        }
//    }

}