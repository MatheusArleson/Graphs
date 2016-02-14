package br.com.xavier.graphs.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.util.messages.MessageManager;
import br.com.xavier.graphs.util.messages.enums.DefaultMessagesKey;

public abstract class AbstractGraph<N,E> implements Graph<N, E> {
	
	//XXX OVERRIDE METHODS
	
	//NODES METHODS
	@Override
	public boolean removeAllNodes(Collection<? extends N> nodesCollection) throws NullPointerException {
		if(nodesCollection == null){
			throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
		}
		
		boolean modified = false;
	    for (N node : nodesCollection) {
	      modified |= removeNode(node);
	    }
	    
	    return modified;
	}
	
	//EDGES METHODS
	@Override
	public boolean containsEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		E edge = getEdge(sourceNode, targetNode);
		return edge != null;
	}
	
	@Override
	public boolean removeAllEdges(Collection<? extends E> edgesCollection) throws NullPointerException {
		if(edgesCollection == null){
			throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
		}
		
		boolean modified = false;
	    for (E e : edgesCollection) {
	      modified |= removeEdge(e);
	    }
	    
	    return modified;
	}
	
	@Override
	public Set<E> removeAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		Set<E> allEdges = getAllEdges(sourceNode, targetNode);
		if (allEdges == null || allEdges.isEmpty()) {
			return new LinkedHashSet<E>();
		}
		
		removeAllEdges(allEdges);
		return allEdges;
	}
	
	//XXX METHODS
	
	/**
	 * Check that the specified Node exists in this Graph.
	 * 
	 * @param node {@link N} - the Node of interest
	 * @return true if this Node is in the Graph.
	 * @throws NullPointerException - if specified Node is null.
	 */
	public boolean nodeExists(N node){
		if(node == null){
			throw new NullPointerException(MessageManager.getDefaultMessage(DefaultMessagesKey.PARAMETER_NULL));
		}
		return containsNode(node);
	}
}
