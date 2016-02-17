package br.com.xavier.graphs.abstraction.edges;

import br.com.xavier.graphs.interfaces.Node;

public abstract class UnweightedEdge extends AbstractEdge {

	private static final long serialVersionUID = -217630814014608015L;

	public UnweightedEdge(Node source, Node target) {
		super(source, target, 1);
	}
}
