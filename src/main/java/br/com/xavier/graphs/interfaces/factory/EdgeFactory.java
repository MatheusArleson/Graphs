package br.com.xavier.graphs.interfaces.factory;

import br.com.xavier.graphs.interfaces.Edge;
import br.com.xavier.graphs.interfaces.Node;

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
	 * @return {@link E} - a new Edge whose endpoints are the specified source and target Nodes.
	 */
	public abstract Edge createEdge(Node sourceNode, Node targetNode);
	
}
