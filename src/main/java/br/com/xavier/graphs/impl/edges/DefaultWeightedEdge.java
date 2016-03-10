package br.com.xavier.graphs.impl.edges;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public class DefaultWeightedEdge<N extends AbstractNode, T> extends AbstractWeightedEdge<N,T> {

	private static final long serialVersionUID = 9162141684021577147L;

	public DefaultWeightedEdge(N source, N target, T weight) {
		super(source, target, weight);
	}

	
	@Override
	public DefaultWeightedEdge<N,T> reverse() {
		DefaultWeightedEdge<N,T> reverseEdge = new DefaultWeightedEdge<N,T>(getTarget(), getSource(), getWeight());
		return reverseEdge;
	}

}
