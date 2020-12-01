package com.gustavhiki.testplayer

import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.gustavhiki.testplayer.databinding.FragmentPlayerPaneBinding

class PlayerFragment : Fragment() {

    private lateinit var binding: FragmentPlayerPaneBinding
    private lateinit var trackAdapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerPaneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvTrack.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.rvTrack.setHasFixedSize(true)

        trackAdapter = TrackAdapter()
        trackAdapter.setTracks(createTracks())
        binding.rvTrack.adapter = trackAdapter


        LinearSnapHelper().attachToRecyclerView(binding.rvTrack)
    }

    private fun createTracks(): List<Track>{
        val listTrack = ArrayList<Track>()

        val imageUrl = "https://upload.wikimedia.org/wikipedia/ru/7/7f/The_Beatles_-_Abbey_Road.jpg"

        listTrack.add(Track("You Never Give Me Your Money", "The Beatles - Abbey Road", imageUrl))
        listTrack.add(Track("Sun King", "The Beatles - Abbey Road", imageUrl))
        listTrack.add(Track("The End", "The Beatles - Abbey Road", imageUrl))

        return listTrack
    }
}