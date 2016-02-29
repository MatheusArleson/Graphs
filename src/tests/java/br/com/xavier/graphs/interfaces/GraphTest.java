package br.com.xavier.graphs.interfaces;

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

public abstract class GraphTest<N extends Node, E extends Edge<N>> {
	
	//XXX TEST SUBJECT
	protected Graph<N, E> graph;

	//XXX ABSTRACT METHODS
	protected abstract Graph<N, E> getGraphInterfaceInstance();
	protected abstract N createNode();
	protected abstract E createEdge(N node1, N node2);

	//XXX BEFORE METHODS
	@Before
	public void setup() {
		graph = getGraphInterfaceInstance();
	}

	//XXX AFTER METHODS
	@After
	public void destroy() {
		graph = null;
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
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graph.addEdge(edge12);
		graph.addEdge(edge23);
	}

	// XXX TEST METHODS

	// ------------------------------------------
	// NODES METODS
	// ------------------------------------------

	// GET ALL NODES

	@Test
	public void getAllNodesMustReturnEmptyNodeSetOnEmptyGraph() {
		// graph is clean on start

		Set<N> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllNodesMustReturnNotEmptyNodeSetOnNotEmptyGraph() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);

		Set<N> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertFalse(isEmpty);
	}

	@Test
	public void getAllNodesMustReturnNodeSetWithSameSizeAndReferences() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);

		Set<N> allNodes = graph.getAllNodes();
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
		graph.containsNode(node);
	}

	@Test
	public void containsNodeMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		N node = createNode();
		boolean isPresent = graph.containsNode(node);

		assertFalse(isPresent);
	}

	@Test
	public void containsNodeMustReturnTrueOnPresentNode() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);
		boolean isPresent = graph.containsNode(node);

		assertTrue(isPresent);
	}

	@Test
	public void containsNodeMustReturnFalseOnNotPresentNode() {
		// graph is clean on start

		N node1 = createNode();
		graph.addNode(node1);

		N node2 = createNode();
		boolean isPresent = graph.containsNode(node2);

		assertFalse(isPresent);
	}

	// ADD NODE

	@Test(expected = NullPointerException.class)
	public void addNodeMustThrowExceptionOnNullNode() {
		// graph is clean on start

		N node = null;
		graph.addNode(node);
	}

	@Test
	public void addNodeMustReturnTrueOnDistinctNode() {
		// graph is clean on start

		N node = createNode();
		boolean nodeAdded = graph.addNode(node);

		assertTrue(nodeAdded);
	}

	@Test
	public void addNodeMustReturnFalseOnRepeatedNode() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);
		boolean repeatedNodeAdded = graph.addNode(node);

		assertFalse(repeatedNodeAdded);
	}

	// REMOVE ALL NODES

	@Test
	public void removeAllNodesMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		boolean isChanged = graph.removeAllNodes();

		assertFalse(isChanged);
	}

	@Test
	public void removeAllNodesMustReturnTrueOnNotEmptyGraph() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);

		boolean isChanged = graph.removeAllNodes();

		assertTrue(isChanged);
	}

	@Test
	public void removeAllNodesMustClearGraphNodes() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);

		graph.removeAllNodes();

		Set<N> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void removeAllNodesMustClearGraphEdges() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graph.addNode(node1);
		graph.addNode(node2);
		
		E edge = createEdge(node1, node2);
		
		graph.addEdge(edge);

		graph.removeAllNodes();

		Set<E> allEdges = graph.getAllEdges();
		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	// REMOVE ALL NODES (Set)

	@Test(expected = NullPointerException.class)
	public void removeAllNodesCollectionsMustThrowNullPointerExceptionOnNullSet() {
		// graph is clean on start

		Set<N> nodesSet = null;
		graph.removeAllNodes(nodesSet);
	}

	@Test
	public void removeAllNodesCollectionMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(1);

		boolean isChanged = graph.removeAllNodes(nodesSet);

		assertFalse(isChanged);
	}

	@Test
	public void removeAllNodesCollectionMustReturnTrueOnNotEmptyGraph() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(1);
		graph.addNode(nodesSet.iterator().next());

		boolean isChanged = graph.removeAllNodes(nodesSet);

		assertTrue(isChanged);
	}

	@Test
	public void removeAllNodesCollectionMustClearGraphNodes() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(1);
		Iterator<N> iterator = nodesSet.iterator();
		graph.addNode(iterator.next());

		graph.removeAllNodes();

		Set<N> allNodes = graph.getAllNodes();
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

		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(edge);

		graph.removeAllNodes(nodesSet);

		Set<E> allEdges = graph.getAllEdges();
		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	public void removeAllNodesCollectionMustRemoveNodesNotPresentInTheGraphFromCollection() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(3);
		Iterator<N> iterator = nodesSet.iterator();
		N node1 = iterator.next();
		N node2 = iterator.next();
		N node3 = iterator.next();

		iterator = null;

		graph.addNode(node1);
		graph.addNode(node2);

		graph.removeAllNodes(nodesSet);

		boolean isInvalidNodeOnSet = nodesSet.contains(node3);

		assertFalse(isInvalidNodeOnSet);
	}

	// REMOVE ALL NODES (Node)

	@Test(expected = NullPointerException.class)
	public void removeNodeMustThrowNullPointerExceptionOnNullNode() {
		// graph is clean on start

		N node = null;
		graph.removeNode(node);
	}

	@Test
	public void removeNodeMustReturnFalseOnEmptyGraph() {
		// graph is clean on start

		N node = createNode();

		boolean isChanged = graph.removeNode(node);

		assertFalse(isChanged);
	}

	@Test
	public void removeNodeMustReturnFalseOnNotPresentNode() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		graph.addNode(node1);

		boolean isChanged = graph.removeNode(node2);

		assertFalse(isChanged);
	}

	@Test
	public void removeNodeMustReturnTrueOnPresentNode() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);

		boolean isChanged = graph.removeNode(node);

		assertTrue(isChanged);
	}

	@Test
	public void removeNodeMustClearGraphEdgesRelatedToIt() {
		// graph is clean on start

		Set<N> nodesSet = createNodesSet(2);
		Iterator<N> iterator = nodesSet.iterator();
		N node1 = iterator.next();
		N node2 = iterator.next();
		
		graph.addNode(node1);
		graph.addNode(node2);

		E startingEdge = createEdge(node1, node2);
		E endingEdge = createEdge(node2, node1);

		graph.addEdge(startingEdge);

		graph.removeNode(node1);

		boolean containsEdge = false;
		try {
			containsEdge = containsEdge |= graph.containsEdge(startingEdge);
			containsEdge = containsEdge |= graph.containsEdge(endingEdge);
		} catch (IllegalNodeException e) {
		}

		assertFalse(containsEdge);
	}

	// ARE ADJACENTS

	@Test(expected=NullPointerException.class)
	public void areAdjacentsMustThrowNullPointerExceptionOnBothNullNode() {
		// graph is clean on start

		N nullNode = null;

		graph.areAdjacents(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void areAdjacentsMustThrowNullPointerExceptionOnLeftNullNode() {
		// graph is clean on start

		N nullNode = null;
		N node = createNode();
		
		graph.addNode(node);

		graph.areAdjacents(nullNode, node);
	}
	
	@Test(expected=NullPointerException.class)
	public void areAdjacentsMustThrowNullPointerExceptionOnRightNullNode() {
		// graph is clean on start

		N nullNode = null;
		N node = createNode();
		
		graph.addNode(node);

		graph.areAdjacents(node, nullNode);
	}

	@Test
	public void areAdjacentsMustThrowIllegalNodeExceptionOnAnyNotPresentNode() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graph.addNode(node1);

		boolean allException = false;
		try {
			graph.areAdjacents(node1, node2);
		} catch (IllegalNodeException e1) {
			try {
				graph.areAdjacents(node2, node1);
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

		boolean areAdjacents = graph.areAdjacents(node1, node3);

		assertFalse(areAdjacents);
	}

	@Test
	public void areAdjacentsMustReturnTrueOnRelatedNodes() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		buildAreAdjacentsCenario(node1, node2, node3);

		boolean areAdjacents = graph.areAdjacents(node1, node2);

		assertTrue(areAdjacents);
	}

	// DEGREE OF

	@Test(expected = NullPointerException.class)
	public void degreeOfMustThrowNullPointerExceptionOnNullNode() {
		// graph is clean on start

		N node = null;

		graph.degreeOf(node);
	}

	@Test(expected = IllegalNodeException.class)
	public void degreeOfMustThrowIllegalNodeExceptionOnNotPresentNode() {
		// graph is clean on start

		N node = createNode();

		graph.degreeOf(node);
	}

	@Test
	public void degreeOfMustReturnZeroOnIsolatedNode() {
		// graph is clean on start

		N node = createNode();
		graph.addNode(node);

		int nodeDegree = graph.degreeOf(node);

		assertEquals(0, nodeDegree);
	}

	@Test
	public void degreeOfTest() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();

		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);

		E edge12 = createEdge(node1, node2);
		E edge13 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);

		graph.addEdge(edge12);
		graph.addEdge(edge13);
		graph.addEdge(edge23);

		int node1Degree = graph.degreeOf(node1);
		int node2Degree = graph.degreeOf(node2);
		int node3Degree = graph.degreeOf(node3);

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

		Set<E> allEdges = graph.getAllEdges();

		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllEdgesMustReturnEmptyEdgeSetOnGraphWithNoEdges() {
		// graph is clean on start

		N node1 = createNode();
		graph.addNode(node1);

		Set<E> allEdges = graph.getAllEdges();

		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllEdgesMustReturnNotEmptyEdgeSetOnGraphWithEdges() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graph.addNode(node1);
		graph.addNode(node2);

		E edge = createEdge(node1, node2);

		graph.addEdge(edge);

		Set<E> allEdges = graph.getAllEdges();

		boolean isEmpty = allEdges.isEmpty();

		assertFalse(isEmpty);
	}

	// GET ALL EDGES NODE

	@Test(expected = NullPointerException.class)
	public void getAllEdgesNodeMustThrowNullPointerExceptionOnNullNode() {
		// graph is clean on start

		N node = null;

		graph.getAllEdges(node);
	}

	@Test(expected = IllegalNodeException.class)
	public void getAllEdgesNodeMustThrowNIllegalNodeExceptionOnNotPresentNode() {
		// graph is clean on start

		N node = createNode();

		graph.getAllEdges(node);
	}

	@Test
	public void getAllEdgesNodeMustReturnEmptyEdgeSetOnNotRelatedNode() {
		// graph is clean on start

		N node = createNode();

		graph.addNode(node);

		Set<E> allEdges = graph.getAllEdges(node);

		boolean isEmpty = allEdges.isEmpty();

		assertTrue(isEmpty);
	}

	@Test
	public void getAllEdgesNodeMustReturnNotEmptyEdgeSetOnRelatedNode() {
		// graph is clean on start

		N node1 = createNode();
		N node2 = createNode();

		graph.addNode(node1);
		graph.addNode(node2);

		E edge12 = createEdge(node1, node2);

		graph.addEdge(edge12);

		Set<E> allEdges = graph.getAllEdges(node1);

		boolean isEmpty = allEdges.isEmpty();

		assertFalse(isEmpty);
	}

	@Test
	public void getAllEdgesNodeMustReturnEdgeSetWithSameSizeAndReferences() {
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

		Set<E> allEdges = graph.getAllEdges(node1);

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
		
		graph.getAllEdges(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void getAllEdgesSourceTargetMustThrowNullPointerExceptionOnLeftNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graph.addNode(realNode);
		
		graph.getAllEdges(nullNode, realNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void getAllEdgesSourceTargetMustThrowNullPointerExceptionOnRightNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graph.addNode(realNode);
		
		graph.getAllEdges(realNode, nullNode);
	}
	
	@Test(expected=IllegalNodeException.class)
	public void getAllEdgesSourceTargetMustIllegalNodeExceptionOnNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		
		graph.getAllEdges(node1, node3);
	}
	
	@Test
	public void getAllEdgesSourceTargetMustReturnEmptySetOnNotRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		Set<E> allEdges = graph.getAllEdges(node1, node3);
		
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
		
		Set<E> allEdges = graph.getAllEdges(node1, node2);
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertFalse(isEmpty);
	}

	// CONTAINS EDGE
	
	@Test(expected=NullPointerException.class)
	public void containsEdgeMustThrowNullPointerExceptionOnNullEdge(){
		// graph is clean on start
		
		E nullEdge = null;
		
		graph.containsEdge(nullEdge);
	}
	
	@Test(expected=NullPointerException.class)
	public void containsEdgeMustThrowNullPointerExceptionOnNullEdgeSource(){
		// graph is clean on start
		
		N targetNode = createNode();
		
		graph.addNode(targetNode);
		
		E nullSourceEdge = createEdge(null, targetNode);
		
		graph.containsEdge(nullSourceEdge);
	}
	
	@Test(expected=NullPointerException.class)
	public void containsEdgeMustThrowNullPointerExceptionOnNullEdgeTarget(){
		// graph is clean on start
		
		N sourceNode = createNode();
		
		graph.addNode(sourceNode);
		
		E nullTargetEdge = createEdge(sourceNode, null);
		
		graph.containsEdge(nullTargetEdge);
	}
	
	@Test
	public void containsEdgeMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();

		graph.addNode(node1);
		
		E edge12 = createEdge(node1, node2);
		E edge21 = createEdge(node2, node1);

		boolean allException = false;
		try {
			graph.containsEdge(edge12);
		} catch (IllegalNodeException e1) {
			try {
				graph.containsEdge(edge21);
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
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
		
		E edge13 = createEdge(node1, node3);
		
		boolean containsEdge = graph.containsEdge(edge13);
		
		assertFalse(containsEdge);
	}
	
	@Test
	public void containsEdgeMustReturnTrueToRelatedNodes(){
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
		
		E edge13 = createEdge(node1, node2);
		
		boolean containsEdge = graph.containsEdge(edge13);
		
		assertTrue(containsEdge);
	}

	// EXISTS EDGE
	
	@Test(expected=NullPointerException.class)
	public void existsEdgeMustThrowNullPointerExceptionOnBothNullNodes(){
		// graph is clean on start
		
		N nullNode = null;
		
		graph.existsEdge(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void existsEdgeMustThrowNullPointerExceptionOnLeftNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graph.addNode(realNode);
		
		graph.existsEdge(nullNode, realNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void existsEdgeMustThrowNullPointerExceptionOnRightNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graph.addNode(realNode);
		
		graph.existsEdge(realNode, nullNode);;
	}
	
	@Test
	public void existsEdgeMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		graph.addNode(node1);
		
		boolean allExceptions = false;
		try { graph.existsEdge(node1, node2); } catch(IllegalNodeException e1){
			try { graph.existsEdge(node2, node1); } catch(IllegalNodeException e2){
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
		
		boolean existsEdge = graph.existsEdge(node1, node3);
		
		assertFalse(existsEdge);
	}
	
	@Test
	public void existsEdgeMustReturnTrueToRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		boolean existsEdge = graph.existsEdge(node1, node2);
		
		assertTrue(existsEdge);
	}

	// ADD EDGE
	
	@Test(expected=NullPointerException.class)
	public void addEdgeMustThrowNullPointerExceptionOnNullEdge(){
		// graph is clean on start
		
		E edge = null;
		
		graph.addEdge(edge);
	}
	
	@Test(expected=NullPointerException.class)
	public void addEdgeMustThrowNullPointerExceptionOnNullEdgeSource(){
		// graph is clean on start
		
		N sourceNode = null;
		N targetNode = createNode();
		
		graph.addNode(targetNode);
		
		E edge = createEdge(sourceNode, targetNode);
		
		graph.addEdge(edge);
	}
	
	@Test(expected=NullPointerException.class)
	public void addEdgeMustThrowNullPointerExceptionOnNullEdgeTarget(){
		// graph is clean on start
		
		N sourceNode = createNode();
		N targetNode = null;
		
		graph.addNode(sourceNode);
		
		E edge = createEdge(sourceNode, targetNode);
		
		graph.addEdge(edge);
	}
	
	@Test
	public void addEdgeMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		graph.addNode(node1);
		
		E edge12 = createEdge(node1, node2);
		E edge21 = createEdge(node2, node1);
		
		boolean allExceptions = false;
		try { graph.addEdge(edge12); } catch(IllegalNodeException e1){
			try { graph.addEdge(edge21); } catch(IllegalNodeException e2){
				allExceptions = true;
			}
		}
		
		assertTrue(allExceptions);
		
	}
	
	// REMOVE ALL EDGES SET
	
	@Test(expected=NullPointerException.class)
	public void removeAllEdgesMustThrowNullPointerExceptionOnNullSet(){
		// graph is clean on start
		
		Set<E> edgesSet = null;
		
		graph.removeAllEdges(edgesSet);
	}
	
	@Test
	public void removeAllEdgesMustReturnFalseOnEmptyGraph(){
		// graph is clean on start
		
		Set<E> edgesSet = new LinkedHashSet<E>();
		
		boolean isChanged = graph.removeAllEdges(edgesSet);
		
		assertFalse(isChanged);
	}
	
	@Test
	public void removeAllEdgesMustReturnTrueOnNotEmptyGraph(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);
		E edge13 = createEdge(node1, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
		graph.addEdge(edge13);
		
		Set<E> edgesSet = new LinkedHashSet<E>();
		edgesSet.add(edge13);
		
		boolean isChanged = graph.removeAllEdges(edgesSet);;
		
		assertTrue(isChanged);
	}
	
	@Test
	public void removeAllEdgesMustRemoveGraphEdges(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);
		E edge13 = createEdge(node1, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
		graph.addEdge(edge13);
		
		Set<E> edgesSet = new LinkedHashSet<E>();
		edgesSet.add(edge13);
		
		boolean isChanged = graph.removeAllEdges(edgesSet);;
		
		boolean containsEdge12 = graph.getAllEdges(node1, node2).contains(edge12);
		boolean containsEdge23 = graph.getAllEdges(node2, node3).contains(edge23);
		boolean containsEdge13 = graph.getAllEdges(node1, node3).contains(edge13);
		
		boolean result = (isChanged && containsEdge12 && containsEdge23 && !containsEdge13);
		
		assertTrue(result);
	}
	
	@Test
	public void removeAllEdgesMustRemoveEdgesNotPresentInTheGraphFromCollection(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		E edge12 = createEdge(node1, node2);
		E edge23 = createEdge(node2, node3);
		E edge13 = createEdge(node1, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
		
		Set<E> edgesSet = new LinkedHashSet<E>();
		edgesSet.add(edge12);
		edgesSet.add(edge13);
		
		graph.removeAllEdges(edgesSet);
		
		boolean containsEdge12 = edgesSet.contains(edge12);
		boolean containsEdge13 = edgesSet.contains(edge13);
		
		boolean result = (containsEdge12 && !containsEdge13);
		
		assertTrue(result);
	}

	// REMOVE ALL EDGES SOURCE TARGET
	
	@Test(expected=NullPointerException.class)
	public void removeAllEdgesSourceTargetMustThrowNullPointerExceptionOnBothNullNodes(){
		// graph is clean on start
		
		N nullNode = null;
		
		graph.removeAllEdges(nullNode, nullNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void removeAllEdgesSourceTargetMustThrowNullPointerExceptionOnLeftNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graph.addNode(realNode);
		
		graph.removeAllEdges(nullNode, realNode);
	}
	
	@Test(expected=NullPointerException.class)
	public void removeAllEdgesSourceTargetMustThrowNullPointerExceptionOnRightNullNode(){
		// graph is clean on start
		
		N nullNode = null;
		N realNode = createNode();
		
		graph.addNode(realNode);
		
		graph.removeAllEdges(realNode, nullNode);
	}
	
	@Test
	public void removeAllEdgesSourceTargetMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		graph.addNode(node1);
		
		boolean allExceptions = false;
		try{ graph.removeAllEdges(node1, node2); }catch(IllegalNodeException e1){
			try{ graph.removeAllEdges(node2, node1); } catch(IllegalNodeException e2){
				allExceptions = true;
			}
		}
		
		assertTrue(allExceptions);
	}
	
	@Test
	public void removeAllEdgesSourceTargetMustReturnEmptyEdgesSetToNotRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		Set<E> removedEdges = graph.removeAllEdges(node1, node3);
		
		boolean isEmpty = removedEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void removeAllEdgesSourceTargetMustNotReturnEmptyEdgesSetToRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		buildAreAdjacentsCenario(node1, node2, node3);
		
		Set<E> removedEdges = graph.removeAllEdges(node1, node2);
		
		boolean isEmpty = removedEdges.isEmpty();
		
		assertFalse(isEmpty);
	}
	
	// REMOVE ALL EDGES NODE
	
	@Test(expected=NullPointerException.class)
	public void removeAllEdgesNodeMustThrowNullPointerExceptionOnNullNode(){
		// graph is clean on start
		
		N node = null;
		
		graph.removeAllEdges(node);
	}
	
	@Test(expected=IllegalNodeException.class)
	public void removeAllEdgesNodeMustThrowIllegalNodeExceptionOnNotPresentNode(){
		// graph is clean on start
		
		N node = createNode();
		
		graph.removeAllEdges(node);
	}
	
	@Test
	public void removeAllEdgesNodeMustReturnEmptyEdgesSetToNotRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		E edge23 = createEdge(node2, node3);;
		
		graph.addEdge(edge23);
		
		Set<E> removedEdges = graph.removeAllEdges(node1);
		
		boolean isEmpty = removedEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void removeAllEdgesNodeMustReturnNotEmptyEdgesSetToRelatedNodes(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		N node3 = createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		E edge23 = createEdge(node2, node3);;
		
		graph.addEdge(edge23);
		
		Set<E> removedEdges = graph.removeAllEdges(node2);
		
		boolean isEmpty = removedEdges.isEmpty();
		
		assertFalse(isEmpty);
	}

	// REMOVE EDGE
	
	@Test(expected=NullPointerException.class)
	public void removeEdgeMustThrowNullPointerExceptionOnNullEdge(){
		// graph is clean on start
		
		E nullEdge = null;
		
		graph.removeEdge(nullEdge);
	}
	
	@Test(expected=NullPointerException.class)
	public void removeEdgeMustThrowNullPointerExceptionOnNullEdgeSource(){
		// graph is clean on start
		
		N sourceNode = null;
		N targetNode = createNode();
		
		graph.addNode(targetNode);
		
		E edge = createEdge(sourceNode, targetNode);
		
		graph.removeEdge(edge);
	}
	
	@Test(expected=NullPointerException.class)
	public void removeEdgeMustThrowNullPointerExceptionOnNullEdgeTarget(){
		// graph is clean on start
		
		N sourceNode = createNode();
		N targetNode = null;
		
		graph.addNode(targetNode);
		
		E edge = createEdge(sourceNode, targetNode);
		
		graph.removeEdge(edge);
	}
	
	@Test
	public void removeEdgeMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		// graph is clean on start
		
		N node1 = createNode();
		N node2 = createNode();
		
		graph.addNode(node1);
		
		E edge12 = createEdge(node1, node2);
		E edge21 = createEdge(node2, node1);
		
		boolean allExceptions = false;
		try{ graph.removeEdge(edge12); }catch(IllegalNodeException e1){
			try{ graph.removeEdge(edge21); } catch(IllegalNodeException e2){
				allExceptions = true;
			}
		}
		
		assertTrue(allExceptions);
	}
	
	@Test
	public void removeEdgeMustReturnFalseOnNotPresentEdge(){
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
		
		E edge13 = createEdge(node1, node3);
		
		boolean isRemoved = graph.removeEdge(edge13);
		boolean exists = graph.containsEdge(edge13);
		
		boolean result = isRemoved && !exists;
		
		assertFalse(result);
	}
	
	@Test
	public void removeEdgeMustReturnTrueOnPresentEdge(){
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
		
		boolean isRemoved = graph.removeEdge(edge12);
		boolean exists = graph.containsEdge(edge12);
		
		boolean result = isRemoved && !exists;
		
		assertTrue(result);
	}
}
