package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("v1/chatlogs/{user_id}")
	ResponseEntity<Map<String, Object>> createChatlog(@PathVariable("user_id")String userId, 
			@RequestBody Map<String, Object> requestBody){
		
		return new ResponseEntity<>(taskService.createChatLog(userId, requestBody), HttpStatus.OK);
	}

	@GetMapping("v1/chatlogs/{user_id}")
	ResponseEntity<Map<String, Object>> getChatlogOfUser(@PathVariable("user_id")String userId,
			@RequestParam(name="page") int page, @RequestParam(name="size") int size){
		
		return new ResponseEntity<>(taskService.getChatlogOfUser(userId, page, size), HttpStatus.OK);
	}
	
	@DeleteMapping("v1/chatlogs/{user_id}/{message_id}")
	ResponseEntity<?> deleteChatlog(@PathVariable("user_id")String userId, 
			@PathVariable("message_id")String messageId){
		taskService.deleteChatlog(userId, messageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("v1/chatlogs/{user_id}")
	ResponseEntity<?> deleteChatlogsOfUser(@PathVariable("user_id")String userId){
		
		taskService.deleteChatlogsOfUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
