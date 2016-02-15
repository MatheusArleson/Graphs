package br.com.xavier.graphs.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;
import br.com.xavier.graphs.util.messages.Util;

public abstract class SetBackedGraph<N,E> extends AbstractGraph<N,E> {
	
	//XXX CLASS PROPERTIES
	private Set<N> nodesSet;
	private Set<E> edgesSet;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Construct a new Graph object that is backed by {@link Set}.
	 * 
	 * @param nodeFactory {@link NodeFactory} - the Node factory of the new graph.
	 * @param edgeFactory {@link EdgeFactory} - the Edge factory of the new graph.
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public SetBackedGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super(nodeFactory, edgeFactory, loopsAllowed, multipleEdgesAllowed);
		
		this.nodesSet = new LinkedHashSet<N>();
		this.edgesSet = new LinkedHashSet<E>();
	}
	
	//XXX OVERRIDE NODES METHODS
	
	@Override
	public Set<N> getAllNodes() {
		return nodesSet;
	}
	
	@Override
	public boolean containsNode(N node) throws NullPointerException {
		Util.handleNullParameter(node);
		return nodesSet.contains(node); 
	}
	
	@Override
	public boolean addNode(N node) throws NullPointerException {
		Util.handleNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		return nodesSet.add(node);
	}
	
	@Override
	public boolean removeNode(N node) throws NullPointerException {
		Util.handleNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		removeAllEdges(node);
		return nodesSet.remove(node);
	}
	
	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public Set<E> getAllEdges() {
		return edgesSet;
	}
	
	@Override
	public boolean containsEdge(E edge) throws NullPointerException {
		Util.handleNullParameter(edge);
		return edgesSet.contains(edge);
	}
}
