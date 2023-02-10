package com.example.musicApp.utils

class NullRockResponse(message: String = "Rock response is null") : Exception(message)
class NullClassicsResponse(message: String = "Classics response is null") : Exception(message)
class NullPopsResponse(message: String = "Pops response is null") : Exception(message)
class FailureResponse(message: String?) : Exception(message)