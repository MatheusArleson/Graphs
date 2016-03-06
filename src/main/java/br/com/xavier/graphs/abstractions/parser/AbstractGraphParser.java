package br.com.xavier.graphs.abstractions.parser;

import java.util.Set;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.parser.GraphsParser;
import br.com.xavier.graphs.util.messages.MessageManager;
import br.com.xavier.graphs.util.messages.enums.DefaultMessagesKey;
import br.com.xavier.matrix.validation.NullValidator;

public abstract class AbstractGraphParser<N extends AbstractNode, E extends Edge<N>> implements GraphsParser<N, E> {
	
	//XXX CONSTRUCTOR
	public AbstractGraphParser() {}
	
	//XXX INTERFACE METHODS
	@Override
	public String parse(AbstractGraph<N, E> graph, String graphWidgetVar) {
		NullValidator.checkNullParameter(graph, graphWidgetVar);
		
		if(graphWidgetVar.isEmpty()){
			throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
		}
		
		StringBuffer sb = new StringBuffer();
		
		String newGraph = createNewGraph(graphWidgetVar);
		sb.append(newGraph);
		
		String preConditions = preConditions(graph, graphWidgetVar);
		sb.append(preConditions);
		
		String parsed = doParse(graph, graphWidgetVar);
		sb.append(parsed);
		
		return sb.toString();
	}
	
	private String preConditions(AbstractGraph<N, E> graph, String graphWidgetVar) {
		StringBuffer sb = new StringBuffer();
		
		boolean isDirected = graph.isDirected();
		boolean isWeighted = graph.isWeighted();
		boolean isLoopsAllowed = graph.isLoopsAllowed();
		boolean isMultipleEdgesAllowed = graph.isMultipleEdgesAllowed();
		
		if(isDirected){
			String onDirectedPreCondition = onDirectedGraph(graph, graphWidgetVar);
			sb.append(onDirectedPreCondition);
		}
		
		if(isWeighted){
			String onWeightedPreCondition = onWeightedGraph(graph, graphWidgetVar);
			sb.append(onWeightedPreCondition);
		}
		
		if(isLoopsAllowed){
			String onLoopsAllowedPreCondition = onLoopsAllowedGraph(graph, graphWidgetVar);
			sb.append(onLoopsAllowedPreCondition);
		}
		
		if(isMultipleEdgesAllowed){
			String onMultipleEdgesAllowedPreCondition = onMultipleEdgesAllowedGraph(graph, graphWidgetVar);
			sb.append(onMultipleEdgesAllowedPreCondition);
		}
		
		return sb.toString();
	}

	private String doParse(AbstractGraph<N, E> graph, String graphWidgetVar) {
		StringBuffer sb = new StringBuffer();
		
		//Discover all nodes 
		Set<N> graphNodesSet = graph.getAllNodes();
		if(graphNodesSet.isEmpty()){
			return "";
		}
		
		//Add all nodes part
		String addAllNodesPart = generateAddAllNodesPart(graphNodesSet, graphWidgetVar);
		sb.append(addAllNodesPart);
		
		//Discover all edges
		Set<E> graphEdgesSet = graph.getAllEdges();
		if(graphEdgesSet.isEmpty()){
			return sb.toString();
		}
		
		//Add all edges part
		String addAllEdgesPart = generateAddAllEdgesPart(graphEdgesSet, graphWidgetVar, graph.isDirected(), graph.isWeighted());
		sb.append(addAllEdgesPart);
		
		return sb.toString();
	}
	
	private String generateAddAllNodesPart(Set<N> graphNodesSet, String graphWidgetVar){
		StringBuffer sb = new StringBuffer();
		
		for (N node : graphNodesSet) {
			String addNodeStr = generateAddNodeStr(node, graphWidgetVar);
			sb.append(addNodeStr);
		}
		
		return sb.toString();
	}
	
	private String generateAddAllEdgesPart(Set<E> graphEdgesSet, String graphWidgetVar, boolean isGraphDirected, boolean isGraphWeighted){
		StringBuffer sb = new StringBuffer();
		
		for (E edge : graphEdgesSet) {
			String addEdgeStr = generateAddEdgeStr(edge, graphWidgetVar, isGraphDirected, isGraphWeighted);
			sb.append(addEdgeStr);
		}
		
		return sb.toString();
	}
	
	//XXX ABSTRACT METHODS
	protected abstract String createNewGraph(String graphWidgetVar);
	protected abstract String onDirectedGraph(AbstractGraph<N, E> graph, String graphWidgetVar);
	protected abstract String onWeightedGraph(AbstractGraph<N, E> graph, String graphWidgetVar);
	protected abstract String onLoopsAllowedGraph(AbstractGraph<N, E> graph, String graphWidgetVar);
	protected abstract String onMultipleEdgesAllowedGraph(AbstractGraph<N, E> graph, String graphWidgetVar);

	protected abstract String generateAddNodeStr(N node, String graphWidgetVar);
	protected abstract String generateAddEdgeStr(E edge, String graphWidgetVar, boolean isGraphDirected, boolean isGraphWeighted);
}
