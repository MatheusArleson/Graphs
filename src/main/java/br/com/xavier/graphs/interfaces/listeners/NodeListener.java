package br.com.xavier.graphs.interfaces.listeners;

import java.util.EventListener;

import br.com.xavier.graphs.events.NodeChangeEvent;

/**
 * A listener that is notified when a Graph Node change. </br> 
 * It should be used when only notifications on Nodes changes are of interest. </br>
 * </br> 
 * If all Graph notifications are of interest better use {@link GraphListener}. </br>
 * If only notifications on Edges changes are required it is more efficient to
 * use the {@link EdgeListener}. </br>
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 */
public abstract interface NodeListener<N> extends EventListener {
	
	/**
	 * Notifies that an Node has been added to the Graph.
	 * 
	 * @param nodeChangeEvent {@link NodeChangeEvent} - the event.
	 */
	public abstract void nodeAdded(NodeChangeEvent<N> nodeChangeEvent);
	
	/**
	 * Notifies that an Node has been removed from the Graph.
	 * 
	 * @param edgeChangeEvent {@link NodeChangeEvent} - the event.
	 */
	public abstract void nodeRemoved(NodeChangeEvent<N> nodeChangeEvent);
	
	/**
	 * Notifies that an Node has been added to the Graph.
	 * 
	 * @param edgeChangeEvent {@link NodeChangeEvent} - the event.
	 */
	public abstract void nodeChanged(NodeChangeEvent<N> nodeChangeEvent);

}
