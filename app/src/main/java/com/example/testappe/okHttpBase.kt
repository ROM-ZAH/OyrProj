package com.example.testappe

import android.view.View
import android.widget.ProgressBar
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

fun POST(username :String, userPassword :String): Request
{
    val jsonObject = JSONObject();

    jsonObject.put("login", username.toString());
    jsonObject.put("password", userPassword.toString());

    val client = OkHttpClient()
    val mediaType = "application/json; charset=utf-8".toMediaType()
    val body = jsonObject.toString().toRequestBody(mediaType)
    return Request.Builder()
        .url("https://gpn.unmanned.ru/api/login/")
        .post(body)
        .build()
}

fun GET(token :String): Request
{
    val jsonObject = JSONObject();

    val client = OkHttpClient()
    val mediaType = "application/json; charset=utf-8".toMediaType()
    val body = jsonObject.toString().toRequestBody(mediaType)
    return Request.Builder()
        .url("https://gpn.unmanned.ru/api/profile?token=$token")
        .get()
        .build()
}

