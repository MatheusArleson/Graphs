package br.com.xavier.graphs.interfaces;

import java.util.Collection;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

/**
 * 
 * The root interface in the Graph hierarchy. </br>
 * </br>
 * 
 * A mathematical graph-theory Graph object G(N,E) contains a set N of Nodes and
 * a set E of Edges. </br>
 * Each Edge E=(n1,n2) in E connects Node n1 to Node n2. </br>
 * </br>
 * Through generics, a Graph can be typed to specific classes for Nodes N and
 * Edges E. </br>
 * Such a Graph can contain Nodes of type N and all sub-types of N; and Edges of
 * type E and all sub-types of E. </br>
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public abstract interface Graph<N, E> {
	
	//XXX FACTORY METHODS
	
	/**
	 * Returns the Node factory using which this Graph creates new Nodes. </br> 
	 * </br>
	 * The Node factory is defined when the Graph is constructed and must not be modified.
	 * 
	 * @return {@link NodeFactory} - The Node factory which this Graph uses to create new Nodes.
	 */
	public abstract NodeFactory<N> getNodeFactory();
	
	
	/**
	 * Returns the Edge factory using which this Graph creates new Edges. </br> 
	 * </br>
	 * The Edge factory is defined when the Graph is constructed and must not be modified.
	 * 
	 * @return {@link EdgeFactory} - The Edge factory which this Graph uses to create new Edges.
	 */
	public abstract EdgeFactory<N, E> getEdgeFactory();

	//------------------------------------------
	// 			NODES METODS
	//------------------------------------------
	
	//XXX LIST NODES METHODS
	
	/**
	 * Return a {@link Set} of all the Nodes of the Graph.
	 * 
	 * @return {@link Set} - all the Nodes of the Graph.
	 */
	public abstract Set<N> getAllNodes();

	//XXX CONTAINS NODES METHODS
	
	/**
	 * Returns true if this Graph contains the specified Node. </br> 
	 * More formally, returns true if and only if this Graph contains a Node n such that n.equals(someNode).</br> 
	 * 
	 * @param node - Node whose presence in this Graph is to be tested.
	 * @return true - if this Graph contains the specified Node; false otherwise.
	 * @throws NullPointerException if Node parameter is null.
	 */
	public abstract boolean containsNode(N node) throws NullPointerException;

	//XXX ADD NODES METHODS
	
	/**
	 * Adds the specified Node to this Graph if not already present. </br>
	 * More formally, adds the specified Node n1 to this graph if this Graph contains no Node n2 such that n2.equals(n1). </br>
	 * </br> 
	 * If this Graph already contains such Node, the call leaves this Graph unchanged and returns false. </br>
	 * In combination with the restriction on constructors, this ensures that graphs never contain duplicate Nodes. </br>
	 * 
	 * @param node - Node to added.
	 * @return true - if this Graph did not already contain the specified Node and the new one is added; false otherwise.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract boolean addNode(N node) throws NullPointerException; 
			
	//XXX REMOVE NODES METHODS
	
	/**
	 * Removes all Nodes contained in the Nodes collection passed. </br> 
	 * This method will invoke the {@link #removeNode(Object)} method.</br>
	 * 
	 * @param nodesCollection - Nodes to be removed from this Graph.
	 * @return true - if this Graph changed as a result of the call; false otherwise.
	 * @throws NullPointerException if the specified Nodes collection is null.
	 */
	public abstract boolean removeAllNodes(Collection<? extends N> nodesCollection) throws NullPointerException;
	
	/**
	 * Removes the specified Node from this Graph including all its Edges if present. </br>
	 * More formally, if the Graph contains a Node n1 such that n1.equals(n2), the call removes all Edges that touch n1 and then removes n1 itself.
	 * If no such n1 is found, the call leaves the Graph unchanged. </br>
	 * </br>
	 * Returns true if the Graph contained the specified Node. </br> 
	 * </br>
	 * The Graph will not contain the specified Node once the call returns.</br>
	 * 
	 * @param node - Node to be removed from this Graph, if present.
	 * @return true - if the Graph contained the specified Node; false otherwise.
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
	 * @throws IllegalNodeException if graphNode is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract N replaceNode(N graphNode, N newNode) throws IllegalNodeException, NullPointerException;
	
	//XXX CHECK NODES METHODS
	
	/**
	 * Check whether nodes n1 and n2 are adjacent.
	 * 
	 * @param n1 - Node of interest.
	 * @param n2 - Node to check adjacency.
	 * @return true if nodes are adjacents; false otherwise.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract boolean areAdjacents(N n1, N n2) throws IllegalNodeException, NullPointerException;
	
	/**
	 * Returns the degree of the specified Node. 
	 * 
	 * @param node - Node whose degree is to be calculated.
	 * @return the degree of the specified Node.
	 * @throws IllegalNodeException if the Node passed is not part of the Graph.
	 * @throws NullPointerException if Node parameter is null.
	 */
	public abstract int degreeOf(N node) throws IllegalNodeException, NullPointerException;
	
	//------------------------------------------
	// 			EDGES METODS
	//------------------------------------------
	
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
	 * @return {@link Set} - a set of the Edges contained in this Graph.
	 */
	public abstract Set<E> getAllEdges();
	
	/**
	 * Return a set of the all Edges wich references the Node passed. </br>
	 * In undirected graphs, some of the returned Edges may have their source and target Nodes in the opposite order. </br>
	 * 
	 * @param node {@link N} - node of interest.
	 * @return {@link Set} - a set of all Edges connected to the node.
	 * @throws IllegalNodeException if the Node passed is not part of the Graph.
	 * @throws NullPointerException if the Node passed is null.
	 */
	public abstract Set<E> getAllEdges(N node);
	
	/**
	 * Returns a set of all Edges connecting source Node to target Node if such Nodes exist in this Graph. </br>
	 * </br>
	 * If both Nodes exist but no Edges found, returns an empty set.</br>
	 * </br>
	 * In undirected graphs, some of the returned Edges may have their source and target Nodes in the opposite order. </br>
	 * In simple Graphs the returned set is either singleton set or empty set.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link Set} - a set of all Edges connecting source Node to target Node.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract Set<E> getAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException;	
	
	/**
	 * Returns an Edge connecting source Node to target Node if such Nodes and such Edge exist in this Graph. Otherwise returns null. </br> 
	 * </br>
	 * In undirected Graphs, the returned Edge may have its source and target Nodes in the opposite order.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link E} - an Edge connecting source Node to target Node.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract E getEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException;
	
	/**
	 * Returns a set of all Edges touching the specified Node. </br> 
	 * If no Edges are touching the specified Node, the method returns an empty set.</br>
	 * 
	 * @param node - the Node for which a set of touching Edges is to be returned.
	 * @return {@link Set} - a set of all Edges touching the specified Node.
	 * @throws IllegalNodeException if Node passed is not part of the Graph.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract Set<E> getEdges(N node) throws IllegalNodeException, NullPointerException;
	
	//TODO javadoc
	public abstract Set<E> getIncidentEdges(N node);

	//XXX CONTAINS EDGES METHODS
	
	/**
	 * Returns true if and only if this Graph contains an Edge going from the source Node to the target Node. </br>
	 * </br> 
	 * In undirected Graphs the same result is obtained when source and target are inverted. </br> 
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return true if this Graph contains the specified Edge; false otherwise.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract boolean containsEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException;
	
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
	 * Creates a new Edge in this Graph, going from the source Node to the target Node, and returns the created Edge. </br>
	 * Graphs does not allow edge-multiplicity. In such cases, if the graph already contains an Edge from the specified Node source to the specified Node target, 
	 * than this method does not change the Graph and returns null. </br>
	 * </br>
	 * The source and target Nodes must already be contained in this Graph. If they are not found in Graph IllegalArgumentException is thrown. </br>
	 * </br>
	 * This method creates the new Edge e using this Graph's {@link EdgeFactory}. </br>
	 * For the new Edge to be added e must not be equal to any other Edge the Graph. More formally, the Graph must not contain any Edge e2 such that e2.equals(e).</br> 
	 * If such e2 is found then the newly created Edge e is abandoned, the method leaves this Graph unchanged returns null.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link E} - the new Edge.
	 * @throws IllegalNodeException if source or target Nodes are not found in the graph.
	 * @throws NullPointerException if any of the passed Nodes is null.
	 * 
	 */
	public abstract E createEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException;
	
	/**
	 * 
	 * Adds the specified Edge to this graph, going from the source Node to the target Node. </br>
	 * More formally, adds the specified Edge e, to this Graph if this Graph contains no edge e2 such that e2.equals(e). </br>
	 * If this Graph already contains such an Edge, the call leaves this Graph unchanged and returns false. </br>
	 * </br>
	 * Graphs does not allow edge-multiplicity. In such cases, if the Graph already contains an Edge from the specified source Node to the specified target Node, 
	 * than this method does not change the Graph and returns false. </br>
	 * If the Edge was added to the Graph, returns true.
	 * </br>
	 * The source and target Nodes must already be contained in this graph. </br>
	 * If they are not found in graph IllegalArgumentException is thrown.</br>
	 * 
	 * @param sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @param {@link E} - Edge to be added to this Graph.
	 * @return {@link E} - the new Edge.
	 * @throws IllegalNodeException if source or target Nodes are not found in the graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract boolean addEdge(N sourceNode, N targetNode, E edge) throws IllegalNodeException, NullPointerException;
	
	//XXX REMOVE EDGES METHODS
	
	/**
	 * Removes all Edges contained in the Edges collection passed. </br> 
	 * This method will invoke the {@link #removeEdge(Object)} method.</br>
	 * 
	 * @param edgesCollection - Edges to be removed from this Graph.
	 * @return true - if this Graph changed as a result of the call; false otherwise.
	 * @throws NullPointerException if the specified Edges collection is null.
	 */
	public abstract boolean removeAllEdges(Collection<? extends E> edgesCollection) throws NullPointerException;
	
	/**
	 * Removes all the Edges going from the specified source Node to the specified target Node, and returns a set of all removed Edges. </br> 
	 * If both Nodes exist but no Edge is found, returns an empty set. </br> 
	 * This method will either invoke the {@link #removeEdge(Object)} method, or the {@link #removeEdge(Object, Object))} method. </br>
	 * 
	 * @param  sourceNode - source Node of the Edge.
	 * @param targetNode - target Node of the Edge.
	 * @return {@link Set} containing the removed Edges.
	 * @throws IllegalNodeException if source or target Nodes are not found in the graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract Set<E> removeAllEdges(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException;
	
	/**
	 * Removes all the Edges related to the Node passed.
	 * 
	 * @param node {@link N} - the node of interest.
	 * @return true if node was removed; false otherwise.
	 */
	public abstract boolean removeAllEdges(N node);
	
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
	 * More formally, removes an Edge e1 such that e1.equals(e2), if the Graph contains such Edge. </br> 
	 * </br>
	 * Returns true if the graph contained the specified edge. </br>
	 * </br> 
	 * The Graph will not contain the specified Edge once the call returns. </br>
	 * 
	 * @param edge - Edge to be removed from this Graph, if present.
	 * @return true if and only if the Graph contained the specified Edge and it is removed in the call.
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
	 * @throws IllegalNodeException if graphEdge is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract E replaceEdge(E graphEdge, E newEdge) throws IllegalNodeException, NullPointerException;
	
	//XXX EDGE PROPERTIES METHODS
	
	/**
	 * Returns the source Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - source Node.
	 * @throws NullPointerException if Edge parameter is null.
	 * 
	 */
	public abstract N getEdgeSource(E edge) throws NullPointerException;
	
	/**
	 * Returns the target Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
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
	 * - e is not an Edge of Node n.
	 * - e is not incident on Node n.
	 * 
	 * @param node - Node of interest.
	 * @param edge - Edge of interest.
	 * @return {@link N} - opposite node of the Edge.
	 */
	public abstract N getEdgeOpposite(N node, E edge);
	
	/**
	 * Returns the weight assigned to a given Edge. </br> 
	 * Unweighted Graphs return 1.0; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - target Node.
	 * @throws NullPointerException if Edge parameter is null.
	 */
	public abstract double getEdgeWeight(E edge) throws NullPointerException;
}
