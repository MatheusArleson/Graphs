package br.com.xavier.graphs.util;

import java.util.ResourceBundle;

/**
 * Util class for message externalization.
 * 
 * @author Matheus Xavier
 *
 */
public class MessageManager {
	
	private static final String MESSAGES_FILE_NAME = "messages";
	private static final ResourceBundle MESSAGE_BUNDLE = ResourceBundle.getBundle(MESSAGES_FILE_NAME);
	
	public static String getMessage(String messageKey){
		return MESSAGE_BUNDLE.getString(messageKey);
	} 
	
	public static void main(String[] args) {
		String message = MessageManager.getMessage("test");
		System.out.println(message);
	}
}
