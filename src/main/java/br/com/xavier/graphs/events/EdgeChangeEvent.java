package br.com.xavier.graphs.events;

import br.com.xavier.graphs.enums.GraphEventType;

/**
 * An event which indicates that a Graph Edge has changed, or is about to change. </br>
 * </br>
 * The event can be used either as an indication before/after the Edge has been added, removed or changed. </br> 
 * The type of the event can be tested using the {@code #getGraphEventType()} method.
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type Class
 * @param <E> Edges type Class
 */
public class EdgeChangeEvent<N,E> extends GraphChangeEvent {

	private static final long serialVersionUID = 836223283258199774L;

	//XXX CLASS PROPERTIES
	private final E edge;
	private final N edgeSourceNode;
	private final N edgeTargetNode;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Constructor for EdgeChangeEvent.
	 * 
	 * @param eventSource {@link Object} - the source of this event.
	 * @param type {@link GraphEventType} - the event type of this event.
	 * @param edge {@link E} - the edge that this event is related to.
	 * @param edgeSourceNode {@link N}  - edge source Node.
	 * @param edgeTargetNode {@link N} - edge target Node.
	 */
	public EdgeChangeEvent(Object eventSource, GraphEventType type, E edge, N edgeSourceNode, N edgeTargetNode) {
	    super(eventSource, type);
	    this.edge = edge;
	    this.edgeSourceNode = edgeSourceNode;
	    this.edgeTargetNode = edgeTargetNode;
	}

	//XXX GETTERS/SETTERS
	
	/**
	 * Returns the {@link E} Edge that this event is related to.
	 * 
	 * @return {@link E} - edge that this event is related to.
	 */
	public E getEdge() {
		return edge;
	}
	
	/**
	 * Returns the source Node {@link N} that this Edge event is related to.
	 * 
	 * @return {@link N} - source Node that this Edge event is related to.
	 */
	public N getEdgeSourceNode() {
		return edgeSourceNode;
	}
	
	/**
	 * Returns the target Node {@link N} that this Edge event is related to.
	 * 
	 * @return {@link N} - target Node that this Edge event is related to.
	 */
	public N getEdgeTargetNode() {
		return edgeTargetNode;
	}
}
