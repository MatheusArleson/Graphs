package br.com.xavier.graphs.abstraction;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;
import br.com.xavier.graphs.util.messages.Util;

public abstract class SetBackedGraph extends AbstractGraph {
	
	//XXX CLASS PROPERTIES
	private Set<Node> nodesSet;
	private Set<Edge> edgesSet;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Construct a new Graph object that is backed by {@link Set}.
	 * 
	 * @param nodeFactory {@link NodeFactory} - the Node factory of the new graph.
	 * @param edgeFactory {@link EdgeFactory} - the Edge factory of the new graph.
	 * @param loopsAllowed - whether to allow Edges that are self-loops or not.
	 * @param multipleEdgesAllowed - whether to allow existence of multiple - (equivalent) Edges - or not.
	 */
	public SetBackedGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super(nodeFactory, edgeFactory, loopsAllowed, multipleEdgesAllowed);
		
		this.nodesSet = new LinkedHashSet<Node>();
		this.edgesSet = new LinkedHashSet<Edge>();
	}
	
	//XXX OVERRIDE NODES METHODS
	
	@Override
	public Set<Node> getAllNodes() {
		return nodesSet;
	}
	
	@Override
	public boolean containsNode(Node node) throws NullPointerException {
		Util.checkNullParameter(node);
		return nodesSet.contains(node); 
	}
	
	@Override
	protected boolean addNode() throws NullPointerException {
		Node node = fabricateNode();
		return nodesSet.add(node);
	}
	
	@Override
	public boolean addNode(Node node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		return nodesSet.add(node);
	}
	
	@Override
	public boolean removeNode(Node node) throws NullPointerException {
		Util.checkNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		removeAllEdges(node);
		return nodesSet.remove(node);
	}

	@Override
	public boolean areAdjacents(Node node1, Node node2) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, node1, node2);
		
		return existsEdge(node1, node2);
	}
	
	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public Set<Edge> getAllEdges() {
		return edgesSet;
	}
	
	@Override
	public Set<Edge> getAllEdges(Node node) {
		Util.checkIllegalNode(this, node);
		
		Set<Edge> nodeEdgesSet = new LinkedHashSet<Edge>();
		
		for (Edge edge : edgesSet) {
			if(edge.getSource().equals(node) || edge.getTarget().equals(node)){
				nodeEdgesSet.add(edge);
			}
		}
		
		return nodeEdgesSet;
	}
	
	@Override
	public Set<Edge> getAllEdges(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		Set<Edge> nodeEdgesSet = new LinkedHashSet<Edge>();
		
		for (Edge edge : edgesSet) {
			if(edge.getSource().equals(sourceNode) || edge.getTarget().equals(targetNode)){
				nodeEdgesSet.add(edge);
			}
		}
		
		return nodeEdgesSet;
	}
	
	@Override
	public boolean existsEdge(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		for (Edge edge : edgesSet) {
			if(edge.getSource().equals(sourceNode) || edge.getTarget().equals(targetNode)){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	protected boolean containsEdge(Edge edge) throws NullPointerException {
		Util.checkNullParameter(edge);
		return edgesSet.contains(edge);
	}
	
}
