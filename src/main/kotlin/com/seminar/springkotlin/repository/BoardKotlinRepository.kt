package com.seminar.springkotlin.repository

import com.seminar.springkotlin.entity.BoardKotlin
import org.springframework.data.jpa.repository.JpaRepository

interface BoardKotlinRepository: JpaRepository<BoardKotlin, Int>
