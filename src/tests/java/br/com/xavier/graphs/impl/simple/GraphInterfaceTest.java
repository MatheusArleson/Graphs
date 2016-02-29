package br.com.xavier.graphs.impl.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;

public abstract class GraphInterfaceTest<N extends Node, E extends Edge<N>> {

	protected Graph<N, E> graphToTest;

	protected abstract Graph<N, E> createGraphInstance();
	protected abstract N createNode();
	protected abstract E createEdge(N node1, N node2);

	@Before
	public void setup() {
		graphToTest = createGraphInstance();
	}

	@After
	public void destroy() {
		graphToTest = createGraphInstance();
	}

	// XXX UTIL METHODS
	private Set<N> createNodesSet(int size) {
		Set<N> nodesSet = new LinkedHashSet<N>();
		for (int i = 0; i < size; i++) {
			nodesSet.add(createNode());
		}
		return nodesSet;
	}

	private void buildAreAdjacentsCenario(N node1, N node2, N node3) {
		// graph with 3 nodes.
		// relationships: 1 -> 2; 2-> 3; (NOT 1 -> 3)
		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge23);
	}

	// XXX TEST METHODS

	// ------------------------------------------
	// NODES METODS
	// ------------------------------------------

	// GET ALL NODES

	@Test
	public void getAllNodesMustReturnEmptyNodeSetOnEmptyGraph() {
		// graph is clean on start

		Set<N> allNodes = graphToTest.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllNodesMustReturnNotEmptyNodeSetOnNotEmptyGraph() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);

		Set<N> allNodes = graphToTest.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertFalse(isEmpty);
	}

	@Test
	public void getAllNodesMustReturnNodeSetWithSameSizeAndReferences() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);

		Set<N> allNodes = graphToTest.getAllNodes();
		boolean containsAddedNode = allNodes.contains(node);
		boolean isSizeOne = allNodes.size() == 1;
		boolean result = containsAddedNode && isSizeOne;

		assertTrue(result);
	}

	// CONTAINS NODE

	@Test(expected = NullPointerException.class)
	public void containsNodeMustThrowExceptionOnNullNode() {
		// graph is clean on start

		N node = null;
		graphToTest.containsNode(node);
	}

	@Test
	public void containsNodeMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		N node = createNode();
		boolean isPresent = graphToTest.containsNode(node);

		assertFalse(isPresent);
	}

	@Test
	public void containsNodeMustReturnTrueOnPresentNode() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);
		boolean isPresent = graphToTest.containsNode(node);

		assertTrue(isPresent);
	}

	@Test
	public void containsNodeMustReturnFalseOnNotPresentNode() {
		// graph is clean on start

		N node1 = createNode();
		graphToTest.addNode(node1);

		N node2 = createNode();
		boolean isPresent = graphToTest.containsNode(node2);

		assertFalse(isPresent);
	}

	// ADD NODE

	@Test(expected = NullPointerException.class)
	public void addNodeMustThrowExceptionOnNullNode() {
		// graph is clean on start

		N node = null;
		graphToTest.addNode(node);
	}

	@Test
	public void addNodeMustReturnTrueOnDistinctNode() {
		// graph is clean on start

		N node = createNode();
		boolean nodeAdded = graphToTest.addNode(node);

		assertTrue(nodeAdded);
	}

	@Test
	public void addNodeMustReturnFalseOnRepeatedNode() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);
		boolean repeatedNodeAdded = graphToTest.addNode(node);

		assertFalse(repeatedNodeAdded);
	}

	// REMOVE ALL NODES

	@Test
	public void removeAllNodesMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		boolean isChanged = graphToTest.removeAllNodes();

		assertFalse(isChanged);
	}

	@Test
	public void removeAllNodesMustReturnTrueOnNotEmptyGraph() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);

		boolean isChanged = graphToTest.removeAllNodes();

		assertTrue(isChanged);
	}

	@Test
	public void removeAllNodesMustClearGraphNodes() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);

		graphToTest.removeAllNodes();

		Set<N> allNodes = graphToTest.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void removeAllNodesMustClearGraphEdges() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		
		E edge = createEdge(node1, node2);
		
		graphToTest.addEdge(edge);

		graphToTest.removeAllNodes();

		Set<E> allEdges = graphToTest.getAllEdges();
		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	// REMOVE ALL NODES (Set)

	@Test(expected = NullPointerException.class)
	public void removeAllNodesCollectionsMustThrowNullPointerExceptionOnNullSet() {
		// graph is clean on start

		Set<N> nodesSet = null;
		graphToTest.removeAllNodes(nodesSet);
	}

	@Test
	public void removeAllNodesCollectionMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(1);

		boolean isChanged = graphToTest.removeAllNodes(nodesSet);

		assertFalse(isChanged);
	}

	@Test
	public void removeAllNodesCollectionMustReturnTrueOnNotEmptyGraph() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(1);
		graphToTest.addNode(nodesSet.iterator().next());

		boolean isChanged = graphToTest.removeAllNodes(nodesSet);

		assertTrue(isChanged);
	}

	@Test
	public void removeAllNodesCollectionMustClearGraphNodes() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(1);
		Iterator<N> iterator = nodesSet.iterator();
		graphToTest.addNode(iterator.next());

		graphToTest.removeAllNodes();

		Set<N> allNodes = graphToTest.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void removeAllNodesCollectionMustClearGraphEdges() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(2);
		Iterator<N> iterator = nodesSet.iterator();
		N node1 = iterator.next();
		N node2 = iterator.next();

		E edge = createEdge(node1, node2);

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addEdge(edge);

		graphToTest.removeAllNodes(nodesSet);

		Set<E> allEdges = graphToTest.getAllEdges();
		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	public void removeAllNodesCollectionMustRemoveNodesNotPresentInTheGraph() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(3);
		Iterator<N> iterator = nodesSet.iterator();
		N node1 = iterator.next();
		N node2 = iterator.next();
		N node3 = iterator.next();

		iterator = null;

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);

		graphToTest.removeAllNodes(nodesSet);

		boolean isInvalidNodeOnSet = nodesSet.contains(node3);

		assertFalse(isInvalidNodeOnSet);
	}

	// REMOVE ALL NODES (Node)

	@Test(expected = NullPointerException.class)
	public void removeNodeMustThrowNullPointerExceptionOnNullNode() {
		// graph is clean on start

		N node = null;
		graphToTest.removeNode(node);
	}

	@Test
	public void removeNodeMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		N node = createNode();

		boolean isChanged = graphToTest.removeNode(node);

		assertFalse(isChanged);
	}

	@Test
	public void removeNodeMustReturnFalseOnNotPresentNode() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		graphToTest.addNode(node1);

		boolean isChanged = graphToTest.removeNode(node2);

		assertFalse(isChanged);
	}

	@Test
	public void removeNodeMustReturnTrueOnPresentNode() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);

		boolean isChanged = graphToTest.removeNode(node);

		assertTrue(isChanged);
	}

	@Test
	public void removeNodeMustClearGraphEdgesRelatedToIt() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(2);
		Iterator<N> iterator = nodesSet.iterator();
		N node1 = iterator.next();
		N node2 = iterator.next();
		
		graphToTest.addNode(node1);
		graphToTest.addNode(node2);

		E startingEdge = createEdge(node1, node2);
		E endingEdge = createEdge(node2, node1);

		graphToTest.addEdge(startingEdge);

		graphToTest.removeNode(node1);

		boolean containsEdge = false;
		try {
			containsEdge = containsEdge |= graphToTest.containsEdge(startingEdge);
			containsEdge = containsEdge |= graphToTest.containsEdge(endingEdge);
		} catch (IllegalNodeException e) {
		}

		assertFalse(containsEdge);
	}

	// ARE ADJACENTS

	@Test(expected=NullPointerException.class)
	public void areAdjacentsMustThrowNullPointerExceptionOnBothNullNode() {
		// graph is clean on start

		N nullNode = null;

		graphToTest.areAdjacents(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void areAdjacentsMustThrowNullPointerExceptionOnLeftNullNode() {
		// graph is clean on start

		N nullNode = null;
		N node = createNode();
		
		graphToTest.addNode(node);

		graphToTest.areAdjacents(nullNode, node);
	}
	
	@Test(expected=NullPointerException.class)
	public void areAdjacentsMustThrowNullPointerExceptionOnRightNullNode() {
		// graph is clean on start

		N nullNode = null;
		N node = createNode();
		
		graphToTest.addNode(node);

		graphToTest.areAdjacents(node, nullNode);
	}

	@Test
	public void areAdjacentsMustThrowIllegalNodeExceptionOnAnyNotPresentNode() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graphToTest.addNode(node1);

		boolean allException = false;
		try {
			graphToTest.areAdjacents(node1, node2);
		} catch (IllegalNodeException e1) {
			try {
				graphToTest.areAdjacents(node2, node1);
			} catch (IllegalNodeException e2) {
				allException = true;
			}
		}

		assertTrue(allException);
	}

	@Test
	public void areAdjacentsMustReturnFalseOnNotRelatedNodes() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		buildAreAdjacentsCenario(node1, node2, node3);

		boolean areAdjacents = graphToTest.areAdjacents(node1, node3);

		assertFalse(areAdjacents);
	}

	@Test
	public void areAdjacentsMustReturnTrueOnRelatedNodes() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		buildAreAdjacentsCenario(node1, node2, node3);

		boolean areAdjacents = graphToTest.areAdjacents(node1, node2);

		assertTrue(areAdjacents);
	}

	// DEGREE OF

	@Test(expected = NullPointerException.class)
	public void degreeOfMustThrowNullPointerExceptionOnNullNode() {
		// graph is clean on start

		N node = null;

		graphToTest.degreeOf(node);
	}

	@Test(expected = IllegalNodeException.class)
	public void degreeOfMustThrowIllegalNodeExceptionOnNotPresentNode() {
		// graph is clean on start

		N node = createNode();

		graphToTest.degreeOf(node);
	}

	@Test
	public void degreeOfMustReturnZeroOnIsolatedNode() {
		// graph is clean on start

		N node = createNode();
		graphToTest.addNode(node);

		int nodeDegree = graphToTest.degreeOf(node);

		assertEquals(0, nodeDegree);
	}

	@Test
	public void degreeOfTest() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge13 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge13);
		graphToTest.addEdge(edge23);

		int node1Degree = graphToTest.degreeOf(node1);
		int node2Degree = graphToTest.degreeOf(node2);
		int node3Degree = graphToTest.degreeOf(node3);

		assertEquals(2, node1Degree);
		assertEquals(1, node2Degree);
		assertEquals(0, node3Degree);
	}

	// ------------------------------------------
	// EDGES METODS
	// ------------------------------------------

	// GET ALL EDGES

	@Test
	public void getAllEdgesMustReturnEmptyEdgeSetOnEmptyGraph() {
		// graph is clean on start

		Set<E> allEdges = graphToTest.getAllEdges();

		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllEdgesMustReturnEmptyEdgeSetOnGraphWithNoEdges() {
		// graph is clean on start

		N node1 = createNode();
		graphToTest.addNode(node1);

		Set<E> allEdges = graphToTest.getAllEdges();

		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllEdgesMustReturnNotEmptyEdgeSetOnGraphWithEdges() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);

		E edge = createEdge(node1, node2);

		graphToTest.addEdge(edge);

		Set<E> allEdges = graphToTest.getAllEdges();

		boolean isEmpty = allEdges.isEmpty();

		assertFalse(isEmpty);
	}

	@Test
	public void getAllEdgesMustReturnEdgeSetWithSameSizeAndReferences() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge23);

		Set<E> allEdges = graphToTest.getAllEdges();

		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		boolean isSizeTwo = allEdges.size() == 2;
		boolean result = containsEdge12 && containsEdge23 && isSizeTwo;

		assertTrue(result);
	}

	// GET ALL EDGES NODE

	@Test(expected = NullPointerException.class)
	public void getAllEdgesNodeMustThrowNullPointerExceptionOnNullNode() {
		// graph is clean on start

		N node = null;

		graphToTest.getAllEdges(node);
	}

	@Test(expected = IllegalNodeException.class)
	public void getAllEdgesNodeMustThrowNIllegalNodeExceptionOnNotPresentNode() {
		// graph is clean on start

		N node = createNode();

		graphToTest.getAllEdges(node);
	}

	@Test
	public void getAllEdgesNodeMustReturnEmptyEdgeSetOnNotRelatedNode() {
		// graph is clean on start

		N node = createNode();

		graphToTest.addNode(node);

		Set<E> allEdges = graphToTest.getAllEdges(node);

		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllEdgesNodeMustReturnNotEmptyEdgeSetOnRelatedNode() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);

		E edge12 = createEdge(node1, node2);

		graphToTest.addEdge(edge12);

		Set<E> allEdges = graphToTest.getAllEdges(node1);

		boolean isEmpty = allEdges.isEmpty();

		assertFalse(isEmpty);
	}

	@Test
	public void getAllEdgesNodeMustReturnEdgeSetWithSameSizeAndReferences() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();

		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge23);

		Set<E> allEdges = graphToTest.getAllEdges(node1);

		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		boolean isSizeOne = allEdges.size() == 1;
		boolean result = containsEdge12 && isSizeOne && !containsEdge23;

		assertTrue(result);
	}

	// GET ALL EDGES SOURCE TARGET
	
	@Test(expected=NullPointerException.class)
	public void getAllEdgesSourceTargetMustThrowNullPointerExceptionOnBothNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		
		graphToTest.getAllEdges(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void getAllEdgesSourceTargetMustThrowNullPointerExceptionOnLeftNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graphToTest.addNode(realNode);
		
		graphToTest.getAllEdges(nullNode, realNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void getAllEdgesSourceTargetMustThrowNullPointerExceptionOnRightNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graphToTest.addNode(realNode);
		
		graphToTest.getAllEdges(realNode, nullNode);
	}
	
	@Test(expected=IllegalNodeException.class)
	public void getAllEdgesSourceTargetMustIllegalNodeExceptionOnNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		
		graphToTest.getAllEdges(node1, node3);
	}
	
	@Test
	public void getAllEdgesSourceTargetMustReturnEmptySetOnNotRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		Set<E> allEdges = graphToTest.getAllEdges(node1, node3);
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void getAllEdgesMustReturnNotEmptyEdgeSetOnRelatedNodes(){
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		Set<E> allEdges = graphToTest.getAllEdges(node1, node2);
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertFalse(isEmpty);
	}
	
	@Test
	public void getAllEdgesSourceTargetMustReturnEdgeSetWithSameSizeAndReferences(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge23);
		
		Set<E> allEdges = graphToTest.getAllEdges(node1, node2);
		
		
		
		//FIXME BUG WITH UN/DIRECTED GRAPHS
		//WORKING WITH THE INTERFACE... CANT KNOW IF IS DIRECTED OR NOT
		//SO THE RESULT HERE IS OR NOT CORRECT DEPENDING ON THE GRAPH
		boolean isSizeOne = allEdges.size() == 1;
		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		boolean result = isSizeOne && containsEdge12 && !containsEdge23;
		
		assertTrue(result);
	}

	// CONTAINS EDGE
	
	@Test(expected=NullPointerException.class)
	public void containsEdgeMustThrowNullPointerExceptionOnNullEdge(){
		// graph is clean on start
		
		E nullEdge = null;
		
		graphToTest.containsEdge(nullEdge);
	}
	
	@Test(expected=NullPointerException.class)
	public void containsEdgeMustThrowNullPointerExceptionOnNullEdgeSource(){
		// graph is clean on start
		
		N targetNode = createNode();
		
		graphToTest.addNode(targetNode);
		
		E nullSourceEdge = createEdge(null, targetNode);
		
		graphToTest.containsEdge(nullSourceEdge);
	}
	
	@Test(expected=NullPointerException.class)
	public void containsEdgeMustThrowNullPointerExceptionOnNullEdgeTarget(){
		// graph is clean on start
		
		N sourceNode = createNode();
		
		graphToTest.addNode(sourceNode);
		
		E nullTargetEdge = createEdge(sourceNode, null);
		
		graphToTest.containsEdge(nullTargetEdge);
	}
	
	@Test
	public void containsEdgeMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();

		graphToTest.addNode(node1);
		
		E edge12 = createEdge(node1, node2);
		E edge21 = createEdge(node2, node1);

		boolean allException = false;
		try {
			graphToTest.containsEdge(edge12);
		} catch (IllegalNodeException e1) {
			try {
				graphToTest.containsEdge(edge21);
			} catch (IllegalNodeException e2) {
				allException = true;
			}
		}

		assertTrue(allException);
		
	}
	
	@Test
	public void containsEdgeMustReturnFalseToNotRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);
		
		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);
		
		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge23);
		
		E edge13 = createEdge(node1, node3);
		
		boolean containsEdge = graphToTest.containsEdge(edge13);
		
		assertFalse(containsEdge);
	}
	
	@Test
	public void containsEdgeMustReturnTrueToRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graphToTest.addNode(node1);
		graphToTest.addNode(node2);
		graphToTest.addNode(node3);
		
		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);
		
		graphToTest.addEdge(edge12);
		graphToTest.addEdge(edge23);
		
		E edge13 = createEdge(node1, node2);
		
		boolean containsEdge = graphToTest.containsEdge(edge13);
		
		assertTrue(containsEdge);
	}

	// EXISTS EDGE
	
	@Test(expected=NullPointerException.class)
	public void existsEdgeMustThrowNullPointerExceptionOnBothNullNodes(){
		// graph is clean on start
		
		N nullNode = null;
		
		graphToTest.existsEdge(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void existsEdgeMustThrowNullPointerExceptionOnLeftNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graphToTest.addNode(realNode);
		
		graphToTest.existsEdge(nullNode, realNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void existsEdgeMustThrowNullPointerExceptionOnRightNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graphToTest.addNode(realNode);
		
		graphToTest.existsEdge(realNode, nullNode);;
	}
	
	@Test
	public void existsEdgeMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		graphToTest.addNode(node1);
		
		boolean allExceptions = false;
		try { graphToTest.existsEdge(node1, node2); } catch(IllegalNodeException e1){
			try { graphToTest.existsEdge(node2, node1); } catch(IllegalNodeException e2){
				allExceptions = true;
			}
		}
		
		assertTrue(allExceptions);
	}
	
	@Test
	public void existsEdgeMustReturnFalseToNotRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		boolean existsEdge = graphToTest.existsEdge(node1, node3);
		
		assertFalse(existsEdge);
	}
	
	@Test
	public void existsEdgeMustReturnTrueToRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		boolean existsEdge = graphToTest.existsEdge(node1, node2);
		
		assertTrue(existsEdge);
	}

	// ADD EDGE

	// REMOVE ALL EDGES SET

	// REMOVE ALL EDGES SOURCE TARGET

	// REMOVE ALL EDGES NODE

	// REMOVE EDGE

}
