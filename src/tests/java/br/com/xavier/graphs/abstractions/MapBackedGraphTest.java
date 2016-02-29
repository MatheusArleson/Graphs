package br.com.xavier.graphs.abstractions;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class MapBackedGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends AbstractGraphTest<N, E>{

	//XXX UTIL  METHODS
	
	private MapBackedGraph<N, E> getAsMapBackedGraphInstance() {
		return (MapBackedGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
	//XXX FIXME BROKEN TEST
	
	//GET ALL EDGES
	
	@Test
	public void getAllEdgesMustReturnEdgeSetWithSameSizeAndReferences() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();

		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graph.addEdge(edge12);
		graph.addEdge(edge23);

		Set<E> allEdges = graph.getAllEdges();
		int edgesSetSize = allEdges.size();
		
		boolean isDirected = getAsMapBackedGraphInstance().isDirected();
		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		
		boolean result = false;
		
		if(isDirected){
			boolean isSizeTwo = (edgesSetSize == 2);
			result = isSizeTwo && containsEdge12 && containsEdge23;
			
			assertTrue(result);
			
		} else {
			boolean isSizeFour = (edgesSetSize == 4);
			boolean containsEdge12Reversed = allEdges.contains(edge12.reverse());
			boolean containsEdge23Reversed = allEdges.contains(edge23.reverse());
			
			result = ( 
				isSizeFour && 
				containsEdge12 && containsEdge12Reversed && 
				containsEdge23 && containsEdge23Reversed
			);
			
			assertTrue(result);
		}
	}
	
	//GET ALL EDGES SOURCE TARGET
	
	//XXX FIXME BROKEN TEST
	@Test
	public void getAllEdgesSourceTargetMustReturnEdgeSetWithSameSizeAndReferences(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graph.addEdge(edge12);
		graph.addEdge(edge23);
		
		Set<E> allEdges = graph.getAllEdges(node1, node2);
		int edgesSetSize = allEdges.size();
		
		boolean isDirected = getAsMapBackedGraphInstance().isDirected();
		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		boolean result = false;
		
		if(isDirected){
			boolean isSizeOne = (edgesSetSize == 1);
			result = isSizeOne && containsEdge12 && !containsEdge23;
			
			assertTrue(result);
			
		} else {
			
			boolean isSizeFour = (edgesSetSize == 2);
			boolean containsEdge12Reversed = allEdges.contains(edge12.reverse());
			
			result = (isSizeFour && containsEdge12 && containsEdge12Reversed);
			
			assertTrue(result);
		}
	}
}
