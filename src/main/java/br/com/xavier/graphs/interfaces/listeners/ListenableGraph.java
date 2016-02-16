package br.com.xavier.graphs.interfaces.listeners;

import br.com.xavier.graphs.interfaces.Graph;

/**
 * A graph that supports listeners on structural change events.
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public interface ListenableGraph<N, E> extends Graph<N, E> {
	
	//XXX GRAPH LISTEN METHODS
	
	/**
	 * Adds the specified {@link GraphListener} to this Graph, if not already present.
	 * 
	 * @param graphListener - the {@link GraphListener} to be added.
	 */
	public abstract void addGraphListener(GraphListener<N, E> graphListener);
	
	/**
	 * Removes the specified {@link GraphListener} to this Graph, if present.
	 * 
	 * @param graphListener - the {@link GraphListener} to be removed.
	 */
	public abstract void removeGraphListener(GraphListener<N, E> graphListener);

	//XXX GRAPH NODES LISTEN METHODS
	
	/**
	 * Adds the specified {@link NodeListener} to this Graph, if not already present.
	 * 
	 * @param nodeListener - the {@link NodeListener} to be added.
	 */
	public abstract void addNodesListener(NodeListener<N> nodeListener);
	
	/**
	 * Removes the specified {@link NodeListener} to this Graph, if present.
	 * 
	 * @param nodeListener - the {@link NodeListener} to be removed.
	 */
	public abstract void removeNodesListener(NodeListener<N> nodeListener);
	
	//XXX GRAPH EDGES LISTEN METHODS
	
	/**
	 * Adds the specified {@link EdgeListener} to this Graph, if not already present.
	 * 
	 * @param edgeListener - the {@link EdgeListener} to be added.
	 */
	public abstract void addEdgesListener(EdgeListener<N,E> edgeListener);
	
	/**
	 * Removes the specified {@link EdgeListener} to this Graph, if present.
	 * 
	 * @param edgeListener - the {@link EdgeListener} to be removed.
	 */
	public abstract void removeEdgesListener(EdgeListener<N,E> EdgeListener);
	
}
