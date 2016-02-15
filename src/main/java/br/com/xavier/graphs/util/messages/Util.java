package br.com.xavier.graphs.util.messages;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.util.messages.enums.DefaultMessagesKey;

public class Util {
	
	//XXX CONSTRUCTOR
	
	//defeat instantiation
	private Util(){}

	//XXX METHODS
	public static void handleNullParameter(Object... objects){
		for (Object object : objects) {
			if(object == null){
				throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
			}
		}
	}
	
	public static void handleIllegalNode(){
		throw new IllegalNodeException(MessageManager.getDefaultMessage(DefaultMessagesKey.ILLEGAL_NODE));
	}
}
