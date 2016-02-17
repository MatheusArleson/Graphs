package br.com.xavier.graphs.abstraction.edges;

import java.math.BigDecimal;

import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.WeightedEdge;
import br.com.xavier.graphs.util.messages.Util;

public class AbstractWeightedEdge extends AbstractEdge implements WeightedEdge {

	private static final long serialVersionUID = -3427314770841219944L;
	
	private BigDecimal weight;
	
	public AbstractWeightedEdge(Node source, Node target) {
		super(source, target);
	}
	
	@Override
	public BigDecimal getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(BigDecimal weight) {
		Util.checkNullParameter(weight);
		
		this.weight = weight; 
	}
}
