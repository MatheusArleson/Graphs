package br.com.xavier.graphs.abstraction.edges;

public abstract class WeightedEdge<N,E> extends AbstractEdge<N, E> {

	private static final long serialVersionUID = 8650372471964637852L;

	public WeightedEdge(N source, N target, int weight) {
		super(source, target, weight);
	}
}
