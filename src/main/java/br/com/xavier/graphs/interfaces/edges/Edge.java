package br.com.xavier.graphs.interfaces.edges;

import br.com.xavier.graphs.interfaces.Node;

public interface Edge {
	
	/**
	 * Returns the source Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @return {@link Node} - source Node.
	 * 
	 */
	public abstract Node getSource();
	
	/**
	 * Returns the target Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @return {@link Node} - target Node.
	 * 
	 */
	public abstract Node getTarget();

}
