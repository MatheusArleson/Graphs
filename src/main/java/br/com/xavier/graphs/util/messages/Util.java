package br.com.xavier.graphs.util.messages;

import br.com.xavier.graphs.exception.IllegalEdgeException;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;
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
	
//	@SafeVarargs
//	public static <N extends Node, E extends Edge<N>> void  checkIllegalNode(Graph<N,E> graph, N... nodes){
//		if(graph == null){
//			handleNullParameter();
//		}
//		
//		if(nodes == null){
//			handleNullParameter();
//		}
//		
//		for (N node : nodes) {
//			if(node == null){
//				handleNullParameter();
//			}
//			
//			if(!graph.containsNode(node)){
//				handleIllegalNode();
//			}
//		}
//	}
	
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
