package com.gustavhiki.testplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TrackAdapter :
    RecyclerView.Adapter<TrackAdapter.TrackHolder>() {

    var trackList: List<Track> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        return TrackHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {
        holder.apply {
            tvTitle.text = trackList[position].title
            tvAlbum.text = trackList[position].album

            loadImagesToContainer(holder.itemView, holder.coverImage, trackList[position].coverUrl)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        if (trackList == null || trackList.isEmpty()) {
            return 0
        }
        return trackList.size
    }

    fun setTracks(posts: List<Track>) {
        val utils = TrackDiffUtils(trackList, posts)
        val diffResult = DiffUtil.calculateDiff(utils)
        this.trackList = posts
        diffResult.dispatchUpdatesTo(this)
    }

    private fun loadImagesToContainer(
        itemView: View,
        imageView: ImageView,
        coverUrl: String
    ) {

        Glide.with(itemView.context)
            .load(coverUrl)
            .into(imageView)
            .clearOnDetach()
    }

    inner class TrackHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvAlbum: TextView = itemView.findViewById(R.id.tv_album)
        val coverImage: ImageView = itemView.findViewById(R.id.rounded_image)
    }
}