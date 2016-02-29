package br.com.xavier.graphs.abstractions;

import java.io.IOError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.edges.WeightedEdge;
import br.com.xavier.graphs.util.messages.Util;

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
		edges.addAll(getAllEdges(targetNode, sourceNode));
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
			if(graphEdge.equals(edge)){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean addEdge(E edge) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(edge);
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		
		//checking loops
		if(!isLoopsAllowed() && sourceNode.equals(targetNode)){
			return false;
		}
		
		//checking multiple edges
		if(!isMultipleEdgesAllowed() && containsEdge(edge)){
			return false;
		}
		
		//checking weight (XOR)
		boolean isEdgeWeighted = WeightedEdge.class.isAssignableFrom(edge.getClass()); //(edge instanceof WeightedEdge);
		boolean isGraphWeighted = isWeighted();
		boolean error = isGraphWeighted ^ isEdgeWeighted; 
		if(error){
			Util.handleIllegalEdge();
		}
		
		graphMap.get(sourceNode).add(edge);
		
		//FIXME if undirected add the edge in source\target reverse order
		if(!isDirected()){
			graphMap.get(targetNode).add((E) edge.reverse());
		}
		
		return true;
	}
	
	@Override
	public boolean removeEdge(E edge) throws NullPointerException {
		Util.checkNullParameter(edge);
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		
		boolean isRemoved = graphMap.get(sourceNode).remove(edge);
		
		//FIXME if undirected add the edge in source\target reverse order
		if(!isDirected()){
			isRemoved |= graphMap.get(targetNode).remove((E) edge.reverse());
		}
		
		return isRemoved;
	}
}
