package com.qm.cleanmodule.ui.fragment.songs

import java.time.temporal.TemporalQuery

data class SongRequest(
  var name: String? = null
) {

  fun isValid(): Boolean {
    return name.isNullOrBlank()
  }

  fun getParams(query: String?): Map<String, Any?>{
    val params = mutableMapOf<String, Any?>()
    params["query"] = query
    params["includeArtists"] = true
    params["limit"] = "20"
    params["lang"] = "en"
    return params
  }

}
