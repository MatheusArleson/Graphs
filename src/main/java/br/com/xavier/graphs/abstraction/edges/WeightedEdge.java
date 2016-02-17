package br.com.xavier.graphs.abstraction.edges;

import br.com.xavier.graphs.interfaces.Node;

public abstract class WeightedEdge extends AbstractEdge {

	private static final long serialVersionUID = 8650372471964637852L;

	public WeightedEdge(Node source, Node target, int weight) {
		super(source, target, weight);
	}
}
