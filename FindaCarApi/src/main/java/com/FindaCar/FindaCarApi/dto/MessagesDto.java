package com.FindaCar.FindaCarApi.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class MessagesDto.
 */
public class MessagesDto {

	/** The id. */
	private long id;
	
	/** The conversation. */
	private ConversationDto conversation;
	

	public ConversationDto getConversation() {
		return conversation;
	}

	/**
	 * Sets the conversation.
	 *
	 * @param conversation the new conversation
	 */
	public void setConversation(ConversationDto conversation) {
		this.conversation = conversation;
	}
	/** The content. */
	private String content;	
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	

}
