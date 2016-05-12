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
import br.com.xavier.graphs.interfaces.edges.WeightedEdge;
import br.com.xavier.graphs.util.Util;

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
	
	//XXX OVERRIDE METHODS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDirected ? 1231 : 1237);
		result = prime * result + (isWeighted ? 1231 : 1237);
		result = prime * result + (loopsAllowed ? 1231 : 1237);
		result = prime * result + (multipleEdgesAllowed ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AbstractGraph other = (AbstractGraph) obj;
		if (isDirected != other.isDirected) {
			return false;
		}
		if (isWeighted != other.isWeighted) {
			return false;
		}
		if (loopsAllowed != other.loopsAllowed) {
			return false;
		}
		if (multipleEdgesAllowed != other.multipleEdgesAllowed) {
			return false;
		}
		return true;
	}
	
	//XXX GRAPH METHODS
	
	@Override
	public void merge(Graph<N, E> otherGraph) {
		Util.checkNullParameter(otherGraph);
		
		if(otherGraph.isEmpty()){
			return;
		}
		
		for (N node : otherGraph.getAllNodes()) {
			this.addNode(node);
		}
		
		for (E edge : otherGraph.getAllEdges()) {
			this.addEdge(edge);
		}
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
			if(modified == false){
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
		List<E> edgesList = new ArrayList<E>(edgesSet);
		ListIterator<E> listIterator = edgesList.listIterator();
		
		while(listIterator.hasNext()){
			E edge = listIterator.next();
			
			if(!containsEdge(edge)){
				listIterator.remove();
				continue;
			}
			
			boolean isChanged = removeEdge(edge);
			if(modified == false){
				modified |= isChanged;
			}
		}
	    
		edgesSet.clear();
		edgesSet.addAll(edgesList);
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
	
	@Override
	public Set<E> getDistinctEdges(){
		Set<E> distinctEdgesSet = new LinkedHashSet<E>();
		for (N node : getAllNodes()) {
			getDistinctEdges(node, distinctEdgesSet);
		}
		return distinctEdgesSet;
	}
	
	@Override
	public Set<E> getDistinctEdges(N node) {
		Set<E> distinctEdgesSet = new LinkedHashSet<E>();
		getDistinctEdges(node, distinctEdgesSet);
		return distinctEdgesSet;
	}
	
	private void getDistinctEdges(N node, Set<E> reentrantDistinctEdgesSet){
		if(isDirected()){
			getDistinctDirectedEdges(node, reentrantDistinctEdgesSet);
		} else {
			getDistinctUndirectedEdges(node, reentrantDistinctEdgesSet);
		}
	}

	private void getDistinctDirectedEdges(N node, Set<E> distinctEdgesSet) {
		distinctEdgesSet.addAll(getAllEdges(node));
	}
	
	private void getDistinctUndirectedEdges(N node, Set<E> distinctEdgesSet) {
		for (E edge : getAllEdges(node)) {
			N source = edge.getSource();
			N target = edge.getTarget();

			if (distinctEdgesSet.isEmpty()) {
				distinctEdgesSet.add(edge);
				continue;
			}

			boolean found = false;
			for (E distinctEdge : distinctEdgesSet) {
				N distinctSource = distinctEdge.getSource();
				N distinctTarget = distinctEdge.getTarget();

				boolean isSourceTarget = source.equals(distinctTarget);
				boolean isTargetSource = target.equals(distinctSource);

				if (isSourceTarget && isTargetSource) {
					found = true;
					break;
				}
			}

			if (!found) {
				distinctEdgesSet.add(edge);
			}
		}
	}
	
	//XXX METHODS
	public boolean isEdgeAllowed(E edge){
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
		boolean weighted = isWeighted();
		boolean isEdgeWeighted = WeightedEdge.class.isAssignableFrom(edge.getClass());
		
		boolean error = weighted ^ isEdgeWeighted;
		if(error){
			Util.handleIllegalEdge();
		} 
		
		return true;
	}
	
	//XXX GETTERS
	
	@Override
	public boolean isDirected() {
		return isDirected;
	}
	
	@Override
	public boolean isWeighted() {
		return isWeighted;
	}
	
	@Override
	public boolean isLoopsAllowed() {
		return loopsAllowed;
	}
	
	@Override
	public boolean isMultipleEdgesAllowed() {
		return multipleEdgesAllowed;
	}
}
