package com.seminar.springkotlin.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class NoExistBoardException(message: String) : RuntimeException(message)