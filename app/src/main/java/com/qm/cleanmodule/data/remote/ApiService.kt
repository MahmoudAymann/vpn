package com.qm.cleanmodule.data.remote

import com.mabaat.androidapp.base.network.response.NetworkResponse
import com.qm.cleanmodule.ui.fragment.login.LoginRequest
import com.qm.cleanmodule.ui.fragment.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by MahmoudAyman on 6/24/2020.
 **/

interface ApiService {

  @POST("login")
    suspend fun login(@Body request: LoginRequest): NetworkResponse<LoginResponse, ErrorResponse>
}