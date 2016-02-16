package br.com.xavier.graphs.abstraction.edges;

public abstract class UnweightedEdge<N,E> extends AbstractEdge<N, E> {

	private static final long serialVersionUID = -217630814014608015L;

	public UnweightedEdge(N source, N target) {
		super(source, target, 1);
	}
}
