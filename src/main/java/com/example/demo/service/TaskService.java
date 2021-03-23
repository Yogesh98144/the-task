package com.example.demo.service;

import java.util.Map;

public interface TaskService {

	Map<String, Object> createChatLog(String userId, Map<String, Object> requestBody);

	void deleteChatlog(String userId, String messageId);

	void deleteChatlogsOfUser(String userId);

	Map<String, Object> getChatlogOfUser(String userId, int page, int size);

}
