package com.seminar.springkotlin.model

import java.time.LocalDateTime

data class BoardVO(
    val id: Int,
    val title: String,
    val regUserName: String,
    val regDate: LocalDateTime,
    val updateDate: LocalDateTime
)