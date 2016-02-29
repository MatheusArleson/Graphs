package br.com.xavier.graphs.impl.simple.directed;

import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;
import br.com.xavier.graphs.impl.simple.GraphInterfaceTest;
import br.com.xavier.graphs.interfaces.Graph;

public class DefaultSDUGraphTest extends GraphInterfaceTest<NumberedNode, DefaultUnweightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public DefaultSDUGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected Graph<NumberedNode, DefaultUnweightedEdge<NumberedNode>> createGraphInstance() {
		return new DefaultSDUGraph<>();
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
