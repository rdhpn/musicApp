package com.example.musicApp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicApp.model.MusicResponse
import com.example.musicapp.model.domain.Rock
import com.example.musicApp.rest.MusicRepository
import com.example.musicApp.utils.UIState
import com.example.musicapp.model.domain.Classic
import com.example.musicapp.model.domain.Pop
import com.example.musicapp.model.domain.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        getRocks()
//        getClassics()
//        getPops()
    }

    var fragmentState: Boolean = false

    private val _rock: MutableLiveData<UIState<MusicResponse>> = MutableLiveData(UIState.LOADING)
    val rock: LiveData<UIState<MusicResponse>> get() = _rock

    private val _trackPreviewUrl: MutableLiveData<UIState<String>> = MutableLiveData(UIState.LOADING)
    val trackPreviewUrl: LiveData<UIState<String>> get() = _trackPreviewUrl
//    private val _rockDetails: MutableLiveData<UIState<Rock>?> = MutableLiveData(UIState.LOADING)
//    val rockDetails: LiveData<UIState<Rock>> get() = _rockDetails

//    private val _classics: MutableLiveData<UIState<MusicResponse>> = MutableLiveData(UIState.LOADING)
//    val classics: LiveData<UIState<MusicResponse>> get() = _classics
//
//    private val _classicDetails: MutableLiveData<UIState<Classic>> = MutableLiveData(UIState.LOADING)
//    val classicDetails: LiveData<UIState<Classic>> get() = _classicDetails
//
//    private val _pops: MutableStateFlow<UIState<MusicResponse>> = MutableStateFlow(UIState.LOADING)
//    val pops: StateFlow<UIState<MusicResponse>> get() = _pops
//
//    private val _popDetails: MutableLiveData<UIState<Pop>> = MutableLiveData(UIState.LOADING)
//    val popDetails: LiveData<UIState<Pop>> get() = _popDetails

    fun getRocks() {
        viewModelScope.launch(ioDispatcher) {
            musicRepository.getRocks().collect {
                _rock.postValue(it)
            }
        }
    }

//    fun getTrackPreviewUrl(previewUrl: String? = null) {
//       previewUrl ?.let {
//            viewModelScope.launch(ioDispatcher) {
////                    _trackPreviewUrl.postValue(UIState)
//                _trackPreviewUrl = MutableLiveData<UIState<it>>
//            }
//        }
//    }
//    fun getRocks(id: String? = null) {
//        id?.let {
//            viewModelScope.launch(ioDispatcher) {
//                musicRepository.getRockById(it).collect {
//                    _rockDetails.postValue(UIState.SUCCESS(it).response)
//                }
//            }
//        } ?: run {
//            viewModelScope.launch(ioDispatcher) {
//                musicRepository.getRocks().collect {
//                    _rock.postValue(it)
//                }
//            }
//        }
//    }
//
//    fun getClassics(id: String? = null) {
//        id?.let {
//            viewModelScope.launch(ioDispatcher) {
//                musicRepository.getClassicById(it).collect {
//                    _classicDetails.postValue(it)
//                }
//            }
//        } ?: run {
//            viewModelScope.launch(ioDispatcher) {
//                musicRepository.getClassics().collect {
//                    _classics.postValue(it)
//                }
//            }
//        }
//    }
//
//    fun getPops(id: String? = null) {
//        id?.let {
//            viewModelScope.launch(ioDispatcher) {
//                musicRepository.getPopById(it).collect {
//                    _popDetails.postValue(it)
//                }
//            }
//        } ?: run {
//            viewModelScope.launch(ioDispatcher) {
//                musicRepository.getPops().collect {
//                    _pops.value = it
//                }
//            }
//        }
//    }
}