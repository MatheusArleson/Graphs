package br.com.xavier.graphs.interfaces;

import java.util.Set;

import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;

/**
 * A graph whose all edges are directed. </br>
 * This is the root interface of all directed graphs. </br>
 * 
 * @author Matheus Xavier
 */
public abstract interface DirectedGraph<N extends Node, E extends Edge<N>> extends Graph<N,E> {

	//XXX DEGREE METHODS
	
	/**
	 * Returns the "in degree" of the specified Node. </br> 
	 * An in degree of a Node in a directed Graph is the number of inward directed Edges from that Node. </br>
	 *  
	 * @param node {@link N} - Node of interest
	 * @return the "in degree" of the specified Node.
	 */
	public abstract int inDegreeOf(Node node);
	
	/**
	 * Returns the "out degree" of the specified Node. </br> 
	 * An out degree of a Node in a directed Graph is the number of outward directed Edges from that Node. </br>
	 *  
	 * @param node {@link N} - Node of interest
	 * @return the "out degree" of the specified Node.
	 */
	public abstract int outDegreeOf(Node node);
	
	//XXX EDGES METHODS
	
	/**
	 * Returns a set of all Edges incoming into the specified Node.
	 * 
	 * @param node {@link N} - the Node for which the list of incoming Edges to be returned.
	 * @return {@link Set} - a set of all Edges incoming into the specified Node.
	 */
	public abstract Set<E> incomingEdgesOf(Node node);
	
	/**
	 * Returns a set of all Edges outgoing from the specified Node.
	 * 
	 * @param node {@link N} - the Node for which the list of outgoing Edges to be returned.
	 * @return {@link Set} - a set of all Edges outgoing into the specified Node.
	 */
	public abstract Set<E> outgoingEdgesOf(Node node);
	
}
