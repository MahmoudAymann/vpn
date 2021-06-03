package com.qm.cleanmodule.ui.fragment.songdetails


import android.app.Application
import com.android.volley.NetworkResponse
import com.android.volley.ParseError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.qm.cleanmodule.base.viewmodel.AndroidBaseViewModel
import com.qm.cleanmodule.ui.fragment.songs.SongsItem
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset

class SongDetailsViewModel(app: Application) : AndroidBaseViewModel(app) {

    var item = SongsItem()

    fun gotData(args: SongDetailsFragmentArgs){
        args.songitem?.let {
            this.item = it
            notifyChange()
        }
    }





}

