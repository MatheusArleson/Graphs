package br.com.xavier.graphs.events;

import java.util.EventObject;
import br.com.xavier.graphs.enums.GraphEventType;

/**
 * An event which indicates that a Graph has changed. </br>
 *  </br>
 * This class is a root for Graph change events.
 * 
 * @author Matheus Xavier
 *
 */
public class GraphChangeEvent extends EventObject {

	private static final long serialVersionUID = 5793830771678391843L;

	//XXX CLASS PROPERTIES
	protected GraphEventType graphEventType;
	
	//XXX CONSTRUCTOR
	/**
	 * 
	 * Creates a new {@link GraphChangeEvent}.
	 * 
	 * @param eventSource - the source of the event.
	 * @param type - the type of event.
	 */
	public GraphChangeEvent(Object eventSource, GraphEventType type) {
		super(eventSource);
		this.graphEventType = type;
	}
	
	//XXX GETTERS/SETTERS
	/**
	 * 
	 * Returns the event type.
	 * 
	 * @return {@link GraphEventType} - the event type.
	 */
	public GraphEventType getGraphEventType() {
		return graphEventType;
	}
}
