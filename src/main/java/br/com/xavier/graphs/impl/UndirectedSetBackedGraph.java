package br.com.xavier.graphs.impl;

import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class UndirectedSetBackedGraph<N, E> extends SetBackedGraph<N, E>{

	public UndirectedSetBackedGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super(nodeFactory, edgeFactory, loopsAllowed, multipleEdgesAllowed);
	}

	//XXX OVERRIDE NODES METHODS
	
	@Override
	public N replaceNode(N graphNode, N newNode) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areAdjacents(N node1, N node2) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return 0;
	}

	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public Set<E> getAllEdges(N node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> getAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(N sourceNode, N targetNode, E edge) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean removeEdge(E edge) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E replaceEdge(E graphEdge, E newEdge) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
