package com.seminar.springkotlin.controller

import com.seminar.springkotlin.model.BoardParamTO
import com.seminar.springkotlin.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController(
    private val boardService: BoardService
) {
    @PostMapping("/board")
    fun save(@RequestBody paramTO:BoardParamTO) = boardService.saveOfBoard(paramTO)

    @GetMapping("/board")
    fun list() = boardService.getAllBoardList()

    @GetMapping("/board/{id}")
    fun detail(@PathVariable id: Int) = boardService.getBoardById(id)

    @PutMapping("/board/{id}")
    fun update(@PathVariable id: Int, @RequestBody paramTO: BoardParamTO) = boardService.updateOfBoardById(id, paramTO)

    @DeleteMapping("/board/{id}")
    fun delete(@PathVariable id: Int) = boardService.deleteOfBoardById(id)
}