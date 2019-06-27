package com.seminar.springkotlin.service

import com.seminar.springkotlin.model.BoardDetailVO
import com.seminar.springkotlin.model.BoardParamTO
import com.seminar.springkotlin.model.BoardVO

interface BoardService {
    fun saveOfBoard(paramTO: BoardParamTO)
    fun getAllBoardList(): List<BoardVO>
    fun getBoardById(id: Int): BoardDetailVO
    fun updateOfBoardById(id: Int, paramTO: BoardParamTO)
    fun deleteOfBoardById(id: Int)
}