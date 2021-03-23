package com.example.demo.repo;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ChatLog;
import com.example.demo.entity.ChatLogPrimaryKey;

@Repository
public interface TaskRepo extends CrudRepository<ChatLog, ChatLogPrimaryKey>, PagingAndSortingRepository<ChatLog, ChatLogPrimaryKey>{

	@Modifying
	@Query(nativeQuery=true, value="delete from chat_logs where sent_by=?1")
	void deleteByKeySentBy(String userId);

	Slice<ChatLog> findAllByKeySentBy(String userId, Pageable sortedBy);
}
