package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChatLogPrimaryKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="sent_by")
	private String sentBy;
	
	@Column(name="message_id")
	private String messageId;

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "ChatLogPrimaryKey [sentBy=" + sentBy + ", messageId=" + messageId + "]";
	}

	public ChatLogPrimaryKey(String sentBy, String messageId) {
		super();
		this.sentBy = sentBy;
		this.messageId = messageId;
	}
	
}
