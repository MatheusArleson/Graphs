package br.com.xavier.graphs.impl.simple.directed;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.simple.directed.SimpleDirectedWeightedGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class DefaultSDWGraphTest extends SimpleDirectedWeightedGraphTest<NumberedNode, DefaultWeightedEdge<NumberedNode>> {
	
	private NumberedNodesFactory nodeFactory;
	
	public DefaultSDWGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected DefaultSDWGraph<NumberedNode, DefaultWeightedEdge<NumberedNode>> getGraphInterfaceInstance() {
		return new DefaultSDWGraph<>();
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