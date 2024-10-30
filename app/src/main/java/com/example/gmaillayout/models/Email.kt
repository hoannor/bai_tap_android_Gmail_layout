package com.example.gmaillayout.models

data class Email(
    val sender: String,
    val subject: String,
    val summary: String,
    val time: String,
    val avatarResId: Int
)