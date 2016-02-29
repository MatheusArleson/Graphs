package br.com.xavier.graphs.impl.simple.directed;

import br.com.xavier.graphs.abstractions.simple.directed.SimpleDirectedUnweightedGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class DefaultSDUGraphTest extends SimpleDirectedUnweightedGraphTest<NumberedNode, DefaultUnweightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public DefaultSDUGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected DefaultSDUGraph<NumberedNode, DefaultUnweightedEdge<NumberedNode>> getGraphInterfaceInstance() {
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
