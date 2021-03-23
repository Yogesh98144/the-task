package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ChatLog;
import com.example.demo.entity.ChatLogPrimaryKey;
import com.example.demo.repo.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepo taskRepo;
	
	@Override
	public Map<String, Object> createChatLog(String userId, Map<String, Object> requestBody) {

		String messageId=UUID.randomUUID().toString();
		Map<String, Object> returnMap=new HashMap<>();
		
		Long sentOn = (Long) requestBody.get("timestamp");
		Date sentDate = new Date(sentOn);
		ChatLog chatlogs=new ChatLog(new ChatLogPrimaryKey(userId, messageId), sentDate, (boolean)requestBody.get("isSent"), (String)requestBody.get("message"));
		
		taskRepo.save(chatlogs);
		return returnMap;
	}

	@Override
	public void deleteChatlog(String userId, String messageId) {
		ChatLogPrimaryKey chatLog=new ChatLogPrimaryKey(userId, messageId);
		taskRepo.deleteById(chatLog);		
	}

	@Override
	public void deleteChatlogsOfUser(String userId) {
		
		taskRepo.deleteByKeySentBy(userId);
		
	}

	@Override
	public Map<String, Object> getChatlogOfUser(String userId, int page, int size) {
		
		Pageable sortedBy= PageRequest.of(page, size, Sort.by("sent_on").descending());
		Slice<ChatLog> slice =taskRepo.findAllByKeySentBy(userId, sortedBy);
		Map<String, Object> returnMap=new HashMap<>();
		
		return slice.getContent();
	}

}
