package br.com.xavier.graphs.impl.simple.undirected;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.simple.undirected.SimpleUndirectedWeightedGraphTest;
import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;

public class DefaultSUWGraphTest extends SimpleUndirectedWeightedGraphTest<NumberedNode, DefaultWeightedEdge<NumberedNode>> {

	private NumberedNodesFactory nodeFactory;
	
	public DefaultSUWGraphTest() {
		this.nodeFactory = new NumberedNodesFactory();
	}
	
	@Override
	protected DefaultSUWGraph<NumberedNode, DefaultWeightedEdge<NumberedNode>> getGraphInterfaceInstance() {
		return new DefaultSUWGraph<>();
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
