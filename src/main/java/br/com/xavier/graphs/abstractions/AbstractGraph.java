package br.com.xavier.graphs.abstractions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.messages.Util;

/**
 * A skeletal implementation of the Graph interface, to minimize the effort required to implement Graph interfaces. </br>
 * This implementation is applicable to both: directed graphs and undirected graphs.</br>
 * 
 * @author Matheus Xavier
 *
 */
public abstract class AbstractGraph<N extends AbstractNode, E extends Edge<N>> implements Graph<N,E> {
	
	//XXX CLASS PROPERTIES
	private final boolean isDirected;
	private final boolean isWeighted;
	private final boolean loopsAllowed;
	private final boolean multipleEdgesAllowed;
	
	//XXX CONSTRUCTOR
	/**
	 * Construct a new empty Graph object.
	 * 
	 * @param isDirected - if the Edges of the Graph are directed; 
	 * @param isWeighted - if the Edges of the Graph are weighted;
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public AbstractGraph(
		boolean isDirected, boolean isWeighted, 
		boolean loopsAllowed, boolean multipleEdgesAllowed
	) {
		super();
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		this.loopsAllowed = loopsAllowed;
		this.multipleEdgesAllowed = multipleEdgesAllowed;
	}
	
	//XXX OVERRIDE NODES METHODS
	
	@Override
	public boolean removeAllNodes() {
		return removeAllNodes(getAllNodes());
	}
	
	@Override
	public boolean removeAllNodes(Set<N> nodesSet) throws NullPointerException {
		Util.checkNullParameter(nodesSet);

		boolean modified = false;
		List<N> nodesList = new ArrayList<N>(nodesSet);
		ListIterator<N> listIterator = nodesList.listIterator();
		
		while(listIterator.hasNext()){
			N node = listIterator.next();
			if(!containsNode(node)){
				listIterator.remove();
				continue;
			}
			
			boolean isChanged = removeNode(node);
			if(modified != true){
				modified |= isChanged;
			} 
		}
		
		nodesSet = new LinkedHashSet<N>(nodesList);
		return modified;
	}

	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public boolean removeAllEdges(Set<E> edgesSet) throws NullPointerException {
		Util.checkNullParameter(edgesSet);
		
		boolean modified = false;
		Set<E> invalidEdges = new LinkedHashSet<E>();
		
		for (E edge: edgesSet) {
			if(!containsEdge(edge)){
				invalidEdges.add(edge);
				continue;
			}
			
			modified |= removeEdge(edge);
		}
	    
		edgesSet.removeAll(invalidEdges);
	    return modified;
	}
	
	@Override
	public Set<E> removeAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(sourceNode, targetNode);
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		Set<E> allEdges = getAllEdges(sourceNode, targetNode);
		if (allEdges == null || allEdges.isEmpty()) {
			return new LinkedHashSet<E>();
		}
		
		removeAllEdges(allEdges);
		return allEdges;
	}
	
	@Override
	public Set<E> removeAllEdges(N node) {
		Util.checkNullParameter(node);
		
		Set<E> allEdges = getAllEdges(node);
		if (allEdges == null || allEdges.isEmpty()) {
			return new LinkedHashSet<E>();
		}
		
		removeAllEdges(allEdges);
		return allEdges;
	}
	
	@Override
	public boolean areAdjacents(N node1, N node2) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, node1, node2);
		
		return existsEdge(node1, node2);
	}
	
	@Override
	public boolean existsEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		if(!loopsAllowed && sourceNode.equals(targetNode)){
			return false;
		}
		
		Set<E> allEdges = getAllEdges(sourceNode, targetNode);
		for (E edge : allEdges) {
			if(edge.isPath(sourceNode, targetNode)){
				return true;
			}
		}
		
		return false;
	}
	
	//XXX GETTERS
	
	/**
	 * Returns true if the Edges of the Graph are directed;
	 * 
	 * @return true if the Edges of the Graph are directed; false otherwise;
	 */
	public boolean isDirected() {
		return isDirected;
	}
	
	/**
	 * Returns true if the Edges of the Graph are weighted;
	 * 
	 * @return true if the Edges of the Graph are wieghted; false otherwise;
	 */
	public boolean isWeighted() {
		return isWeighted;
	}
	
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
