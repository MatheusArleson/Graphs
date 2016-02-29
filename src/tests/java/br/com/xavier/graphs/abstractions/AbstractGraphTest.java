package br.com.xavier.graphs.abstractions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import org.junit.Test;

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
	
	//GET ALL EDGES
	
	@Test
	public void getAllEdgesMustReturnEdgeSetWithSameSizeAndReferences() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();

		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		getAsAbstractGraphInstance().addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		getAsAbstractGraphInstance().addEdge(edge12);
		getAsAbstractGraphInstance().addEdge(edge23);

		Set<E> allEdges = graph.getAllEdges();
		int edgesSetSize = allEdges.size();
		
		boolean isDirected = getAsAbstractGraphInstance().isDirected();
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
	
	@Test
	public void getAllEdgesSourceTargetMustReturnEdgeSetWithSameSizeAndReferences(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		getAsAbstractGraphInstance().addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		getAsAbstractGraphInstance().addEdge(edge12);
		getAsAbstractGraphInstance().addEdge(edge23);
		
		Set<E> allEdges = getAsAbstractGraphInstance().getAllEdges(node1, node2);
		int edgesSetSize = allEdges.size();
		
		boolean isDirected = getAsAbstractGraphInstance().isDirected();
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

	//IS EDGE ALLOWED
	
	@Test
	public void isEdgeAllowedMustReturnFalseToLoopEdgeWhenLoopIsNotAllowed(){
		// graph is clean on start
		
		N node = createNode();
		
		getAsAbstractGraphInstance().addNode(node);
		
		E loopEdge = createEdge(node, node);
		
		boolean isAdded = getAsAbstractGraphInstance().isEdgeAllowed(loopEdge);
		
		boolean loopsAllowed = getAsAbstractGraphInstance().isLoopsAllowed();
		if(!loopsAllowed){
			assertFalse(isAdded);
		}
	}
	
	@Test
	public void isEdgeAllowedMustReturnTrueToLoopEdgeWhenLoopIsAllowed(){
		// graph is clean on start
		
		N node = createNode();
		
		getAsAbstractGraphInstance().addNode(node);
		
		E loopEdge = createEdge(node, node);
		
		boolean isAdded = getAsAbstractGraphInstance().isEdgeAllowed(loopEdge);
		
		boolean loopsAllowed = getAsAbstractGraphInstance().isLoopsAllowed();
		if(loopsAllowed){
			assertTrue(isAdded);
		}
	}
	
	@Test
	public void isEdgeAllowedMustReturnFalseToMultipleEdgeWhenMultipleEdgesAreNotAllowed(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		E edge12 = createEdge(node1, node2);
		
		getAsAbstractGraphInstance().addEdge(edge12);
		
		E edge12Duplicate = createEdge(node1, node2);
		
		boolean isAdded = getAsAbstractGraphInstance().isEdgeAllowed(edge12Duplicate);
		
		boolean multipleEdgesAllowed = getAsAbstractGraphInstance().isMultipleEdgesAllowed();
		if(!multipleEdgesAllowed){
			assertFalse(isAdded);
		}
	}
	
	@Test
	public void isEdgeAllowedMustReturnTrueToMultipleEdgeWhenMultipleEdgesAreAllowed(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		E edge12 = createEdge(node1, node2);
		
		getAsAbstractGraphInstance().addEdge(edge12);
		
		E edge12Duplicate = createEdge(node1, node2);
		
		boolean isAdded = getAsAbstractGraphInstance().isEdgeAllowed(edge12Duplicate);
		
		boolean multipleEdgesAllowed = getAsAbstractGraphInstance().isMultipleEdgesAllowed();
		if(multipleEdgesAllowed){
			assertTrue(isAdded);
		}
	}

	@Test(expected=IllegalEdgeException.class)
	public void isEdgeAllowedMustThrowIllegalEdgeExceptionToUnweightedEdgeWhenGraphIsWeighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(isWeighted){
			E edge = (E) new DefaultUnweightedEdge<N>(node1, node2);
			getAsAbstractGraphInstance().isEdgeAllowed(edge);
		} else {
			throw new IllegalEdgeException();
		}
	}
	
	@Test(expected=IllegalEdgeException.class)
	public void isEdgeAllowedMustThrowIllegalEdgeExceptionToWeightedEdgeWhenGraphIsUnweighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(!isWeighted){
			E edge = (E) new DefaultWeightedEdge<N>(node1, node2, BigDecimal.ZERO);
			getAsAbstractGraphInstance().isEdgeAllowed(edge);
		} else {
			throw new IllegalEdgeException();
		}
	}
	
	@Test
	public void isEdgeAllowedMustNotThrowIllegalEdgeExceptionToWeightedEdgeWhenGraphIsWeighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(isWeighted){
			E edge = (E) new DefaultWeightedEdge<N>(node1, node2, BigDecimal.ZERO);
			getAsAbstractGraphInstance().isEdgeAllowed(edge);
		}
	}
	
	@Test
	public void isEdgeAllowedMustNotThrowIllegalEdgeExceptionToUnweightedEdgeWhenGraphIsUnweighted(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		getAsAbstractGraphInstance().addNode(node1);
		getAsAbstractGraphInstance().addNode(node2);
		
		boolean isWeighted = getAsAbstractGraphInstance().isWeighted();
		if(!isWeighted){
			E edge = (E) new DefaultUnweightedEdge<N>(node1, node2);
			getAsAbstractGraphInstance().isEdgeAllowed(edge);
		}
	}

}
