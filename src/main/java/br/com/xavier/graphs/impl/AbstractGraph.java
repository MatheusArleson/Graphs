package br.com.xavier.graphs.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;
import br.com.xavier.graphs.util.messages.MessageManager;
import br.com.xavier.graphs.util.messages.enums.DefaultMessagesKey;

/**
 * A skeletal implementation of the Graph interface, to minimize the effort required to implement Graph interfaces. </br>
 * This implementation is applicable to both: directed graphs and undirected graphs.</br>
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edge type class
 */
public abstract class AbstractGraph<N,E> implements Graph<N, E> {
	
	//XXX CLASS PROPERTIES
	private NodeFactory<N> nodeFactory;
	private EdgeFactory<N,E> edgeFactory;
	
	private boolean loopsAllowed;
	private boolean multipleEdgesAllowed;
	
	//XXX CONSTRUCTOR
	/**
	 * Construct a new empty Graph object.
	 * 
	 * @param nodeFactory {@link NodeFactory} - the Node factory of the new graph.
	 * @param edgeFactory {@link EdgeFactory} - the Edge factory of the new graph.
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public AbstractGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super();
		this.nodeFactory = nodeFactory;
		this.edgeFactory = edgeFactory;
		this.loopsAllowed = loopsAllowed;
		this.multipleEdgesAllowed = multipleEdgesAllowed;
	}
	
	//XXX OVERRIDE METHODS
	
	//NODES METHODS
	@Override
	public NodeFactory<N> getNodeFactory() {
		return nodeFactory;
	}
	
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
	public EdgeFactory<N, E> getEdgeFactory() {
		return edgeFactory;
	}
	
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

	//XXX GETTERS
	/**
	 * Returns true if and only if self-loops are allowed in this Graph. </br> 
	 * A self loop is an Edge that its source and target Nodes are the same. </br>
	 * 
	 * @return true if loops are allowed in this Graph.
	 */
	public boolean isLoopsAllowed() {
		return loopsAllowed;
	}
	
	/**
	 * Returns true if and only if multiple equivalent Edges are allowed in this Graph. </br>
	 * The meaning of multiple edges is that there can be many Edges going from vertex v1 to vertex v2. </br>
	 * 
	 * @return
	 */
	public boolean isMultipleEdgesAllowed() {
		return multipleEdgesAllowed;
	}
}
