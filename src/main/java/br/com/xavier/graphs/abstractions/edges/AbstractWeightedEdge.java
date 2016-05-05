package br.com.xavier.graphs.abstractions.edges;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.WeightedEdge;
import br.com.xavier.graphs.util.messages.Util;

public abstract class AbstractWeightedEdge<N extends AbstractNode, T extends Comparable<T>> 
				extends AbstractEdge<N> 
				implements WeightedEdge<N,T>, Comparable<AbstractWeightedEdge<N, T>> {

	private static final long serialVersionUID = -3427314770841219944L;
	
	private T weight;
	
	//XXX CONSTRUCTOR
	public AbstractWeightedEdge(N source, N target, T weight) {
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
	
	@Override
	public String toString() {
		return "[" + getSource().getLabel() + ", " + getTarget().getLabel() + " : " + weight.toString() + "]";
	}
	
	@Override
	public int compareTo(AbstractWeightedEdge<N, T> otherEdge) {
		if(otherEdge == null){
			return -1;
		}
		
		return weight.compareTo(otherEdge.getWeight());
	}
	
	//XXX GETTERS/SETTERS
	@Override
	public T getWeight() {
		return weight;
	}

	@Override
	public void setWeight(T weight) {
		Util.checkNullParameter(weight);
		
		this.weight = weight; 
	}
}
