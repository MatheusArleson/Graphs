package br.com.xavier.graphs.interfaces.listeners;

import javax.swing.event.EventListenerList;

/**
 * A listener that is notified when the Graph changes. </br>
 * </br>
 * If only notifications on Nodes changes are required it is more efficient to
 * use the {@link NodeListener}.
 * </br>
 * If only notifications on Edges changes are required it is more efficient to
 * use the {@link EdgeListener}.
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public abstract class GraphListener<N, E> extends EventListenerList implements NodeListener<N>, EdgeListener<N,E>{

	private static final long serialVersionUID = -1907819787435642385L;

}
