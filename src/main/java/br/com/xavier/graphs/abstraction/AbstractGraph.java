package br.com.xavier.graphs.abstraction;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;
import br.com.xavier.graphs.util.messages.Util;

/**
 * A skeletal implementation of the Graph interface, to minimize the effort required to implement Graph interfaces. </br>
 * This implementation is applicable to both: directed graphs and undirected graphs.</br>
 * 
 * @author Matheus Xavier
 *
 */
public abstract class AbstractGraph implements Graph {
	
	//XXX CLASS PROPERTIES
	private final NodeFactory nodeFactory;
	private final EdgeFactory edgeFactory;
	
	private final boolean loopsAllowed;
	private final boolean multipleEdgesAllowed;
	
	//XXX CONSTRUCTOR
	/**
	 * Construct a new empty Graph object.
	 * 
	 * @param nodeFactory {@link NodeFactory} - the Node factory of the new graph.
	 * @param edgeFactory {@link EdgeFactory} - the Edge factory of the new graph.
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public AbstractGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super();
		this.nodeFactory = nodeFactory;
		this.edgeFactory = edgeFactory;
		this.loopsAllowed = loopsAllowed;
		this.multipleEdgesAllowed = multipleEdgesAllowed;
	}
	
	//XXX OVERRIDE NODES METHODS
	
	@Override
	public boolean removeAllNodes(Set<Node> nodesSet) throws NullPointerException {
		Util.checkNullParameter(nodesSet);

		boolean modified = false;
		Set<Node> invalidNodesSet = new LinkedHashSet<Node>();
		
		for (Node node : nodesSet) {
			if(!containsNode(node)){
				invalidNodesSet.add(node);
				continue;
			}
			
			modified |= removeNode(node);
		}

		nodesSet.removeAll(invalidNodesSet);
		return modified;
	}

	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public boolean removeAllEdges(Set<Edge> edgesSet) throws NullPointerException {
		Util.checkNullParameter(edgesSet);
		
		boolean modified = false;
		Set<Edge> invalidEdges = new LinkedHashSet<Edge>();
		
		for (Edge edge: edgesSet) {
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
	public Set<Edge> removeAllEdges(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(sourceNode, targetNode);
		
		Set<Edge> allEdges = getAllEdges(sourceNode, targetNode);
		if (allEdges == null || allEdges.isEmpty()) {
			return new LinkedHashSet<Edge>();
		}
		
		removeAllEdges(allEdges);
		return allEdges;
	}
	
	@Override
	public Set<Edge> removeAllEdges(Node node) {
		Util.checkNullParameter(node);
		
		Set<Edge> allEdges = getAllEdges(node);
		if (allEdges == null || allEdges.isEmpty()) {
			return new LinkedHashSet<Edge>();
		}
		
		removeAllEdges(allEdges);
		return allEdges;
	}
	
	//XXX ABSTRACT METHODS
	
	/**
	 * Adds a new Node to this Graph. </br>
	 * 
	 * @return true - if is added; false otherwise.
	 */
	protected abstract boolean addNode(); 
	
	/**
	 * Adds a new Edge to this Graph. </br>
	 * 
	 * @return true - if is added; false otherwise.
	 */
	protected abstract boolean addEdge(Edge edge); 
	
	/**
	 * Returns true if this Graph contains the specified Edge. </br>
	 * More formally, returns true if and only if this Graph contains an Edge e1 such that e1.equals(e2). </br> 
	 * 
	 * @param edge {@link Edge}- Edge whose presence in this Graph is to be tested.
	 * @return true if this Graph contains the specified Edge; false otherwise.
	 * @throws NullPointerException if Edge passed is null.
	 */
	protected abstract boolean containsEdge(Edge edge) throws NullPointerException;
	
	//XXX FACTORY METHODS
	
	/**
	 * Uses the {@link NodeFactory} to generate a Node.
	 * 
	 * @return {@link Node} - the generated Node
	 */
	protected Node fabricateNode() {
		return nodeFactory.createNode();
	}
	
	/**
	 * Creates a new Edge in this Graph, going from the source Node to the target Node, and returns the created Edge. </br>
	 * Graphs may not allow edge-multiplicity. In such cases, if the graph already contains an Edge from the specified Node source to the specified Node target, 
	 * than this method does not change the Graph and returns null. </br>
	 * </br>
	 * The source and target Nodes must already be contained in this Graph. If they are not found in Graph IllegalNodeException is thrown. </br>
	 * </br>
	 * This method creates the new Edge e using this Graph's {@link EdgeFactory}. </br>
	 * For the new Edge to be added e must not be equal to any other Edge the Graph. More formally, the Graph must not contain any Edge e2 such that e2.equals(e).</br> 
	 * If such e2 is found then the newly created Edge e is abandoned, the method leaves this Graph unchanged returns null.</br>
	 * 
	 * @param sourceNode {@link Node} - source Node of the Edge.
	 * @param targetNode {@link Node} - target Node of the Edge.
	 * @return {@link E} - the new Edge.
	 * @throws IllegalNodeException if source or target Nodes are not found in the graph.
	 * @throws NullPointerException if any of the passed Nodes is null.
	 * 
	 */
	protected Edge fabricateEdge(Node sourceNode, Node targetNode, BigDecimal weight) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		Edge edge = edgeFactory.createEdge(sourceNode, targetNode, weight);
		if(!containsEdge(edge)){
			return edge;
		} else {
			//is a loop?
			if(sourceNode.equals(targetNode) && !loopsAllowed){
				return null;
			}
			
			//is a multiple edge.
			if(!multipleEdgesAllowed){
				return null;
			}
			
			return edge;
		}
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
