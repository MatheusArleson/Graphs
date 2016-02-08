package br.com.xavier.graphs;

import java.util.Collection;
import java.util.Set;

/**
 * 
 * The root interface in the graph hierarchy. </br> </br>
 * 
 * A mathematical graph-theory graph object G(V,E) contains a set V of vertices and a set E of edges. </br> 
 * Each edge e=(v1,v2) in E connects vertex v1 to vertex v2. </br>
 * </br>
 * Through generics, a graph can be typed to specific classes for vertices V and edges E<T>. </br>
 * Such a graph can contain vertices of type V and all sub-types and Edges of type E and all sub-types. </br>
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public abstract interface Graph<N, E> {
	
	//XXX FACTORY METHODS
	
	/**
	 * Returns the edge factory using which this graph creates new Edges. </br> 
	 * </br>
	 * The Edge factory is defined when the graph is constructed and must not be modified.
	 * 
	 * @return {@link EdgeFactory} - The Edge factory which this graph uses to create new Edges.
	 */
	public abstract EdgeFactory<N, E> getEdgeFactory();

	//XXX NODES METHODS

	//LIST METHODS
	public abstract Set<N> getAllNodes();

	//CONTAINS METHODS
	/**
	 * Returns true if this graph contains the specified Node. </br> 
	 * More formally, returns true if and only if this graph contains a Node n such that n.equals(someNode).</br> 
	 * 
	 * @param node - Node whose presence in this graph is to be tested.
	 * @return true if this graph contains the specified vertex.
	 * 
	 * @throws NullPointerException if Node parameter is null.
	 */
	public abstract boolean containsNode(N node) throws NullPointerException;

	//ADD METHODS
	public abstract boolean addNode(N node); 
			
	//REMOVE METHODS
	public abstract boolean removeAllNodes(Collection<? extends N> paramCollection);
	public abstract boolean removeNode(N node);
	
	//REPLACE METHODS
	public abstract N replaceNode(N graphNode, N newNode);
	
	//CHECK METHODS
	public abstract boolean areAdjacents(N oneNode, N anotherNode);
	
	//XXX EDGES METHODS

	//LIST METHODS
	public abstract Set<E> getAllEdges();
	public abstract Set<E> getAllEdges(N sourceNode, N targetNode);	
	public abstract E getEdge(N sourceNode, N targetNode);
	public abstract Set<E> getEdges(N node);
	public abstract Set<E> getIncidentEdges(N node);

	//CONTAINS METHODS
	public abstract boolean containsEdge(N sourceNode, N targetNode);
	public abstract boolean containsEdge(E edge);
	
	//ADD METHODS
	
	/**
	 * Creates a new edge in this graph, going from the source vertex to the target vertex, and returns the created edge. </br>
	 * Graphs does not allow edge-multiplicity. In such cases, if the graph already contains an edge from the specified source to the specified target, 
	 * than this method does not change the graph and returns null. </br>
	 * </br>
	 * The source and target vertices must already be contained in this graph. If they are not found in graph IllegalArgumentException is thrown. </br>
	 * </br>
	 * This method creates the new edge e using this graph's {@link EdgeFactory}. </br>
	 * For the new edge to be added e must not be equal to any other edge the graph. More formally, the graph must not contain any edge e2 such that e2.equals(e).</br> 
	 * If such e2 is found then the newly created edge e is abandoned, the method leaves this graph unchanged returns null.</br>
	 * 
	 * @param sourceNode - source Node of the edge.
	 * @param targetNode - target Node of the edge.
	 * 
	 * @return {@link E} - the new Edge.
	 * 
	 * @throws IllegalArgumentException if source or target vertices are not found in the graph.
	 * @throws NullPointerException if any of the specified vertices is null.
	 * 
	 */
	public abstract E createEdge(N sourceNode, N targetNode) throws IllegalArgumentException, NullPointerException;
	
	/**
	 * 
	 * Adds the specified edge to this graph, going from the source vertex to the target vertex. </br>
	 * More formally, adds the specified edge, e, to this graph if this graph contains no edge e2 such that e2.equals(e). </br>
	 * If this graph already contains such an edge, the call leaves this graph unchanged and returns false. </br>
	 * </br>
	 * Graphs does not allow edge-multiplicity. In such cases, if the graph already contains an edge from the specified source to the specified target, 
	 * than this method does not change the graph and returns false. </br>
	 * If the edge was added to the graph, returns true.
	 * </br>
	 * The source and target vertices must already be contained in this graph. </br>
	 * If they are not found in graph IllegalArgumentException is thrown.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @param {@link E} - Edge to be added to this Graph.
	 * 
	 * @return {@link E} - the new Edge.
	 */
	public abstract boolean addEdge(N sourceNode, N targetNode, E edge);
	
	//REMOVE METHODS
	public abstract boolean removeAllEdges(Collection<? extends E> paramCollection);
	public abstract Set<E> removeAllEdges(N sourceNode, N targetNode);
	public abstract E removeEdge(N sourceNode, N targetNode);
	public abstract boolean removeEdge(E paramE);
	
	//REPLACE METHODS
	public abstract E replaceEdge(E graphEdge, E newEdge);
	
	//EDGE PROPERTIES METHODS
	public abstract N getEdgeSource(E edge);
	public abstract N getEdgeTarget(E edge);
	public abstract N getEdgeOpposite(N node, E edge);
	public abstract double getEdgeWeight(E edge);
}
