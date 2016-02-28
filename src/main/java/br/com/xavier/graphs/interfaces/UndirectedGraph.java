package br.com.xavier.graphs.interfaces;

import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;

/**
 * A Graph whose all Edges are undirected. </br> 
 * This is the root interface of all undirected Graphs. </br> 
 * 
 * @author Matheus Arleson
 *
 */
public abstract interface UndirectedGraph<N extends Node, E extends Edge<N>> extends Graph<N,E> {
	
}
