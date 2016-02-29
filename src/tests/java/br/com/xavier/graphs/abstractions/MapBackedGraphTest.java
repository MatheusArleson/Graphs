package br.com.xavier.graphs.abstractions;

import static org.junit.Assert.*;

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
	
	
	
	
	
	
	
	//REMOVE EDGE SOURCE TARGET -> CHECK ON UNDIRECTED EDGES IF THEY ARE REMOVED IN PAIRS
}
