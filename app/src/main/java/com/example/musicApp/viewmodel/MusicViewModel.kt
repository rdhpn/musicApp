package com.example.musicApp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicApp.model.MusicResponse
import com.example.musicApp.rest.MusicRepository
import com.example.musicApp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MusicViewModel"
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

    private val _selectedTrackPreviewUrl: MutableLiveData<String> = MutableLiveData("")
    val selectedTrackPreviewUrl: LiveData<String> get() = _selectedTrackPreviewUrl
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
    fun selectTrack(previewUrl: String){
        _selectedTrackPreviewUrl.value = previewUrl
    }

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