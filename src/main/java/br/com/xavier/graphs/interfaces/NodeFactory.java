package br.com.xavier.graphs.interfaces;

/**
 * A Node factory used for creating new Nodes. 
 * 
 * @author Matheus Xavier
 *
 * @param <N> Nodes type class.
 */
public abstract interface NodeFactory<N> {
	
	public abstract N createNode();

}
