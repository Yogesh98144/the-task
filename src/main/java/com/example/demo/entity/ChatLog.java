package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="chat_logs")
public class ChatLog {

	@EmbeddedId
	ChatLogPrimaryKey key;
	
	@Column(name="sent_on")
	private Date sentOn;
	
	@Column(name="is_sent")
	private Boolean isSent;
	
	@Column(name="message")
	private String message;

	public ChatLogPrimaryKey getKey() {
		return key;
	}

	public void setKey(ChatLogPrimaryKey key) {
		this.key = key;
	}

	public Date getSentOn() {
		return sentOn;
	}

	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}

	public Boolean getIsSent() {
		return isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChatLog [key=" + key + ", sentOn=" + sentOn + ", isSent=" + isSent + ", message=" + message + "]";
	}

	public ChatLog(ChatLogPrimaryKey key, Date sentOn, Boolean isSent, String message) {
		super();
		this.key = key;
		this.sentOn = sentOn;
		this.isSent = isSent;
		this.message = message;
	}

	public ChatLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
