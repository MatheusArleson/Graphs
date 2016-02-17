package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.UndirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleUndirectedGraph extends SimpleGraph implements UndirectedGraph {

	public SimpleUndirectedGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory) {
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
	protected boolean addEdge(Edge edge) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean removeEdge(Edge edge) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

}
