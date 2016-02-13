package br.com.xavier.graphs.interfaces.listeners;

import java.util.EventListener;

import br.com.xavier.graphs.events.EdgeChangeEvent;

/**
 * An event which indicates that a Graph Edge has changed, or is about to change. </br>
 * The event can be used either as an indication after/before the Edge has been added, removed or changed. </br> 
 * </br>
 * If all Graph notifications are of interest better use {@link GraphListener}. </br>
 * If only notifications on Nodes changes are required it is more efficient to use the {@link NodeListener}. </br>
 * 
 * @author Matheus Xavier
 *
 * @param <E> Edges type Class
 */
public abstract interface EdgeListener<N,E> extends EventListener {
	
	/**
	 * Notifies that an Edge has been added to the Graph.
	 * 
	 * @param edgeChangeEvent {@link EdgeChangeEvent} - the event.
	 */
	public abstract void edgeAdded(EdgeChangeEvent<N,E> edgeChangeEvent);
	
	/**
	 * Notifies that an Edge has been removed from the Graph.
	 * 
	 * @param edgeChangeEvent {@link EdgeChangeEvent} - the event.
	 */
	public abstract void edgeRemoved(EdgeChangeEvent<N,E> edgeChangeEvent);
	
	/**
	 * Notifies that an Edge has been added to the Graph.
	 * 
	 * @param edgeChangeEvent {@link EdgeChangeEvent} - the event.
	 */
	public abstract void edgeChanged(EdgeChangeEvent<N,E> edgeChangeEvent);

}
