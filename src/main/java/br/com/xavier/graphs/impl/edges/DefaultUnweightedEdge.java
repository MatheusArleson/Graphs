package br.com.xavier.graphs.impl.edges;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public class DefaultUnweightedEdge<N extends AbstractNode> extends AbstractEdge<N>{

	private static final long serialVersionUID = 839863519139529651L;

	public DefaultUnweightedEdge(N source, N target) {
		super(source, target);
	}

	
	@Override
	public DefaultUnweightedEdge<N> reverse() {
		DefaultUnweightedEdge<N> reverseEdge = new DefaultUnweightedEdge<N>(getTarget(), getSource());
		return reverseEdge;
	}

}
