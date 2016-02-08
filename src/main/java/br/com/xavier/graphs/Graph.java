package br.com.xavier.graphs;

import java.util.Collection;
import java.util.Set;

//FIXME TODO IllegalArgument Exceptions on methods that depends that a parameter exists on the Graph 
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

	//XXX LIST NODES METHODS
	
	/**
	 * Return a {@link Set} of all the Nodes of the Graph.
	 * 
	 * @return {@link Set} - all the Nodes of the Graph.
	 */
	public abstract Set<N> getAllNodes();

	//XXX CONTAINS NODES METHODS
	
	/**
	 * Returns true if this graph contains the specified Node. </br> 
	 * More formally, returns true if and only if this graph contains a Node n such that n.equals(someNode).</br> 
	 * 
	 * @param node - Node whose presence in this graph is to be tested.
	 * @return true - if this graph contains the specified vertex; false otherwise.
	 * @throws NullPointerException if Node parameter is null.
	 */
	public abstract boolean containsNode(N node) throws NullPointerException;

	//XXX ADD NODES METHODS
	
	/**
	 * Adds the specified Node to this Graph if not already present. </br>
	 * More formally, adds the specified Node n1 to this graph if this graph contains no Node n2 such that n2.equals(n1). </br>
	 * </br> 
	 * If this Graph already contains such Node, the call leaves this Graph unchanged and returns false. </br>
	 * In combination with the restriction on constructors, this ensures that graphs never contain duplicate vertices. </br>
	 * 
	 * @param node - Node to added.
	 * @return true - if this Graph did not already contain the specified Node; false otherwise.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract boolean addNode(N node) throws NullPointerException; 
			
	//XXX REMOVE NODES METHODS
	
	/**
	 * Removes all Nodes contained in the Nodes collection passed. </br> 
	 * This method will invoke the removeNode(N Node) method.</br>
	 * 
	 * @param nodesCollection - Nodes to be removed from this Graph.
	 * @return true - if this Graph changed as a result of the call; false otherwise.
	 * @throws NullPointerException if the specified Nodes collection is null.
	 */
	public abstract boolean removeAllNodes(Collection<? extends N> nodesCollection) throws NullPointerException;
	
	/**
	 * Removes the specified Node from this Graph including all its touching edges if present. </br>
	 * More formally, if the Graph contains a Node n1 such that n1.equals(n2), the call removes all edges that touch n1 and then removes n1 itself.
	 * If no such n1 is found, the call leaves the graph unchanged. </br>
	 * </br>
	 * Returns true if the Graph contained the specified Node. </br> 
	 * </br>
	 * The graph will not contain the specified Node once the call returns.</br>
	 * 
	 * @param node - Node to be removed from this Graph, if present.
	 * @return true -  if the Graph contained the specified Node; false otherwise.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract boolean removeNode(N node) throws NullPointerException;
	
	//XXX REPLACE NODES METHODS
	
	/**
	 * Replace an Node with a new one.
	 * 
	 * @param graphNode - Node of interest.
	 * @param newNode - Node replacement.
	 * @return {@link N} - the previous Node.
	 * @throws IllegalArgumentException if graphNode is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract N replaceNode(N graphNode, N newNode) throws IllegalArgumentException, NullPointerException;
	
	//XXX CHECK NODES METHODS
	
	/**
	 * Check whether nodes n1 and n2 are adjacent.
	 * 
	 * @param n1 - Node of interest.
	 * @param n2 - Node to check adjacency.
	 * @return true if nodes are adjacents; false otherwise.
	 */
	public abstract boolean areAdjacents(N n1, N n2);
	
	//XXX LIST EDGES METHODS
	
	/**
	 * Returns a set of the Edges contained in this Graph. </br>
	 * </br>
	 * The set is backed by the Graph, so changes to the Graph are reflected in the set. </br>
	 * If the Graph is modified while an iteration over the set is in progress, the results of the iteration are undefined.</br>
	 * </br>
	 * The Graph implementation may maintain a particular set ordering (e.g. via LinkedHashSet) for deterministic iteration, but this is not required. </br>
	 * It is the responsibility of callers who rely on this behavior to only use graph implementations which support it.</br>
	 * 
	 * @return {@link Set} - a set of the edges contained in this graph.
	 */
	public abstract Set<E> getAllEdges();
	
	/**
	 * Returns a set of all Edges connecting source Node to target Node if such vertices exist in this graph. </br>
	 * </br>
	 * If any of the Nodes does not exist or is null, returns null. </br>
	 * If both Nodes exist but no Edges found, returns an empty set.</br>
	 * </br>
	 * In undirected graphs, some of the returned Edges may have their source and target Nodes in the opposite order. </br>
	 * In simple Graphs the returned set is either singleton set or empty set.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link Set} - a set of all Edges connecting source Node to target Node.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract Set<E> getAllEdges(N sourceNode, N targetNode) throws NullPointerException;	
	
	/**
	 * Returns an Edge connecting source Node to target Node if such Nodes and such Edge exist in this Graph. Otherwise returns null. </br> 
	 * </br>
	 * In undirected Graphs, the returned Wdge may have its source and target Nodes in the opposite order.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link E} - an Edge connecting source Node to target Node.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract E getEdge(N sourceNode, N targetNode) throws NullPointerException;
	
	/**
	 * Returns a set of all Edges touching the specified Node. </br> 
	 * If no Edges are touching the specified Node, the method returns an empty set.</br>
	 * 
	 * @param node - the Node for which a set of touching Edges is to be returned.
	 * @return {@link Set} - a set of all edges touching the specified vertex.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract Set<E> getEdges(N node) throws NullPointerException;
	
	//TODO javadoc
	public abstract Set<E> getIncidentEdges(N node);

	//XXX CONTAINS EDGES METHODS
	
	/**
	 * Returns true if and only if this Graph contains an Edge going from the source Node to the target Node. </br>
	 * </br> 
	 * In undirected Graphs the same result is obtained when source and target are inverted. </br> 
	 * If any of the specified Nodes does not exist in the graph, returns false. </br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return true if this Graph contains the specified Edge; false otherwise.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract boolean containsEdge(N sourceNode, N targetNode) throws NullPointerException;
	
	/**
	 * Returns true if this Graph contains the specified Edge. </br>
	 * More formally, returns true if and only if this Graph contains an Edge e1 such that e1.equals(e2). </br> 
	 * 
	 * @param edge - Edge whose presence in this Graph is to be tested.
	 * @return true if this Graph contains the specified Edge; false otherwise.
	 * @throws NullPointerException if Edge passed is null.
	 */
	public abstract boolean containsEdge(E edge) throws NullPointerException;
	
	//XXX ADD EDGES METHODS
	
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
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link E} - the new Edge.
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
	 * @return {@link E} - the new Edge.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract boolean addEdge(N sourceNode, N targetNode, E edge) throws NullPointerException;
	
	//XXX REMOVE EDGES METHODS
	
	/**
	 * Removes all Edges contained in the Edges collection passed. </br> 
	 * This method will invoke the removeEdge(E edge) method.</br>
	 * 
	 * @param edgesCollection - Edges to be removed from this Graph.
	 * @return true - if this Graph changed as a result of the call; false otherwise.
	 * @throws NullPointerException if the specified Edges collection is null.
	 */
	public abstract boolean removeAllEdges(Collection<? extends E> edgesCollection) throws NullPointerException;
	
	/**
	 * Removes all the edges going from the specified source Node to the specified target Node, and returns a set of all removed Edges. </br> 
	 * If both vertices exist but no edge is found, returns an empty set. </br> 
	 * This method will either invoke the removeEdge(Object) method, or the removeEdge(Object, Object) method. </br>
	 * 
	 * @param  sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link Set} containing the removed Edges.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract Set<E> removeAllEdges(N sourceNode, N targetNode) throws NullPointerException;
	
	/**
	 * Removes an edge going from source Node to target Node, if such Nodes and such Edge exist in this graph. </br> 
	 * Returns the Edge if removed or null otherwise. </br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link E} - the removed Edge or null otherwise. 
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract E removeEdge(N sourceNode, N targetNode) throws NullPointerException;
	
	/**
	 * Removes the specified Edge from the Graph if it is present. </br> 
	 * More formally, removes an edge e1 such that e1.equals(e2), if the Graph contains such Edge. </br> 
	 * </br>
	 * Returns true if the graph contained the specified edge. </br>
	 * </br> 
	 * The graph will not contain the specified edge once the call returns. </br>
	 * 
	 * @param edge - Edge to be removed from this Graph, if present.
	 * @return true if and only if the Graph contained the specified Edge.
	 * @throws NullPointerException if Edge parameter is null.
	 */
	public abstract boolean removeEdge(E edge) throws NullPointerException;
	
	//XXX REPLACE EDGES METHODS
	
	/**
	 * Replace an Edge with a new one.
	 * 
	 * @param graphEdge - Edge of interest.
	 * @param newEdge - Edge replacement.
	 * @return {@link E} - the previous Edge.
	 * @throws IllegalArgumentException if graphEdge is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract E replaceEdge(E graphEdge, E newEdge) throws IllegalArgumentException, NullPointerException;
	
	//XXX EDGE PROPERTIES METHODS
	
	/**
	 * Returns the source vertex of an edge. </br> 
	 * For an undirected graph, source and target are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - source Node.
	 * @throws NullPointerException if Edge parameter is null.
	 * 
	 */
	public abstract N getEdgeSource(E edge) throws NullPointerException;
	
	/**
	 * Returns the target vertex of an edge. </br> 
	 * For an undirected graph, source and target are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - target Node.
	 * @throws NullPointerException if Edge parameter is null.
	 * 
	 */
	public abstract N getEdgeTarget(E edge);
	
	/**
	 * Return the targetNode of an Edge e distinct from Node n. 
	 * An error occurs if:
	 * - e is not an Edge of n.
	 * - e is not incident on n.
	 * 
	 * @param node - Node of interest.
	 * @param edge - Edge of interest.
	 * @return {@link N} - opposite node of the Edge.
	 */
	public abstract N getEdgeOpposite(N node, E edge);
	
	/**
	 * Returns the weight assigned to a given Edge. </br> 
	 * Unweighted graphs return 1.0; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - target Node.
	 * @throws NullPointerException if Edge parameter is null.
	 */
	public abstract double getEdgeWeight(E edge) throws NullPointerException;
}
