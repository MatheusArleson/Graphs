package br.com.xavier.graphs.impl;

import java.util.Collection;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.util.MessageManager;

public abstract class AbstractGraph<N,E> implements Graph<N, E> {
	
	@Override
	public boolean containsEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		E edge = getEdge(sourceNode, targetNode);
		return edge != null;
	}
	
	@Override
	public boolean removeAllEdges(Collection<? extends E> edgesCollection) throws NullPointerException {
		if(edgesCollection == null){
			throw new NullPointerException(MessageManager.getMessage("parameter.null"));
		}
		
		boolean modified = false;
	    for (E e : edgesCollection) {
	      modified |= removeEdge(e);
	    }
	    return modified;
	}
	
	@Override
	public Set<E> removeAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

}
