package br.com.xavier.graphs.interfaces;

public interface Edge<N,E> {
	
	/**
	 * Returns the source Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - source Node.
	 * @throws NullPointerException if Edge parameter is null.
	 * 
	 */
	public abstract N getEdgeSource(E edge) throws NullPointerException;
	
	/**
	 * Returns the target Node of an Edge. </br> 
	 * For an undirected graph, source and target Nodes are distinguishable designations (but without any mathematical meaning). </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - target Node.
	 * @throws NullPointerException if Edge parameter is null.
	 * 
	 */
	public abstract N getEdgeTarget(E edge);
	
	/**
	 * Returns the weight assigned to a given Edge. </br> 
	 * Unweighted Graphs return 1.0; allowing weighted-graph algorithms to apply to them where meaningful. </br>
	 * 
	 * @param edge - Edge of interest.
	 * @return {@link N} - target Node.
	 * @throws NullPointerException if Edge parameter is null.
	 */
	public abstract double getEdgeWeight(E edge) throws NullPointerException;
	
}
