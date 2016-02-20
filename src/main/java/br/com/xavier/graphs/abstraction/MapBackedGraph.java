package br.com.xavier.graphs.abstraction;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;
import br.com.xavier.graphs.util.messages.Util;

public abstract class MapBackedGraph extends AbstractGraph {
	
	//XXX CLASS PROPERTIES
	private Map<Node, Set<Edge>> graphMap;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Construct a new empty Graph object.
	 * 
	 * @param nodeFactory {@link NodeFactory} - the Node factory of the new graph.
	 * @param edgeFactory {@link EdgeFactory} - the Edge factory of the new graph.
	 * @param isDirected - if the Edges of the Graph are directed; 
	 * @param isWeighted - if the Edges of the Graph are weighted;
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public MapBackedGraph(
		NodeFactory nodeFactory, EdgeFactory edgeFactory, 
		boolean isDirected, boolean isWeighted, 
		boolean loopsAllowed, boolean multipleEdgesAllowed
	) {
		super(nodeFactory, edgeFactory, isDirected, isWeighted, loopsAllowed, multipleEdgesAllowed);
		this.graphMap = new LinkedHashMap<Node, Set<Edge>>();
	}
	
	//XXX OVERRIDE NODES METHODS
	
	@Override
	public Set<Node> getAllNodes() {
		return graphMap.keySet();
	}
	
	@Override
	public boolean containsNode(Node node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		return graphMap.containsKey(node);
	}
	
	@Override
	protected void addNode() throws NullPointerException {
		Node node = fabricateNode();
		graphMap.put(node, new LinkedHashSet<Edge>());
	}
	
	@Override
	public boolean addNode(Node node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		graphMap.put(node, new LinkedHashSet<Edge>());
		return true;
	}
	
	@Override
	public boolean removeNode(Node node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		removeAllEdges(node);
		graphMap.remove(node);
		return true;
	}

	@Override
	public boolean areAdjacents(Node node1, Node node2) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, node1, node2);
		
		return existsEdge(node1, node2);
	}
	
	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public Set<Edge> getAllEdges() {
		Set<Edge> allEdges = new LinkedHashSet<Edge>();
		if(graphMap.isEmpty()){
			return allEdges;
		}
		
		for (Node node : getAllNodes()) {
			Set<Edge> nodeEdgeSet = graphMap.get(node);
			allEdges.addAll(nodeEdgeSet);
		}
		
		return allEdges;
	}
	
	@Override
	public Set<Edge> getAllEdges(Node node) {
		Util.checkIllegalNode(this, node);
		
		Set<Edge> nodeEdgesSet = new LinkedHashSet<Edge>();
		
		for (Edge edge : graphMap.get(node)) {
			if(edge.getSource().equals(node) || edge.getTarget().equals(node)){
				nodeEdgesSet.add(edge);
			}
		}
		
		return nodeEdgesSet;
	}
	
	@Override
	public Set<Edge> getAllEdges(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		if(graphMap.isEmpty()){
			return new LinkedHashSet<Edge>();
		}
		
		if(isDirected()){
			return getAllDirectedEdges(sourceNode, targetNode);
		} else {
			return getAllUndirectedEdges(sourceNode, targetNode);
		}
	}
	
	private Set<Edge> getAllUndirectedEdges(Node sourceNode, Node targetNode) {
		Set<Edge> edges = getAllDirectedEdges(sourceNode, targetNode);
		edges.addAll(getAllEdges(targetNode, sourceNode));
		return edges;
	}

	private Set<Edge> getAllDirectedEdges(Node sourceNode, Node targetNode) {
		Set<Edge> nodeEdgesSet = new LinkedHashSet<Edge>();
		for (Edge edge : graphMap.get(sourceNode)) {
			if(edge.isPath(sourceNode, targetNode)){
				nodeEdgesSet.add(edge);
			}
		}
		
		return nodeEdgesSet;
	}

	@Override
	public boolean existsEdge(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		for (Edge edge : graphMap.get(sourceNode)) {
			if(edge.isPath(sourceNode, targetNode)){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	protected boolean containsEdge(Edge edge) throws NullPointerException {
		Util.checkNullParameter(edge);
		return graphMap.get(edge.getSource()).contains(edge);
	}
	
}
