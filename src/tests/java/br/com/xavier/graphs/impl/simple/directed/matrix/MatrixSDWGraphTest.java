package br.com.xavier.graphs.impl.simple.directed.matrix;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.simple.directed.SimpleDirectedUnweightedGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class MatrixSDWGraphTest extends SimpleDirectedUnweightedGraphTest<NumberedNode, DefaultWeightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public MatrixSDWGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected MatrixSDWGraph<NumberedNode, DefaultWeightedEdge<NumberedNode>> getGraphInterfaceInstance() {
		return new MatrixSDWGraph<>();
	}
	
	@Override
	protected NumberedNode createNode() {
		return nodeFactory.createNode();
	}

	@Override
	protected DefaultWeightedEdge<NumberedNode> createEdge(NumberedNode node1, NumberedNode node2) {
		double random = Math.random();
		BigDecimal weight = BigDecimal.valueOf(random);
		
		DefaultWeightedEdge<NumberedNode> edge = new DefaultWeightedEdge<NumberedNode>(node1, node2, weight);
		edge.setWeight(weight);
		
		return edge;
	}
}
