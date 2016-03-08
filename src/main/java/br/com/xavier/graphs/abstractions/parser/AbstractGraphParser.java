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
	public String parse(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		NullValidator.checkNullParameter(graph, graphWidgetVar);
		
		if(graphWidgetVar.isEmpty()){
			throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
		}
		
		StringBuffer sb = new StringBuffer();
		
		String header = generateHeader(graph, htmlElementContainer, graphWidgetVar);
		sb.append(header);
		
		String newGraph = createNewGraph(graph, htmlElementContainer, graphWidgetVar);
		sb.append(newGraph);
		
		String preConditions = preConditions(graph, htmlElementContainer, graphWidgetVar);
		sb.append(preConditions);
		
		String parsed = doParse(graph, htmlElementContainer, graphWidgetVar);
		sb.append(parsed);
		
		String footer = generateFooter(graph, htmlElementContainer, graphWidgetVar);
		sb.append(footer);
		
		return sb.toString();
	}

	private String preConditions(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		StringBuffer sb = new StringBuffer();
		
		boolean isDirected = graph.isDirected();
		boolean isWeighted = graph.isWeighted();
		boolean isLoopsAllowed = graph.isLoopsAllowed();
		boolean isMultipleEdgesAllowed = graph.isMultipleEdgesAllowed();
		
		if(isDirected){
			String onDirectedPreCondition = onDirectedGraph(graph, htmlElementContainer, graphWidgetVar);
			sb.append(onDirectedPreCondition);
		}
		
		if(isWeighted){
			String onWeightedPreCondition = onWeightedGraph(graph, htmlElementContainer, graphWidgetVar);
			sb.append(onWeightedPreCondition);
		}
		
		if(isLoopsAllowed){
			String onLoopsAllowedPreCondition = onLoopsAllowedGraph(graph, htmlElementContainer, graphWidgetVar);
			sb.append(onLoopsAllowedPreCondition);
		}
		
		if(isMultipleEdgesAllowed){
			String onMultipleEdgesAllowedPreCondition = onMultipleEdgesAllowedGraph(graph, htmlElementContainer, graphWidgetVar);
			sb.append(onMultipleEdgesAllowedPreCondition);
		}
		
		return sb.toString();
	}

	private String doParse(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar) {
		StringBuffer sb = new StringBuffer();
		
		//Discover all nodes 
		Set<N> graphNodesSet = graph.getAllNodes();
		if(graphNodesSet.isEmpty()){
			return "";
		}
		
		//Add all nodes part
		String addAllNodesPart = generateAddAllNodesPart(graphNodesSet, htmlElementContainer, graphWidgetVar);
		sb.append(addAllNodesPart);
		
		//Discover all edges
		Set<E> graphEdgesSet = graph.getDistinctEdges();
		if(graphEdgesSet.isEmpty()){
			return sb.toString();
		}
		
		//Add all edges part
		String addAllEdgesPart = generateAddAllEdgesPart(graphEdgesSet, htmlElementContainer, graphWidgetVar, graph.isDirected(), graph.isWeighted());
		sb.append(addAllEdgesPart);
		
		return sb.toString();
	}
	
	private String generateAddAllNodesPart(Set<N> graphNodesSet, String htmlElementContainer, String graphWidgetVar){
		StringBuffer sb = new StringBuffer();
		
		for (N node : graphNodesSet) {
			String addNodeStr = generateAddNodeStr(node, htmlElementContainer, graphWidgetVar);
			sb.append(addNodeStr);
		}
		
		return sb.toString();
	}
	
	private String generateAddAllEdgesPart(Set<E> graphEdgesSet, String htmlElementContainer, String graphWidgetVar, boolean isGraphDirected, boolean isGraphWeighted){
		StringBuffer sb = new StringBuffer();
		
		for (E edge : graphEdgesSet) {
			String addEdgeStr = generateAddEdgeStr(edge, htmlElementContainer, graphWidgetVar, isGraphDirected, isGraphWeighted);
			sb.append(addEdgeStr);
		}
		
		return sb.toString();
	}
	
	//XXX ABSTRACT METHODS
	protected abstract String createNewGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);
	protected abstract String onDirectedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);
	protected abstract String onWeightedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);
	protected abstract String onLoopsAllowedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);
	protected abstract String onMultipleEdgesAllowedGraph(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);

	protected abstract String generateAddNodeStr(N node, String htmlElementContainer, String graphWidgetVar);
	protected abstract String generateAddEdgeStr(E edge, String htmlElementContainer, String graphWidgetVar, boolean isGraphDirected, boolean isGraphWeighted);
	
	protected abstract String generateHeader(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);
	protected abstract String generateFooter(AbstractGraph<N, E> graph, String htmlElementContainer, String graphWidgetVar);
	
}
