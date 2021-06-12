package com.qm.cleanmodule.ui.fragment.songs

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.util.NetworkHandler
import com.qm.cleanmodule.util.NetworkUtil
import com.qm.cleanmodule.util.Resources

class SongViewModel(app: Application) : AndroidBaseViewModel(app) {

  val request = SongRequest()
  val adapter = SongsAdapter(::onItemClick)

  private fun onItemClick(songsItem: SongsResponse.SongsResponseItem) {
    setValue(songsItem)
  }

  fun getData() {
    if (request.isValid()) return
    postResult(Resources.loading(null))

    val params = mutableMapOf<String, Any?>()
    params["query"] = request.name
    params["limit"] = "20"
    params["lang"] = "en"
    params["includeArtists"] = true


    NetworkUtil.requestCall(
      context = app, scope = viewModelScope, params, object : NetworkHandler {
      override fun onSuccess(res: List<SongsResponse.SongsResponseItem>?) {
        postResult(Resources.success(res))
        adapter.setList(res)
      }

      override fun onFailure(error: String?) {
        postResult(Resources.message(error))
      }
    }// network util
    )//request call
  } // get data
}//vm