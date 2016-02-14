package br.com.xavier.graphs.interfaces;

/**
 * An Edge factory used for creating new Edges.
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type class.
 * @param <E> Edges type class.
 */
public abstract interface EdgeFactory<N, E> {

	/**
	 * Creates a new Edge whose endpoints are the specified source and target Nodes.
	 * 
	 * @param sourceNode {@link N} - the source Node.
	 * @param targetNode {@link N} - the target Node.
	 * @return {@link E} - a new Edge whose endpoints are the specified source and target Nodes.
	 */
	public abstract E createEdge(N sourceNode, N targetNode);
	
}
