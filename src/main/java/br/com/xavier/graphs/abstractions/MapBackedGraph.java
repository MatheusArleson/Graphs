package br.com.xavier.graphs.abstractions;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.Util;

public abstract class MapBackedGraph<N extends AbstractNode, E extends Edge<N>> extends AbstractGraph<N,E> {
	
	//XXX CLASS PROPERTIES
	private Map<N, Set<E>> graphMap;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Construct a new empty Graph object.
	 * 
	 * @param isDirected - if the Edges of the Graph are directed; 
	 * @param isWeighted - if the Edges of the Graph are weighted;
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public MapBackedGraph(
		boolean isDirected, boolean isWeighted, 
		boolean loopsAllowed, boolean multipleEdgesAllowed
	) {
		super(isDirected, isWeighted, loopsAllowed, multipleEdgesAllowed);
		this.graphMap = new LinkedHashMap<N, Set<E>>();
	}
	
	//XXX OVERRIDE METHODS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((graphMap == null) ? 0 : graphMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MapBackedGraph other = (MapBackedGraph) obj;
		if (graphMap == null) {
			if (other.graphMap != null) {
				return false;
			}
		} else if (!graphMap.equals(other.graphMap)) {
			return false;
		}
		return true;
	}
	
	//XXX OVERRIDE NODES METHODS

	@Override
	public Set<N> getAllNodes() {
		return graphMap.keySet();
	}
	
	@Override
	public boolean containsNode(N node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		return graphMap.containsKey(node);
	}
	
	@Override
	public boolean addNode(N node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		if(containsNode(node)){
			return false;
		}
		
		graphMap.put(node, new LinkedHashSet<E>());
		return true;
	}
	
	@Override
	public boolean removeNode(N node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		removeAllEdges(node);
		graphMap.remove(node);
		return true;
	}

	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public Set<E> getAllEdges() {
		Set<E> allEdges = new LinkedHashSet<E>();
		if(graphMap.isEmpty()){
			return allEdges;
		}
		
		for (N node : getAllNodes()) {
			Set<E> nodeEdgeSet = graphMap.get(node);
			allEdges.addAll(nodeEdgeSet);
		}
		
		return allEdges;
	}
	
	@Override
	public Set<E> getAllEdges(N node) throws IllegalNodeException {
		Util.checkIllegalNode(this, node);
		
		Set<E> nodeEdgesSet = new LinkedHashSet<E>();
		
		for (E edge : graphMap.get(node)) {
			if(edge.getSource().equals(node) || edge.getTarget().equals(node)){
				nodeEdgesSet.add(edge);
			}
		}
		
		return nodeEdgesSet;
	}
	
	@Override
	public Set<E> getAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		if(graphMap.isEmpty()){
			return new LinkedHashSet<E>();
		}
		
		if(isDirected()){
			return getAllDirectedEdges(sourceNode, targetNode);
		} else {
			return getAllUndirectedEdges(sourceNode, targetNode);
		}
	}
	
	private Set<E> getAllUndirectedEdges(N sourceNode, N targetNode) {
		Set<E> edges = getAllDirectedEdges(sourceNode, targetNode);
		edges.addAll(getAllDirectedEdges(targetNode, sourceNode));
		return edges;
	}

	private Set<E> getAllDirectedEdges(N sourceNode, N targetNode) {
		Set<E> nodeEdgesSet = new LinkedHashSet<E>();
		for (E edge : getAllEdges(sourceNode)) {
			if(edge.isPath(sourceNode, targetNode)){
				nodeEdgesSet.add(edge);
			}
		}
		
		return nodeEdgesSet;
	}

	@Override
	public boolean containsEdge(E edge) throws NullPointerException {
		Util.checkNullParameter(edge);
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		Set<E> allEdges = getAllEdges(sourceNode, targetNode);
		for (E graphEdge : allEdges) {
			N graphEdgeSource = graphEdge.getSource();
			N graphEdgeTarget = graphEdge.getTarget();
			
			if(graphEdgeSource.equals(sourceNode) && graphEdgeTarget.equals(targetNode)){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean addEdge(E edge) throws IllegalNodeException, NullPointerException {
		if(!isEdgeAllowed(edge)){
			return false;
		}
		
		graphMap.get(edge.getSource()).add(edge);
		
		if(!isDirected()){
			graphMap.get(edge.getTarget()).add((E) edge.reverse());
		}
		
		return true;
	}
	
	@Override
	public boolean removeEdge(E edge) throws NullPointerException {
		Util.checkNullParameter(edge);
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		boolean isRemoved = graphMap.get(sourceNode).remove(edge);
		
		if(!isDirected()){
			isRemoved |= graphMap.get(targetNode).remove((E) edge.reverse());
		}
		
		return isRemoved;
	}
	
	//XXX GETTERS
	@Override
	public boolean isEmpty() {
		return graphMap != null && graphMap.isEmpty();
	}
}
