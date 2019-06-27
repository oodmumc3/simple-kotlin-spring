package com.seminar.springkotlin.service.impl

import com.seminar.springkotlin.entity.BoardKotlin
import com.seminar.springkotlin.exceptions.NoExistBoardException
import com.seminar.springkotlin.model.BoardDetailVO
import com.seminar.springkotlin.model.BoardParamTO
import com.seminar.springkotlin.model.BoardVO
import com.seminar.springkotlin.repository.BoardKotlinRepository
import com.seminar.springkotlin.service.BoardService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class BoardServiceImpl(
    private val boardKotlinRepository: BoardKotlinRepository
) : BoardService {
    override fun saveOfBoard(paramTO: BoardParamTO) {
        val board = with(paramTO) {
            BoardKotlin(
                title = title,
                contents = contents,
                regUserName = regUserName
            )
        }

        boardKotlinRepository.save(board)
    }

    override fun getBoardById(id: Int): BoardDetailVO {
        val board = boardKotlinRepository
            .findById(id)
            .orElseThrow { NoExistBoardException("no exist board! id is $id") }

        return with(board) {
            BoardDetailVO(
                id = id,
                title = title,
                contents = contents,
                regUserName = regUserName,
                regDate = regDate,
                updateDate = updateDate
            )
        }
    }

    override fun updateOfBoardById(id: Int, paramTO: BoardParamTO) {
        val board = boardKotlinRepository
            .findById(id)
            .orElseThrow { NoExistBoardException("no exist board! id is $id") }

        boardKotlinRepository.save(
            board.apply {
                title = paramTO.title
                contents = paramTO.contents
                updateDate = LocalDateTime.now()
            }
        )
    }

    override fun deleteOfBoardById(id: Int) {
        boardKotlinRepository
            .findById(id)
            .ifPresent { boardKotlinRepository.delete(it) }
    }

    override fun getAllBoardList(): List<BoardVO> {
        return boardKotlinRepository.findAll().map {
            BoardVO(
                id = it.id!!,
                title = it.title,
                regUserName =  it.regUserName,
                regDate = it.regDate,
                updateDate = it.updateDate
            )
        }
    }
}