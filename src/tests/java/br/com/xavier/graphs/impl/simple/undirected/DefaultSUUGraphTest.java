package br.com.xavier.graphs.impl.simple.undirected;

import br.com.xavier.graphs.abstractions.simple.undirected.SimpleUndirectedUnweightedGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class DefaultSUUGraphTest extends SimpleUndirectedUnweightedGraphTest<NumberedNode, DefaultUnweightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public DefaultSUUGraphTest() {
		super();
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected DefaultSUUGraph<NumberedNode, DefaultUnweightedEdge<NumberedNode>> getGraphInterfaceInstance() {
		return new DefaultSUUGraph<>();
	}

	@Override
	protected NumberedNode createNode() {
		return nodeFactory.createNode();
	}

	@Override
	protected DefaultUnweightedEdge<NumberedNode> createEdge(NumberedNode node1, NumberedNode node2) {
		DefaultUnweightedEdge<NumberedNode> edge = new DefaultUnweightedEdge<NumberedNode>(node1, node2);
		return edge;
	}
}
