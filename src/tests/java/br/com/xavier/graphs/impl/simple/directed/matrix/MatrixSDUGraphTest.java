package br.com.xavier.graphs.impl.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.simple.directed.SimpleDirectedUnweightedGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class MatrixSDUGraphTest extends SimpleDirectedUnweightedGraphTest<NumberedNode, DefaultUnweightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public MatrixSDUGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected MatrixSDUGraph<NumberedNode, DefaultUnweightedEdge<NumberedNode>> getGraphInterfaceInstance() {
		return new MatrixSDUGraph<>();
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
