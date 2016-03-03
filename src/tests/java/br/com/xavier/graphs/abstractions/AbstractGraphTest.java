package br.com.xavier.graphs.abstractions;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalEdgeException;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.interfaces.GraphTest;

public abstract class AbstractGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends GraphTest<N,E> {
	
	//XXX UTIL METHODS
	
	private AbstractGraph<N, E> getAsAbstractGraphInstance() {
		return (AbstractGraph<N,E>) graph;
	}
	
	//XXX TEST METHODS
	
	//IS EDGE ALLOWED
	
	@Override
	public void isEdgeAllowedMustThrowIllegalEdgeExceptionToUnweightedEdgeWhenGraphIsWeighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = graph.isWeighted();
		if(isWeighted){
			E edge = (E) new DefaultUnweightedEdge<N>(node1, node2);
			graph.isEdgeAllowed(edge);
		} else {
			throw new IllegalEdgeException();
		}
	}
	
	@Override
	public void isEdgeAllowedMustThrowIllegalEdgeExceptionToWeightedEdgeWhenGraphIsUnweighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = graph.isWeighted();
		if(!isWeighted){
			E edge = (E) new DefaultWeightedEdge<N>(node1, node2, BigDecimal.ZERO);
			graph.isEdgeAllowed(edge);
		} else {
			throw new IllegalEdgeException();
		}
	}
	
	@Override
	public void isEdgeAllowedMustNotThrowIllegalEdgeExceptionToWeightedEdgeWhenGraphIsWeighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = graph.isWeighted();
		if(isWeighted){
			E edge = (E) new DefaultWeightedEdge<N>(node1, node2, BigDecimal.ZERO);
			graph.isEdgeAllowed(edge);
		}
	}
	
	@Override
	public void isEdgeAllowedMustNotThrowIllegalEdgeExceptionToUnweightedEdgeWhenGraphIsUnweighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = graph.isWeighted();
		if(!isWeighted){
			E edge = (E) new DefaultUnweightedEdge<N>(node1, node2);
			graph.isEdgeAllowed(edge);
		}
	}

	//ADD EDGE
	
	@Override
	public void addEdgeMustThrowExceptionOnAddWeightedEdgeOnUnweightedGraph(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		E edge12 = (E) new DefaultWeightedEdge<N>(node1, node2, BigDecimal.ZERO);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(!isWeighted){
			getAsAbstractGraphInstance().addEdge(edge12);
		}
	}
	
	@Override
	public void addEdgeMustNotThrowExceptionOnAddWeightedEdgeOnWeightedGraph(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		E edge12 = (E) new DefaultWeightedEdge<N>(node1, node2, BigDecimal.ZERO);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(isWeighted){
			boolean isAdded = getAsAbstractGraphInstance().addEdge(edge12);
			assertTrue(isAdded);
		}
	}
	
	@Override
	public void addEdgeMustThrowExceptionOnAddUnweightedEdgeOnWeightedGraph(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		E edge12 = (E) new DefaultUnweightedEdge<N>(node1, node2);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(isWeighted){
			getAsAbstractGraphInstance().addEdge(edge12);
		} else {
			throw new IllegalEdgeException();
		}
	}
	
	@Override
	public void addEdgeMustNotThrowExceptionOnAddUnweightedEdgeOnUnweightedGraph(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		E edge12 = (E) new DefaultUnweightedEdge<N>(node1, node2);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(!isWeighted){
			boolean isAdded = getAsAbstractGraphInstance().addEdge(edge12);
			assertTrue(isAdded);
		}
	}
}
