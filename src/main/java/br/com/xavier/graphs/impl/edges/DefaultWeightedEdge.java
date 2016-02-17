package br.com.xavier.graphs.impl.edges;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstraction.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.interfaces.Node;

public class DefaultWeightedEdge extends AbstractWeightedEdge {

	private static final long serialVersionUID = 8650372471964637852L;

	public DefaultWeightedEdge(Node source, Node target, BigDecimal weight) {
		super(source, target);
		setWeight(weight);
	}
}
