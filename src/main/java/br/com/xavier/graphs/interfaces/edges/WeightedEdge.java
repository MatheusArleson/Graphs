package br.com.xavier.graphs.interfaces.edges;

import br.com.xavier.graphs.interfaces.nodes.Node;

public interface WeightedEdge<N extends Node, T extends Comparable<T>> extends Edge<N> {
	
	/**
	 * Returns the weight assigned to a given Edge. </br> 
	 * Unweighted Graphs return 1.0; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 * @return {@link T} - weight associated to the Edge.
	 */
	public abstract T getWeight();
	
	/**
	 * Sets the weight assigned to a given Edge. </br> 
	 * On Unweighted Graphs does nothing; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 */
	public abstract void setWeight(T weight);
	
}
