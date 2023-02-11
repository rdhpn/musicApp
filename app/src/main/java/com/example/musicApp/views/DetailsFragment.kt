package com.example.musicApp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.musicApp.databinding.FragmentDetailsBinding
import com.example.musicApp.utils.BaseFragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import android.net.Uri;
import android.util.Log

private const val TAG = "DetailsFragment"

class DetailsFragment : BaseFragment() {
    private var player: ExoPlayer? = null
    private var playWhenReady = true
    private var currentItem = 0
    private var playBackPosition = 0L


    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }
    private fun initializePlayer() {
        player = ExoPlayer.Builder(this.requireContext())
            .build()
            .also { player ->
                binding.videoView.player = player
//                if (musicViewModel.selectedTrackPreviewUrl != null)
try {
    val urlMusic = Uri.parse(musicViewModel.selectedTrackPreviewUrl.value!!.toString())
                val mediaItem: MediaItem = MediaItem.fromUri(urlMusic)
                player.setMediaItem(mediaItem)
                player.playWhenReady = playWhenReady
                player.seekTo(currentItem, playBackPosition)
                player.prepare()

} catch (error: NullPointerException)
{
    Log.d(TAG, "initializePlayer: Error")}
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (!musicViewModel.fragmentState) {
            musicViewModel.getRocks()
        }
    }

    private fun releasePlayer() {
        player?.let {
            playWhenReady = it.playWhenReady
            currentItem = it.currentMediaItemIndex
            playBackPosition = it.currentPosition
            it.release()
        }
        player = null
    }
    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

}