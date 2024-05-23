package org.example.friendexam.reopsitory;

import org.example.friendexam.domain.Friend;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//2개 추가함 ( 1 기본 CRUD , 2 페이징 처리를 위한 인터페이스)
public interface FriendRepository extends CrudRepository<Friend, Long>, PagingAndSortingRepository<Friend, Long> {

}
