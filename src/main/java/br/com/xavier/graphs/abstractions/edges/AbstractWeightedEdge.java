package br.com.xavier.graphs.abstractions.edges;

import java.math.BigDecimal;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.WeightedEdge;
import br.com.xavier.graphs.util.messages.Util;

public abstract class AbstractWeightedEdge<N extends AbstractNode> extends AbstractEdge<N> implements WeightedEdge<N> {

	private static final long serialVersionUID = -3427314770841219944L;
	
	private BigDecimal weight;
	
	//XXX CONSTRUCTOR
	public AbstractWeightedEdge(N source, N target, BigDecimal weight) {
		super(source, target);
		setWeight(weight);
	}
	
	//XXX OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AbstractWeightedEdge other = (AbstractWeightedEdge) obj;
		if (weight == null) {
			if (other.weight != null) {
				return false;
			}
		} else if (!weight.equals(other.weight)) {
			return false;
		}
		return true;
	}
	
	//XXX GETTERS/SETTERS
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
