package com.qm.cleanmodule.data.remote

import com.mabaat.androidapp.base.network.response.NetworkResponse
import com.qm.cleanmodule.ui.fragment.login.LoginRequest
import com.qm.cleanmodule.ui.fragment.login.LoginResponse


/**
 * Created by MahmoudAyman on 7/28/2020.
 **/

class ApiHelper(private val apiService: ApiService) : ApiService {
    override suspend fun login(request: LoginRequest): NetworkResponse<LoginResponse, ErrorResponse> = apiService.login(request)
}