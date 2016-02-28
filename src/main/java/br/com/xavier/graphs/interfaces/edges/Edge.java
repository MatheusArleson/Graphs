package br.com.xavier.graphs.interfaces.edges;

import br.com.xavier.graphs.interfaces.nodes.Node;

public interface Edge<N extends Node> {
	
	/**
	 * Returns the source Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @return {@link N} - source Node.
	 * 
	 */
	public abstract N getSource();
	
	/**
	 * Returns the target Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @return {@link N} - target Node.
	 * 
	 */
	public abstract N getTarget();
	
	public default boolean isPath(N sourceNode, N targetNode){
		return getSource().equals(sourceNode) && getTarget().equals(targetNode);
	}
	
}
