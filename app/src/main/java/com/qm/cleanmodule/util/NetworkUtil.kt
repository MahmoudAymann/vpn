package com.qm.cleanmodule.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri.Builder
import android.os.Build
import android.util.Log
import com.qm.cleanmodule.ui.fragment.songs.SongsResponse.SongsResponseItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

const val TAG = "NetworkUtil"

@Suppress("DEPRECATION")
private fun isNetworkAvailable(context: Context): Boolean {
  val connectivityManager =
    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    val nw = connectivityManager.activeNetwork ?: return false
    val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
    return when {
      actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
      actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
      actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
      actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
      else -> false
    }
  } else {
    return connectivityManager.activeNetworkInfo?.isConnected ?: false
  }
}

fun getHeaders(): Map<String, String> {
  val headers = mutableMapOf<String, String>()
  headers["Authorization"] = "Bearer Ca688e8d3-600c-4e51-b5ee-f647a0774c9a"
  headers["X-MM-GATEWAY-KEY"] = "Ge6c853cf-5593-a196-efdb-e3fd7b881eca"
  headers["Content-Type"] = "application/json"
  return headers
}

interface NetworkHandler {
  fun onSuccess(res: List<SongsResponseItem>?)
  fun onFailure(error: String?)
}

object NetworkUtil {
  fun requestCall(
    context: Context,
    scope: CoroutineScope,
    params: MutableMap<String, Any?>,
    callBack: NetworkHandler
  ) {
    if (!isNetworkAvailable(context)) {
      callBack.onFailure("check your network")
      return
    }
    scope.launch(Dispatchers.IO) {
      try {
        // http://staging-gateway.mondiamedia.com/v2/api/sayt/flat
        val uri = Builder()
          .scheme("http")
          .authority("staging-gateway.mondiamedia.com")
          .path("v2/api/sayt/flat")
        params.forEach { (k, v) ->
          uri.appendQueryParameter(k, v.toString())
        }
        uri.build()
        val url = URL(uri.toString())
        val httpURLConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "GET"
        httpURLConnection.addHeaders(getHeaders())
        Log.e(TAG, "headers: ${httpURLConnection.headerFields}")
        try {
          val st = helpX.mapStreamToJs(httpURLConnection.inputStream)
          val sexyList =
            st?.mStringToJsonElement()?.asJsonArray?.mMapToArrayListFix<SongsResponseItem>()

          Log.e(TAG, "response: " + sexyList?.first()?.title)
        } catch (e: Exception) {
          e.printStackTrace()
          callBack.onFailure(e.message)
        } finally {
          // close connection
          httpURLConnection.disconnect()
        }
      } catch (e: Exception) {
        e.printStackTrace()
        callBack.onFailure(e.message)
      }

    }
  }

  private fun HttpURLConnection.addHeaders(headers: Map<String, String>) {
    headers.forEach { (k, v) ->
      addRequestProperty(k, v)
    }
  }
}

object helpX {
  fun mapStreamToJs(st: InputStream): String? {
    val reader = BufferedReader(InputStreamReader(st))
    val sb = StringBuilder()

    var line: String? = null
    try {
      while (reader.readLine().also { line = it } != null) {
        sb.append(
          """
            $line
            
            """.trimIndent()
        )
      }
    } catch (e: IOException) {
      e.printStackTrace()
    } finally {
      try {
        st.close()
      } catch (e: IOException) {
        e.printStackTrace()
      }
    }
    return sb.toString()
  }
}