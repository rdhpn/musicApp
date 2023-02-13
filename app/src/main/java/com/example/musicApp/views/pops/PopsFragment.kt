package com.example.musicApp.views.pops

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicApp.R
import com.example.musicApp.databinding.FragmentCommonViewBinding
import com.example.musicApp.model.MusicResponse
import com.example.musicApp.utils.BaseFragment
import com.example.musicApp.utils.UIState
import com.example.musicApp.views.adapter.MusicAdapter

private const val TAG = "PopsFragment"
class PopsFragment : BaseFragment() {

    private val binding by lazy {
        FragmentCommonViewBinding.inflate(layoutInflater)
    }

    private val musicAdapter by lazy {
        MusicAdapter {
            // Bind the player to the view.

//            musicViewModel.openPopsFragment = true
            musicViewModel.selectTrack(it)
            findNavController().navigate(R.id.action_PopsFragment_to_DetailedFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        // Inflate the layout for this fragment

        binding.musicRv.apply {
            layoutManager  =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = musicAdapter
        }

        musicViewModel.pop.observe(viewLifecycleOwner)  { state ->
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<MusicResponse> -> {
                    musicAdapter.updateItems(state.response.results ?: emptyList())
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage) {
                        // todo define an action
                    }
                }
            }
        }

        binding.swiperefresh.setOnRefreshListener {
            binding.swiperefresh.isRefreshing = false
            musicViewModel.pop.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is UIState.LOADING -> {}
                    is UIState.SUCCESS<MusicResponse> -> {
                        musicAdapter.updateItems(state.response.results ?: emptyList())
                    }
                    is UIState.ERROR -> {
                        showError(state.error.localizedMessage) {
                            // todo define an action
                        }
                    }
                }
            }
        }
        return binding.root
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        musicViewModel.fragmentState = true
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        musicViewModel.fragmentState = false
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
//        musicViewModel.openPopsFragment = false
    }
}