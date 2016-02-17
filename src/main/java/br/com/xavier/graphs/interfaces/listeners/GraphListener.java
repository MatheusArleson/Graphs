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
 */
public abstract class GraphListener extends EventListenerList implements NodeListener, EdgeListener{

	private static final long serialVersionUID = -1907819787435642385L;

}
