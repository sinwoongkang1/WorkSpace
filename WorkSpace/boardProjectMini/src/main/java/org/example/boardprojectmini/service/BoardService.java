package org.example.boardprojectmini.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.boardprojectmini.board.Board;
import org.example.boardprojectmini.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    public final BoardRepository boardRepository;

    public Page<Board> findList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return boardRepository.findAll(pageable);
    }
    @Transactional
    public Board saveBoard(Board board) {
       return boardRepository.save(board);
    }
    @Transactional(readOnly = true)
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
    public Board updateBoard(Board board) {
        return boardRepository.save(board);
    }
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public boolean checkPassword(Long id, String password) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            return board.getPassword().equals(password);
        }
        return false;
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }


}
