package br.com.xavier.graphs.impl.simple.undirected.matrix;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.simple.undirected.matrix.SimpleUndirectedWeightedAdjacencyMatrixGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class MatrixSUWGraphTest extends SimpleUndirectedWeightedAdjacencyMatrixGraphTest<NumberedNode, DefaultWeightedEdge<NumberedNode, BigDecimal>, BigDecimal> {

	private NumberedNodesFactory nodeFactory;
	
	public MatrixSUWGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected MatrixSUWGraph<NumberedNode, DefaultWeightedEdge<NumberedNode, BigDecimal>, BigDecimal> getGraphInterfaceInstance() {
		return new MatrixSUWGraph<>();
	}
	
	@Override
	protected NumberedNode createNode() {
		return nodeFactory.createNode();
	}

	@Override
	protected DefaultWeightedEdge<NumberedNode, BigDecimal> createEdge(NumberedNode node1, NumberedNode node2) {
		double random = Math.random();
		BigDecimal weight = BigDecimal.valueOf(random);
		
		DefaultWeightedEdge<NumberedNode, BigDecimal> edge = new DefaultWeightedEdge<NumberedNode, BigDecimal>(node1, node2, weight);
		edge.setWeight(weight);
		
		return edge;
	}
}
