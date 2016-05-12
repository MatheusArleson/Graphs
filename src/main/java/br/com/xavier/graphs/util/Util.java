package br.com.xavier.graphs.util;

import br.com.xavier.graphs.exception.IllegalEdgeException;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.nodes.Node;
import br.com.xavier.graphs.util.messages.MessageManager;
import br.com.xavier.graphs.util.messages.enums.DefaultMessagesKey;

public class Util {
	
	//XXX CONSTRUCTOR
	
	//defeat instantiation
	private Util(){}

	//XXX METHODS
	public static void checkNullParameter(Object...objects){
		for (Object object : objects) {
			if(object == null){
				handleNullParameter();
			}
		}
	}

	private static void handleNullParameter() {
		throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
	}
	
	public static void handleIllegalParameter(Object illegalParameter) {
		String message = MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_ILLEGAL).concat(illegalParameter.toString());
		throw new IllegalArgumentException(message);
	}
	
	@SafeVarargs
	public static void  checkIllegalNode(Graph graph, Node... nodes){
		if(graph == null){
			handleNullParameter();
		}
		
		if(nodes == null){
			handleNullParameter();
		}
		
		for (Node node : nodes) {
			if(node == null){
				handleNullParameter();
			}
			
			if(!graph.containsNode(node)){
				handleIllegalNode();
			}
		}
	}
	
	private static void handleIllegalNode(){
		throw new IllegalNodeException(MessageManager.getDefaultMessage(DefaultMessagesKey.ILLEGAL_NODE));
	}

	public static void handleIllegalEdge(){
		throw new IllegalEdgeException(MessageManager.getDefaultMessage(DefaultMessagesKey.ILLEGAL_EDGE));
	}
}
