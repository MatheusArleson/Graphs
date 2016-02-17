package br.com.xavier.graphs.abstraction;

import java.util.Set;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.DirectedGraph;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleDirectedGraph extends SimpleGraph implements DirectedGraph {

	public SimpleDirectedGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory) {
		super(nodeFactory, edgeFactory);
	}
	
	@Override
	public int degreeOf(Node node) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addEdge(Node sourceNode, Node targetNode) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(Edge edge) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int inDegreeOf(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int outDegreeOf(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Edge> incomingEdgesOf(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Edge> outgoingEdgesOf(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean addEdge(Edge edge) {
		// TODO Auto-generated method stub
		return false;
	}

}
