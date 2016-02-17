package br.com.xavier.graphs.interfaces;

import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;

/**
 * 
 * The root interface in the Graph hierarchy. </br>
 * </br>
 * 
 * A mathematical graph-theory Graph object G(Node,E) contains a set N of Nodes and
 * a set E of Edges. </br>
 * Each Edge E=(Node1,n2) in E connects Node n1 to Node n2. </br>
 * </br>
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public abstract interface Graph {
	
	//------------------------------------------
	// 			NODES METODS
	//------------------------------------------
	
	//XXX LIST NODES METHODS
	
	/**
	 * Return a {@link Set} of all the Nodes of the Graph.
	 * 
	 * @return {@link Set} - all the Nodes of the Graph.
	 */
	public abstract Set<Node> getAllNodes();

	//XXX CONTAINS NODES METHODS
	
	/**
	 * Returns true if this Graph contains the specified Node. </br> 
	 * More formally, returns true if and only if this Graph contains a Node n such that n.equals(someNode).</br> 
	 * 
	 * @param node {@link Node} - Node whose presence in this Graph is to be tested.
	 * @return true - if this Graph contains the specified Node; false otherwise.
	 * @throws NullPointerException if Node parameter is null.
	 */
	public abstract boolean containsNode(Node node) throws NullPointerException;
	
	//XXX ADD NODES METHODS
	
	/**
	 * Adds the specified Node to this Graph if not already present. </br>
	 * More formally, adds the specified Node n1 to this graph if this Graph contains no Node n2 such that n2.equals(Node1). </br>
	 * </br> 
	 * If this Graph already contains such Node, the call leaves this Graph unchanged and returns false. </br>
	 * In combination with the restriction on constructors, this ensures that graphs never contain duplicate Nodes. </br>
	 * 
	 * @param node {@link Node} - Node to added.
	 * @return true - if this Graph did not already contain the specified Node and the new one is added; false otherwise.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract boolean addNode(Node node) throws NullPointerException; 
			
	//XXX REMOVE NODES METHODS
	
	/**
	 * Removes all Nodes contained in the Nodes collection passed that are present in the Graph. </br>
	 * If a passed Node is not present it will be removed from the collection passed. </br> 
	 * This method will invoke the {@link #removeNode(Object)} method.</br>
	 * 
	 * @param nodesSet - Nodes to be removed from this Graph.
	 * @return true - if this Graph changed as a result of the call; false otherwise.
	 * @throws NullPointerException if the specified Nodes collection is null.
	 */
	public abstract boolean removeAllNodes(Set<Node> nodesSet) throws NullPointerException;
	
	/**
	 * Removes the specified Node from this Graph including all its Edges if present. </br>
	 * More formally, if the Graph contains a Node n1 such that n1.equals(Node2), the call removes all Edges that touch n1 and then removes n1 itself.
	 * If no such n1 is found, the call leaves the Graph unchanged. </br>
	 * </br>
	 * Returns true if the Graph contained the specified Node. </br> 
	 * </br>
	 * The Graph will not contain the specified Node once the call returns.</br>
	 * 
	 * @param node {@link Node} - Node to be removed from this Graph, if present.
	 * @return true - if the Graph contained the specified Node; false otherwise.
	 * @throws NullPointerException if Node passed is null.
	 */
	public abstract boolean removeNode(Node node) throws NullPointerException;
	
	//XXX REPLACE NODES METHODS
	
	/**
	 * Replace an Node with a new one.
	 * 
	 * @param graphNode {@link Node} - Node of interest.
	 * @param newNode {@link Node} - Node replacement.
	 * @return {@link N} - the previous Node.
	 * @throws IllegalNodeException if graphNode is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract Node replaceNode(Node graphNode, Node newNode) throws IllegalNodeException, NullPointerException;
	
	//XXX CHECK NODES METHODS
	
	/**
	 * Check whether nodes n1 and n2 are adjacent.
	 * 
	 * @param n1 {@link Node} - Node of interest.
	 * @param n2 {@link Node} - Node to check adjacency.
	 * @return true if nodes are adjacents; false otherwise.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract boolean areAdjacents(Node node1, Node node2) throws IllegalNodeException, NullPointerException;
	
	/**
	 * Returns the degree of the specified Node. 
	 * 
	 * @param node {@link Node} - Node whose degree is to be calculated.
	 * @return the degree of the specified Node.
	 * @throws IllegalNodeException if the Node passed is not part of the Graph.
	 * @throws NullPointerException if Node parameter is null.
	 */
	public abstract int degreeOf(Node node) throws IllegalNodeException, NullPointerException;
	
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
	public abstract Set<Edge> getAllEdges();
	
	/**
	 * Return a set of the all Edges wich references the Node passed. </br>
	 * In undirected graphs, some of the returned Edges may have their source and target Nodes in the opposite order. </br>
	 * 
	 * @param node {@link N} - node of interest.
	 * @return {@link Set} - a set of all Edges connected to the node.
	 * @throws IllegalNodeException if the Node passed is not part of the Graph.
	 * @throws NullPointerException if the Node passed is null.
	 */
	public abstract Set<Edge> getAllEdges(Node node);
	
	/**
	 * Returns a set of all Edges connecting source Node to target Node if such Nodes exist in this Graph. </br>
	 * </br>
	 * If both Nodes exist but no Edges found, returns an empty set.</br>
	 * </br>
	 * In undirected graphs, some of the returned Edges may have their source and target Nodes in the opposite order. </br>
	 * In simple Graphs the returned set is either singleton set or empty set.</br>
	 * 
	 * @param sourceNode {@link Node} - source Node of the Edge.
	 * @param targetNode {@link Node} - target Node of the Edge.
	 * @return {@link Set} - a set of all Edges connecting source Node to target Node.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract Set<Edge> getAllEdges(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException;	
	
	//XXX CONTAINS EDGES METHODS
	
	/**
	 * Returns true if and only if this Graph contains an Edge going from the source Node to the target Node. </br>
	 * </br> 
	 * In undirected Graphs the same result is obtained when source and target are inverted. </br> 
	 * 
	 * @param sourceNode {@link Node} - source Node of the Edge.
	 * @param targetNode {@link Node} - target Node of the Edge.
	 * @return true if this Graph contains the specified Edge; false otherwise.
	 * @throws IllegalNodeException if any Node passed is not part of the Graph.
	 * @throws NullPointerException if any Node passed is null.
	 */
	public abstract boolean existsEdge(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException;
	
	//XXX ADD EDGES METHODS
	
	/**
	 * Fabricates a new Edge going from the source Node to the target Node and add it to the Graph. </br>
	 * More formally, adds the specified Edge e, to this Graph if this Graph contains no edge e2 such that e2.equals(e). </br>
	 * If this Graph already contains such an Edge, the call leaves this Graph unchanged and returns false. </br>
	 * </br>
	 * Graphs may not allow edge-multiplicity. In such cases, if the Graph already contains an Edge from the specified source Node to the specified target Node, 
	 * than this method does not change the Graph and returns false. </br>
	 * If the Edge was added to the Graph, returns true.
	 * </br>
	 * The source and target Nodes must already be contained in this graph. </br>
	 * If they are not found in graph IllegalNodeException is thrown.</br>
	 * 
	 * @param sourceNode {@link Node} - source Node of the Edge.
	 * @param targetNode {@link Node} - target Node of the Edge.
	 * @return {@link E} - the new Edge.
	 * @throws IllegalNodeException if source or target Nodes are not found in the graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract boolean addEdge(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException;
	
	//XXX REMOVE EDGES METHODS
	
	/**
	 * Removes all Edges contained in the Edges collection passed. </br> 
	 * This method will invoke the {@link #removeEdge(Object)} method.</br>
	 * 
	 * @param edgesSet {@link Set} - Edges to be removed from this Graph.
	 * @return true - if this Graph changed as a result of the call; false otherwise.
	 * @throws NullPointerException if the specified Edges collection is null.
	 */
	public abstract boolean removeAllEdges(Set<Edge> edgesSet) throws NullPointerException;
	
	/**
	 * Removes all the Edges going from the specified source Node to the specified target Node, and returns a set of all removed Edges. </br> 
	 * If both Nodes exist but no Edge is found, returns an empty set. </br> 
	 * This method will either invoke the {@link #removeEdge(Object)} method, or the {@link #removeEdge(Object, Object))} method. </br>
	 * 
	 * @param sourceNode {@link Node} - source Node of the Edge.
	 * @param targetNode {@link Node} - target Node of the Edge.
	 * @return {@link Set} containing the removed Edges.
	 * @throws IllegalNodeException if source or target Nodes are not found in the graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract Set<Edge> removeAllEdges(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException;
	
	/**
	 * Removes all the Edges related to the Node passed.
	 * 
	 * @param node {@link Node} - the node of interest.
	 * @return {@link Set} - containing the removed Edges.
	 */
	public abstract Set<Edge> removeAllEdges(Node node);
	
	/**
	 * Removes the specified Edge from the Graph if it is present. </br> 
	 * More formally, removes an Edge e1 such that e1.equals(e2), if the Graph contains such Edge. </br> 
	 * </br>
	 * Returns true if the graph contained the specified edge. </br>
	 * </br> 
	 * The Graph will not contain the specified Edge once the call returns. </br>
	 * 
	 * @param edge {@link Edge} - Edge to be removed from this Graph, if present.
	 * @return true if and only if the Graph contained the specified Edge and it is removed in the call.
	 * @throws NullPointerException if Edge parameter is null.
	 */
	public abstract boolean removeEdge(Edge edge) throws NullPointerException;
	
	//XXX REPLACE EDGES METHODS
	
	/**
	 * Replace an Edge with a new one.
	 * 
	 * @param graphEdge {@link Edge} - Edge of interest.
	 * @param newEdge {@link Edge} - Edge replacement.
	 * @return {@link Edge} - the previous Edge.
	 * @throws IllegalNodeException if graphEdge is not part of the Graph.
	 * @throws NullPointerException if any parameter is null.
	 */
	public abstract Edge replaceEdge(Edge graphEdge, Edge newEdge) throws IllegalNodeException, NullPointerException;
	
}
