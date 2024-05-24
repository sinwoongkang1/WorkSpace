package org.example.boardprojectmini.repository;

import org.example.boardprojectmini.board.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, Long>, PagingAndSortingRepository<Board, Long> {

}
