package com.example.musicApp.rest

import com.example.musicApp.model.MusicResponse
//import com.example.musicApp.model.domain.*
import com.example.musicApp.utils.*
import com.example.musicapp.model.domain.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MusicRepository {
    fun getRocks(): Flow<UIState<MusicResponse>>
//    fun getPreviewUrl(): Flow<UIState<Track>>
//    fun getRockById(trackId: String): Flow<UIState<Rock>>
}

class MusicRepositoryImpl @Inject constructor(
    private val musicApi: MusicApi
) : MusicRepository {

    override fun getRocks(): Flow<UIState<MusicResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = musicApi.getListBy("rocks","music","song", "50")
            if (response.isSuccessful) {
                response.body()?.let {
                   emit(UIState.SUCCESS(it))
                } ?: throw NullRockResponse()
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