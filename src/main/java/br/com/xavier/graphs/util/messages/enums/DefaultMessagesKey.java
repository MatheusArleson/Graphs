package br.com.xavier.graphs.util.messages.enums;

/**
 * Enum holding the keys for the default messages that must be in 
 * the messages file.
 * 
 * @author Matheus Xavier
 *
 */
public enum DefaultMessagesKey {
	
	//XXX ENUM MEMBERS
	MESSAGE_KEY_NOT_FOUND("message.notfound"),
	PARAMETER_NULL("parameter.null"),
	ILLEGAL_NODE("node.illegal"),
	ILLEGAL_EDGE("edge.illegal.type");
	
	//XXX ENUM PROPERTIES
	private final String key;
	
	//XXX CONSTRUCTOR
	private DefaultMessagesKey(String key) {
		this.key = key;
	}
	
	//XXX GETTERS
	public String getKey() {
		return key;
	}

}
