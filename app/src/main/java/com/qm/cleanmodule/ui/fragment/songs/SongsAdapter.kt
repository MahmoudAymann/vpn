package com.qm.cleanmodule.ui.fragment.songs

import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.view.BaseAdapter
import com.qm.cleanmodule.base.view.BaseViewHolder

class SongsAdapter(itemClick: (SongsResponse.SongsResponseItem) -> Unit) : BaseAdapter< SongsResponse.SongsResponseItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_song_view


    override fun onViewHolderCreated(viewHolder: BaseViewHolder< SongsResponse.SongsResponseItem>) {

    }
}