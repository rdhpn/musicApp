package com.example.musicApp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.musicApp.databinding.FragmentDetailsBinding
import com.example.musicApp.utils.BaseFragment
import com.example.musicApp.utils.UIState
import com.example.musicapp.model.domain.Rock
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

class DetailsFragment : BaseFragment() {

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        musicViewModel.rock.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<*> -> {
//                        val track = state.response as List<Rock>
                    val player: ExoPlayer = SimpleExoPlayer.Builder(requireContext()).build()
                    binding.exoPlayerVIew.player = player
                    // Build the media item.

                    // Build the media item.
                    val mediaItem: MediaItem = MediaItem.fromUri(previewUrl)
// Set the media item to be played.
                    player.setMediaItem(mediaItem)
// Prepare the player.
                    player.prepare()
// Start the playback.
                    player.play()

                }
                is UIState.ERROR -> {
                    AlertDialog.Builder(requireActivity())
                        .setTitle("Error occurred")
                        .setMessage(state.error.localizedMessage)
                        .setPositiveButton("RETRY") { dialog, _ ->
                            musicViewModel.getRocks()
                            dialog.dismiss()
                        }
                        .setNegativeButton("DISMISS") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                }
            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (!musicViewModel.fragmentState) {
            musicViewModel.getRocks()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        musicViewModel.fragmentState = true
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        musicViewModel.fragmentState = false
    }
}