package br.com.xavier.graphs.interfaces.factory;

/**
 * A Node factory used for creating new Nodes. 
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type class.
 */
public abstract interface NodeFactory<N> {
	
	/**
	 * Creates a new Node.
	 * 
	 * @return {@link N} - a new Node.
	 */
	public abstract N createNode();

}
