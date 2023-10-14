package com.example.lyordbankdemo.domain

import com.example.lyordbankdemo.APIs
import com.google.gson.JsonObject
import javax.inject.Inject

class SampleUseCase @Inject constructor(
    private val apIs: APIs
) {
    suspend operator fun invoke(): JsonObject {
        val response = apIs.sampleGet()
        return response
    }
}