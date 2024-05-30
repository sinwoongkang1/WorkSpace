package org.example.boardprojectmini.controller;

import org.example.boardprojectmini.board.Board;
import org.example.boardprojectmini.repository.BoardRepository;
import org.example.boardprojectmini.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 5;
        Page<Board> boardPage = boardService.findList(page, pageSize);

        model.addAttribute("boardPage", boardPage);
        model.addAttribute("currentPage", page);
        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("board", new Board());
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String writer(@ModelAttribute("board") Board board) {
        board.setCreated_at(LocalDate.from(LocalDateTime.now()));
        boardService.saveBoard(board);
        return "redirect:/board";
    }

    @GetMapping("/detail/{id}")
    public String boardDetail(@PathVariable Long id, Model model) {
        Board board = boardService.findBoardById(id);
        board.setCreated_at(LocalDate.from(LocalDateTime.now()));
        model.addAttribute("board", board);
        return "board/detailForm";
    }

    @GetMapping("/delete/{id}")
    public String deletePasswordCheck(@PathVariable Long id) {
            boardService.deleteBoard(id);
            return "redirect:/board";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id) {
        Board oldBoard = boardService.findBoardById(id);
        model.addAttribute("board", oldBoard);
        return "board/editForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("board") Board board,@RequestParam Long id,
                         @RequestParam("password") String password, Model model) {
        if (boardService.checkPassword(board.getId(), password)) {
            boardService.saveBoard(board);
            return "redirect:/board";
        } else {
            model.addAttribute("board", board);
            model.addAttribute("error", "비밀번호가 틀렸습니다. 다시 입력해주세요");
            return "board/editForm";
        }
    }
    }

