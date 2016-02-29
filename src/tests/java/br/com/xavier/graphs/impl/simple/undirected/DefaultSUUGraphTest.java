package br.com.xavier.graphs.impl.simple.undirected;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class DefaultSUUGraphTest {
	
	//XXX TEST SUBJECT
	private DefaultSUUGraph<NumberedNode, DefaultUnweightedEdge<NumberedNode>> graph;
	
	//XXX TEST PROPERTIES
	private NumberedNodesFactory nodeFactory;
	
	//XXX SETUP METHODS
	@Before
	public void setup(){
		graph = new DefaultSUUGraph<NumberedNode, DefaultUnweightedEdge<NumberedNode>>();
		nodeFactory = new NumberedNodesFactory();
	}
	
	//XXX CLEAN UP METODS
	@After
	public void cleanUp(){
		graph = null;
		nodeFactory = null;
	}
	
	//XXX UTIL METHODS
	private Set<NumberedNode> createNodesSet(int size){
		Set<NumberedNode> nodesSet = new LinkedHashSet<NumberedNode>();
		for (int i = 0; i < size; i++) {
			nodesSet.add(nodeFactory.createNode());
		}
		return nodesSet;
	}
	
	private void buildAreAdjacentsCenario(NumberedNode node1, NumberedNode node2, NumberedNode node3){
		//graph with 3 nodes. 
		//relationships: 1 -> 2; 2-> 3; (NOT 1 -> 3)
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		DefaultUnweightedEdge<NumberedNode> edge12 = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		DefaultUnweightedEdge<NumberedNode> edge23 = new DefaultUnweightedEdge<NumberedNode>(node2, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
	}
	
	//XXX TEST METHODS
	
	//------------------------------------------
	// 			NODES METODS
	//------------------------------------------
	
	//GET ALL NODES
	
	@Test
	public void getAllNodesMustReturnEmptyNodeSetOnEmptyGraph(){
		//graph is clean on start
		
		Set<NumberedNode> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void getAllNodesMustReturnNotEmptyNodeSetOnNotEmptyGraph(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		
		Set<NumberedNode> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();
		
		assertFalse(isEmpty);
	}
	
	@Test
	public void getAllNodesMustReturnNodeSetWithSameSizeAndReferences(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		
		Set<NumberedNode> allNodes = graph.getAllNodes();
		boolean containsAddedNode = allNodes.contains(node);
		boolean isSizeOne = allNodes.size() == 1;
		boolean result = containsAddedNode && isSizeOne;
		
		assertTrue(result);
	}
	
	//CONTAINS NODE
	
	@Test(expected=NullPointerException.class)
	public void containsNodeMustThrowExceptionOnNullNode(){
		//graph is clean on start
		
		NumberedNode node = null;
		graph.containsNode(node);
	}
	
	@Test
	public void containsNodeMustReturnFalseOnEmptyGraph(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		boolean isPresent = graph.containsNode(node);
		
		assertFalse(isPresent);
	}
	
	@Test
	public void containsNodeMustReturnTrueOnPresentNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		boolean isPresent = graph.containsNode(node);
		
		assertTrue(isPresent);
	}
	
	@Test
	public void containsNodeMustReturnFalseOnNotPresentNode(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		graph.addNode(node1);
		
		NumberedNode node2 = nodeFactory.createNode();
		boolean isPresent = graph.containsNode(node2);
		
		assertFalse(isPresent);
	}
	
	//ADD NODE
	
	@Test(expected=NullPointerException.class)
	public void addNodeMustThrowExceptionOnNullNode(){
		//graph is clean on start
		
		NumberedNode node = null;
		graph.addNode(node);
	}
	
	@Test
	public void addNodeMustReturnTrueOnDistinctNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		boolean nodeAdded = graph.addNode(node);
		
		assertTrue(nodeAdded);
	}
	
	@Test
	public void addNodeMustReturnFalseOnRepeatedNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);	
		boolean repeatedNodeAdded = graph.addNode(node);
	
		assertFalse(repeatedNodeAdded);
	}
	
	//REMOVE ALL NODES
	
	@Test
	public void removeAllNodesMustReturnFalseOnEmptyGraph(){
		//graph is clean on start
		
		boolean isChanged = graph.removeAllNodes();
		
		assertFalse(isChanged);
	}
	
	@Test
	public void removeAllNodesMustReturnTrueOnNotEmptyGraph(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		
		boolean isChanged = graph.removeAllNodes();
		
		assertTrue(isChanged);
	}
	
	@Test
	public void removeAllNodesMustClearGraphNodes(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		
		graph.removeAllNodes();
		
		Set<NumberedNode> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void removeAllNodesMustClearGraphEdges(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		DefaultUnweightedEdge<NumberedNode> edge = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(edge);
		
		graph.removeAllNodes();
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges();
		boolean isEmpty = allEdges.isEmpty();
		
		assertTrue(isEmpty);
	}

	//REMOVE ALL NODES (Set)
	
	@Test(expected=NullPointerException.class)
	public void removeAllNodesCollectionsMustThrowNullPointerExceptionOnNullSet(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = null;
		graph.removeAllNodes(nodesSet);
	}
	
	@Test
	public void removeAllNodesCollectionMustReturnFalseOnEmptyGraph(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = createNodesSet(1);
		
		boolean isChanged = graph.removeAllNodes(nodesSet);
		
		assertFalse(isChanged);
	}
	
	@Test
	public void removeAllNodesCollectionMustReturnTrueOnNotEmptyGraph(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = createNodesSet(1);
		graph.addNode(nodesSet.iterator().next());
		
		boolean isChanged = graph.removeAllNodes(nodesSet);
		
		assertTrue(isChanged);
	}
	
	@Test
	public void removeAllNodesCollectionMustClearGraphNodes(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = createNodesSet(1);
		Iterator<NumberedNode> iterator = nodesSet.iterator();
		graph.addNode(iterator.next());
		
		graph.removeAllNodes();
		
		Set<NumberedNode> allNodes = graph.getAllNodes();
		boolean isEmpty = allNodes.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void removeAllNodesCollectionMustClearGraphEdges(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = createNodesSet(2);
		Iterator<NumberedNode> iterator = nodesSet.iterator();
		NumberedNode node1 = iterator.next();
		NumberedNode node2 = iterator.next();
		
		DefaultUnweightedEdge<NumberedNode> edge = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(edge);
		
		graph.removeAllNodes(nodesSet);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges();
		boolean isEmpty = allEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	public void removeAllNodesCollectionMustRemoveNodesNotPresentInTheGraph(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = createNodesSet(3);
		Iterator<NumberedNode> iterator = nodesSet.iterator();
		NumberedNode node1 = iterator.next();
		NumberedNode node2 = iterator.next();
		NumberedNode node3 = iterator.next();
		
		iterator = null;
		
		graph.addNode(node1);
		graph.addNode(node2);
		
		graph.removeAllNodes(nodesSet);
		
		boolean isInvalidNodeOnSet = nodesSet.contains(node3);
		
		assertFalse(isInvalidNodeOnSet);
	}
	
	//REMOVE ALL NODES (Node)
	
	@Test(expected=NullPointerException.class)
	public void removeNodeMustThrowNullPointerExceptionOnNullNode(){
		//graph is clean on start
		
		NumberedNode node = null;
		graph.removeNode(node);
	}

	@Test
	public void removeNodeMustReturnFalseOnEmptyGraph(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		
		boolean isChanged = graph.removeNode(node);
		
		assertFalse(isChanged);
	}
	
	@Test
	public void removeNodeMustReturnFalseOnNotPresentNode(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		graph.addNode(node1);
		
		boolean isChanged = graph.removeNode(node2);
		
		assertFalse(isChanged);
	}
	
	@Test
	public void removeNodeMustReturnTrueOnPresentNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		
		boolean isChanged = graph.removeNode(node);
		
		assertTrue(isChanged);
	}
	
	@Test
	public void removeNodeMustClearGraphEdgesRelatedToIt(){
		//graph is clean on start
		
		Set<NumberedNode> nodesSet = createNodesSet(2);
		Iterator<NumberedNode> iterator = nodesSet.iterator();
		NumberedNode node1 = iterator.next();
		NumberedNode node2 = iterator.next();
		
		DefaultUnweightedEdge<NumberedNode> startingEdge = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		DefaultUnweightedEdge<NumberedNode> endingEdge = new DefaultUnweightedEdge<NumberedNode>(node2, node1);
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(startingEdge);
		
		graph.removeNode(node1);
		
		boolean containsEdge = false; 
		try{
			containsEdge = containsEdge |= graph.containsEdge(startingEdge);
			containsEdge = containsEdge |= graph.containsEdge(endingEdge);
		} catch(IllegalNodeException e){
		}
		
		assertFalse(containsEdge);
	}
	
	//ARE ADJACENTS
	
	@Test
	public void areAdjacentsMustThrowNullPointerExceptionOnAnyNullNode(){
		//graph is clean on start
		
		NumberedNode realNode = nodeFactory.createNode();
		NumberedNode nullNode = null;
		
		boolean allException = false;
		try { graph.areAdjacents(nullNode, nullNode); } catch(NullPointerException e1){
			try { graph.areAdjacents(realNode, nullNode); } catch(NullPointerException e2){
				try { graph.areAdjacents(nullNode, realNode); } catch(NullPointerException e3){
					allException = true;
				}
			}
		}
		
		assertTrue(allException);
	}
	
	@Test
	public void areAdjacentsMustThrowIllegalNodeExceptionOnAnyNotPresentNode(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		
		graph.addNode(node1);
		
		boolean allException = false;
		try { graph.areAdjacents(node1, node2); } catch(IllegalNodeException e1){
			try { graph.areAdjacents(node2, node1); } catch(IllegalNodeException e2){
				allException = true;
			}
		}
		
		assertTrue(allException);
	}
	
	@Test
	public void areAdjacentsMustReturnFalseOnNotRelatedNodes(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		NumberedNode node3 = nodeFactory.createNode();
		buildAreAdjacentsCenario(node1, node2, node3);
		
		boolean areAdjacents = graph.areAdjacents(node1, node3);
		
		assertFalse(areAdjacents);
	}
	
	@Test
	public void areAdjacentsMustReturnTrueOnRelatedNodes(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		NumberedNode node3 = nodeFactory.createNode();
		buildAreAdjacentsCenario(node1, node2, node3);
		
		boolean areAdjacents = graph.areAdjacents(node1, node2);
		
		assertTrue(areAdjacents);
	}
	
	//DEGREE OF
	
	@Test(expected=NullPointerException.class)
	public void degreeOfMustThrowNullPointerExceptionOnNullNode(){
		//graph is clean on start
		
		NumberedNode node = null;
		
		graph.degreeOf(node);
	}
	
	@Test(expected=IllegalNodeException.class)
	public void degreeOfMustThrowIllegalNodeExceptionOnNotPresentNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		
		graph.degreeOf(node);
	}
	
	@Test
	public void degreeOfMustReturnZeroOnIsolatedNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);
		
		int nodeDegree = graph.degreeOf(node);
		
		assertEquals(0, nodeDegree);
	}
	
	@Test
	public void degreeOfTest(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		NumberedNode node3 = nodeFactory.createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		DefaultUnweightedEdge<NumberedNode> edge12 = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		DefaultUnweightedEdge<NumberedNode> edge13 = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		DefaultUnweightedEdge<NumberedNode> edge23 = new DefaultUnweightedEdge<NumberedNode>(node2, node3);
		
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
	
	//------------------------------------------
	// 			EDGES METODS
	//------------------------------------------
	
	//GET ALL EDGES

	@Test
	public void getAllEdgesMustReturnEmptyEdgeSetOnEmptyGraph(){
		//graph is clean on start
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges();
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void getAllEdgesMustReturnEmptyEdgeSetOnGraphWithNoEdges(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		graph.addNode(node1);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges();
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void getAllEdgesMustReturnNotEmptyEdgeSetOnGraphWithEdges(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		
		DefaultUnweightedEdge<NumberedNode> edge = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		
		graph.addEdge(edge);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges();
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertFalse(isEmpty);
	}
	
	@Test
	public void getAllEdgesMustReturnEdgeSetWithSameSizeAndReferences(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		NumberedNode node3 = nodeFactory.createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		DefaultUnweightedEdge<NumberedNode> edge12 = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		DefaultUnweightedEdge<NumberedNode> edge23 = new DefaultUnweightedEdge<NumberedNode>(node2, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges();
		
		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		boolean isSizeTwo = allEdges.size() == 2;
		boolean result = containsEdge12 && containsEdge23 && isSizeTwo;
		
		assertTrue(result);
	}
	
	//GET ALL EDGES NODE
	
	@Test(expected=NullPointerException.class)
	public void getAllEdgesNodeMustThrowNullPointerExceptionOnNullNode(){
		//graph is clean on start
		
		NumberedNode node = null;
		
		graph.getAllEdges(node);
	}
	
	@Test(expected=IllegalNodeException.class)
	public void getAllEdgesNodeMustThrowNIllegalNodeExceptionOnNotPresentNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		
		graph.getAllEdges(node);
	}
	
	@Test
	public void getAllEdgesNodeMustReturnEmptyEdgeSetOnNotRelatedNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		
		graph.addNode(node);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges(node);
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertTrue(isEmpty);
	}
	
	@Test
	public void getAllEdgesNodeMustReturnNotEmptyEdgeSetOnRelatedNode(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		
		DefaultUnweightedEdge<NumberedNode> edge12 = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		
		graph.addEdge(edge12);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges(node1);
		
		boolean isEmpty = allEdges.isEmpty();
		
		assertFalse(isEmpty);
	}
	
	@Test
	public void getAllEdgesNodeMustReturnEdgeSetWithSameSizeAndReferences(){
		//graph is clean on start
		
		NumberedNode node1 = nodeFactory.createNode();
		NumberedNode node2 = nodeFactory.createNode();
		NumberedNode node3 = nodeFactory.createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		DefaultUnweightedEdge<NumberedNode> edge12 = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		DefaultUnweightedEdge<NumberedNode> edge23 = new DefaultUnweightedEdge<NumberedNode>(node2, node3);
		
		graph.addEdge(edge12);
		graph.addEdge(edge23);
		
		Set<DefaultUnweightedEdge<NumberedNode>> allEdges = graph.getAllEdges(node1);
		
		boolean containsEdge12 = allEdges.contains(edge12);
		boolean containsEdge23 = allEdges.contains(edge23);
		boolean isSizeOne = allEdges.size() == 1;
		boolean result = containsEdge12 && containsEdge23 && isSizeOne && !containsEdge23;
		
		assertTrue(result);
	}
	
	//GET ALL EDGES SOURCE TARGET
	
	//CONTAINS EDGE
	
	//EXISTS EDGE
	
	//ADD EDGE
	
	//REMOVE ALL EDGES SET
	
	//REMOVE ALL EDGES SOURCE TARGET
	
	//REMOVE ALL EDGES NODE
	
	//REMOVE EDGE
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
