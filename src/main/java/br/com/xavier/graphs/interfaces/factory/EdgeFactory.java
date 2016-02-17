package br.com.xavier.graphs.interfaces.factory;

import java.math.BigDecimal;

import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.Edge;

/**
 * An Edge factory used for creating new Edges.
 * 
 * @author Matheus Xavier
 *
 */
public abstract interface EdgeFactory {

	/**
	 * Creates a new Edge whose endpoints are the specified source and target Nodes.
	 * 
	 * @param sourceNode {@link N} - the source Node.
	 * @param targetNode {@link N} - the target Node.
	 * @param weight {@link BigDecimal} - the weight of the Edge.
	 * @return {@link Edge} - a new Edge whose endpoints are the specified source and target Nodes.
	 */
	public abstract Edge createEdge(Node sourceNode, Node targetNode, BigDecimal weight);
	
}
