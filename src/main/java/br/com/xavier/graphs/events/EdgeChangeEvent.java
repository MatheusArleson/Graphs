package br.com.xavier.graphs.events;

import br.com.xavier.graphs.events.enums.GraphEventType;
import br.com.xavier.graphs.interfaces.Edge;
import br.com.xavier.graphs.interfaces.Node;

/**
 * An event which indicates that a Graph Edge has changed, or is about to change. </br>
 * </br>
 * The event can be used either as an indication before/after the Edge has been added, removed or changed. </br> 
 * The type of the event can be tested using the {@code #getGraphEventType()} method.
 * 
 * @author Matheus Xavier
 *
 */
public class EdgeChangeEvent extends GraphChangeEvent {

	private static final long serialVersionUID = 836223283258199774L;

	//XXX CLASS PROPERTIES
	private final Edge edge;
	private final Node edgeSourceNode;
	private final Node edgeTargetNode;
	
	//XXX CONSTRUCTOR
	
	/**
	 * Constructor for EdgeChangeEvent.
	 * 
	 * @param eventSource {@link Object} - the source of this event.
	 * @param type {@link GraphEventType} - the event type of this event.
	 * @param edge {@link Edge} - the edge that this event is related to.
	 * @param edgeSourceNode {@link Node}  - edge source Node.
	 * @param edgeTargetNode {@link Node} - edge target Node.
	 */
	public EdgeChangeEvent(Object eventSource, GraphEventType type, Edge edge, Node edgeSourceNode, Node edgeTargetNode) {
	    super(eventSource, type);
	    this.edge = edge;
	    this.edgeSourceNode = edgeSourceNode;
	    this.edgeTargetNode = edgeTargetNode;
	}

	//XXX GETTERS/SETTERS
	
	/**
	 * Returns the {@link Edge} that this event is related to.
	 * 
	 * @return {@link Edge} - edge that this event is related to.
	 */
	public Edge getEdge() {
		return edge;
	}
	
	/**
	 * Returns the source {@link Node} that this Edge event is related to.
	 * 
	 * @return {@link Node} - source Node that this Edge event is related to.
	 */
	public Node getEdgeSourceNode() {
		return edgeSourceNode;
	}
	
	/**
	 * Returns the target {@link Node} that this Edge event is related to.
	 * 
	 * @return {@link Node} - target Node that this Edge event is related to.
	 */
	public Node getEdgeTargetNode() {
		return edgeTargetNode;
	}
}
