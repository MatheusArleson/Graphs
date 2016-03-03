package br.com.xavier.graphs.impl.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.simple.directed.matrix.SimpleDirectedUnweightedAdjacencyMatrixGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class MatrixSUUGraphTest extends SimpleDirectedUnweightedAdjacencyMatrixGraphTest<NumberedNode, DefaultUnweightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public MatrixSUUGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected MatrixSUUGraph<NumberedNode, DefaultUnweightedEdge<NumberedNode>> getGraphInterfaceInstance() {
		return new MatrixSUUGraph<>();
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
