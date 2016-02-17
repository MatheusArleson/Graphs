package br.com.xavier.graphs.abstraction;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.interfaces.Edge;
import br.com.xavier.graphs.interfaces.Node;
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
		Util.handleNullParameter(node);
		return nodesSet.contains(node); 
	}
	
	@Override
	public boolean addNode(Node node) throws NullPointerException {
		Util.handleNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		return nodesSet.add(node);
	}
	
	@Override
	public boolean removeNode(Node node) throws NullPointerException {
		Util.handleNullParameter(node);
		
		if(!containsNode(node)){
			return false;
		}
		
		removeAllEdges(node);
		return nodesSet.remove(node);
	}
	
	//XXX OVERRIDE EDGES METHODS
	
	@Override
	public Set<Edge> getAllEdges() {
		return edgesSet;
	}
	
	@Override
	public boolean containsEdge(Edge edge) throws NullPointerException {
		Util.handleNullParameter(edge);
		return edgesSet.contains(edge);
	}
}
