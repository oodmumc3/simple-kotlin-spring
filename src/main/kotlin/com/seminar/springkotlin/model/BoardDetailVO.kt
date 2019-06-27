package com.seminar.springkotlin.model

import java.time.LocalDateTime

data class BoardDetailVO(
    val id: Int,
    val title: String,
    val contents: String,
    val regUserName: String,
    val regDate: LocalDateTime,
    val updateDate: LocalDateTime
)