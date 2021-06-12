package com.qm.cleanmodule.ui.fragment.songdetails

import android.app.Application

import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.ui.fragment.songs.SongsResponse.SongsResponseItem as  SongsResponse

class SongDetailsViewModel(app: Application) : AndroidBaseViewModel(app) {

  var item:  SongsResponse? = null

  fun gotData(args: SongDetailsFragmentArgs)
  {
    args.songitem?.let {
      //this.item = it
      //notifyChange()
    }
  }
}

