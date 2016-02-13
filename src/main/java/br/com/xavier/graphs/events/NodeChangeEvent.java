package br.com.xavier.graphs.events;

import br.com.xavier.graphs.events.enums.GraphEventType;

/**
 * An event which indicates that a Graph Node has changed, or is about to change. </br>
 * </br>
 * The event can be used either as an indication before/after the Node has been added, removed or changed. </br> 
 * The type of the event can be tested using the {@code #getGraphEventType()} method.
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public class NodeChangeEvent<N> extends GraphChangeEvent {

	private static final long serialVersionUID = -5405440464011171681L;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Constructor for EdgeChangeEvent.
	 * 
	 * @param eventSource {@link N} - the source of this event.
	 * @param type {@link GraphEventType} - the event type of this event.
	 */
	public NodeChangeEvent(N eventSourceNode, GraphEventType type) {
		super(eventSourceNode, type);
	}
	
	//XXX OVERRIDE METHODS
	
	/**
	 * Returns the Node that is the source of this event.
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public N getSource() {
		return (N) super.getSource();
	}
}
