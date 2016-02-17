package br.com.xavier.graphs.interfaces.listeners;

import br.com.xavier.graphs.interfaces.Graph;

/**
 * A graph that supports listeners on structural change events.
 * 
 * @author Matheus Xavier
 *
 */
public interface ListenableGraph extends Graph {
	
	//XXX GRAPH LISTEN METHODS
	
	/**
	 * Adds the specified {@link GraphListener} to this Graph, if not already present.
	 * 
	 * @param graphListener - the {@link GraphListener} to be added.
	 */
	public abstract void addGraphListener(GraphListener graphListener);
	
	/**
	 * Removes the specified {@link GraphListener} to this Graph, if present.
	 * 
	 * @param graphListener - the {@link GraphListener} to be removed.
	 */
	public abstract void removeGraphListener(GraphListener graphListener);

	//XXX GRAPH NODES LISTEN METHODS
	
	/**
	 * Adds the specified {@link NodeListener} to this Graph, if not already present.
	 * 
	 * @param nodeListener - the {@link NodeListener} to be added.
	 */
	public abstract void addNodesListener(NodeListener nodeListener);
	
	/**
	 * Removes the specified {@link NodeListener} to this Graph, if present.
	 * 
	 * @param nodeListener - the {@link NodeListener} to be removed.
	 */
	public abstract void removeNodesListener(NodeListener nodeListener);
	
	//XXX GRAPH EDGES LISTEN METHODS
	
	/**
	 * Adds the specified {@link EdgeListener} to this Graph, if not already present.
	 * 
	 * @param edgeListener - the {@link EdgeListener} to be added.
	 */
	public abstract void addEdgesListener(EdgeListener edgeListener);
	
	/**
	 * Removes the specified {@link EdgeListener} to this Graph, if present.
	 * 
	 * @param edgeListener - the {@link EdgeListener} to be removed.
	 */
	public abstract void removeEdgesListener(EdgeListener EdgeListener);
	
}
