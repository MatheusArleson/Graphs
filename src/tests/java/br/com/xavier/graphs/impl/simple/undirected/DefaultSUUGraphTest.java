package br.com.xavier.graphs.impl.simple.undirected;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	//XXX TEST METHODS
	
	//------------------------------------------
	// 			NODES METODS
	//------------------------------------------
	
	//GET ALL NODES
	@Test
	public void testGetAllNodes(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		boolean nodeAdded = graph.addNode(node);
	}
	
	//ADD NODE
	@Test(expected=NullPointerException.class)
	public void mustThrowExceptionOnNullNode(){
		//graph is clean on start
		
		NumberedNode node = null;
		boolean nodeAdded = graph.addNode(node);
		
		assertTrue(nodeAdded);
	}
	
	@Test
	public void mustReturnTrueOnAddDistinctNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		boolean nodeAdded = graph.addNode(node);
		
		assertTrue(nodeAdded);
	}
	
	@Test
	public void mustReturnFalseOnAddRepeatedNode(){
		//graph is clean on start
		
		NumberedNode node = nodeFactory.createNode();
		graph.addNode(node);	
		boolean repeatedNodeAdded = graph.addNode(node);
	
		assertFalse(repeatedNodeAdded);
	}

}
