package com.gustavhiki.testplayer

import androidx.recyclerview.widget.DiffUtil

class TrackDiffUtils(val oldList: List<Track>, val newList: List<Track>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if ((oldList[oldItemPosition].album == newList[newItemPosition].album) &&
            (oldList[oldItemPosition].coverUrl == newList[newItemPosition].coverUrl)
        )
            return true
        return false
    }
}