package br.com.xavier.graphs.impl.edges;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public class DefaultWeightedEdge<N extends AbstractNode> extends AbstractWeightedEdge<N> {

	private static final long serialVersionUID = 9162141684021577147L;

	public DefaultWeightedEdge(N source, N target, BigDecimal weight) {
		super(source, target, weight);
	}

}
