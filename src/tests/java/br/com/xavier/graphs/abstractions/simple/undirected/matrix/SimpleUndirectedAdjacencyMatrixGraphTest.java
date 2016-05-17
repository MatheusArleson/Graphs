package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleAdjacencyMatrixGraphTest;
import br.com.xavier.graphs.exception.IllegalNodeException;

public abstract class SimpleUndirectedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleUndirectedAdjacencyMatrixGraph<N, E> getAsSimpleUndirectedAdjacencyMatrixGraphInstance() {
		return (SimpleUndirectedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
	
	@Test(expected = NullPointerException.class)
	public void degreeOfMustThrowExceptionOnNullNode(){
		getAsSimpleUndirectedAdjacencyMatrixGraphInstance().degreeOf(null);
	}
	
	@Test(expected = IllegalNodeException.class)
	public void degreeOfMustThrowIllegalNodeExceptionOnNodeNotPresent(){
		N node = createNode();
		
		getAsSimpleUndirectedAdjacencyMatrixGraphInstance().degreeOf(node);
	}
	
	@Test
	public void degreeTest(){
		SimpleUndirectedAdjacencyMatrixGraph<N, E> graphInstance = getAsSimpleUndirectedAdjacencyMatrixGraphInstance();
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		N node4 = createNode();
		N node5 = createNode();
		N node6 = createNode();
		
		graphInstance.addNode(node1);
		graphInstance.addNode(node2);
		graphInstance.addNode(node3);
		graphInstance.addNode(node4);
		graphInstance.addNode(node5);
		graphInstance.addNode(node6);
		
		E edge12 = createEdge(node1, node2);
		E edge13 = createEdge(node1, node3);
		E edge23 = createEdge(node2, node3);
		E edge24 = createEdge(node2, node4);
		E edge25 = createEdge(node2, node5);
		E edge35 = createEdge(node3, node5);
		E edge36 = createEdge(node3, node6);
		E edge45 = createEdge(node4, node5);
		E edge56 = createEdge(node5, node6);
		
		graphInstance.addEdge(edge12);
		graphInstance.addEdge(edge13);
		graphInstance.addEdge(edge23);
		graphInstance.addEdge(edge24);
		graphInstance.addEdge(edge25);
		graphInstance.addEdge(edge35);
		graphInstance.addEdge(edge36);
		graphInstance.addEdge(edge45);
		graphInstance.addEdge(edge56);
		
		int node1Degree = graphInstance.degreeOf(node1);
		int node2Degree = graphInstance.degreeOf(node2);
		int node3Degree = graphInstance.degreeOf(node3);
		int node4Degree = graphInstance.degreeOf(node4);
		int node5Degree = graphInstance.degreeOf(node5);
		int node6Degree = graphInstance.degreeOf(node6);
		
		assertEquals(node1Degree, 2);
		assertEquals(node2Degree, 4);
		assertEquals(node3Degree, 4);
		assertEquals(node4Degree, 2);
		assertEquals(node5Degree, 4);
		assertEquals(node6Degree, 2);
	}
}
