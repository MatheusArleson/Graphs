package br.com.xavier.graphs.interfaces.factory;

import br.com.xavier.graphs.interfaces.Node;

/**
 * A Node factory used for creating new Nodes. 
 * 
 * @author Matheus Xavier
 *
 */
public abstract interface NodeFactory {
	
	/**
	 * Creates a new Node.
	 * 
	 * @return {@link Node} - a new Node.
	 */
	public abstract Node createNode();

}
