package com.qm.cleanmodule.ui.fragment.songs

import com.qm.cleanmodule.R
import com.qm.cleanmodule.base.view.BaseAdapter
import com.qm.cleanmodule.base.view.BaseViewHolder

class SongsAdapter(itemClick: (SongsItem) -> Unit) : BaseAdapter<SongsItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_song_view


    override fun onViewHolderCreated(viewHolder: BaseViewHolder<SongsItem>) {

    }
}