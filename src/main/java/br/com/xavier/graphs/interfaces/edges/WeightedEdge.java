package br.com.xavier.graphs.interfaces.edges;

import java.math.BigDecimal;

public interface WeightedEdge extends Edge {
	
	/**
	 * Returns the weight assigned to a given Edge. </br> 
	 * Unweighted Graphs return 1.0; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 * @return {@link BigDecimal} - weight associated to the Edge.
	 */
	public abstract BigDecimal getWeight();
	
	/**
	 * Sets the weight assigned to a given Edge. </br> 
	 * On Unweighted Graphs does nothing; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 */
	public abstract void setWeight(BigDecimal weight);

}
