package br.com.xavier.graphs.interfaces.algorithms;

import java.util.List;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractColoredNode;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalGraphException;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.impl.algorithms.NodeInfo;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;

public interface IGraphAlgorithms {
	
	
	/**
	 * Apply the Breadth-First Search algorithm to a {@link Graph} instance. </br>
	 * </br>
	 * It starts at the tree root (an arbitrary node of a graph) and </br>
	 * explores the neighbor nodes first, before moving to the next level neighbors. </br>
	 * 
	 * @param <N> Nodes type Class
	 * @param <E> Edges type Class
	 * @param graph - {@link Graph} instance to do the traversing
	 * @param root - {@link N} Node that will be the start of the traversing process. 
	 * @return A unmodifiable {@link List} of {@link NodeInfo}. The order of the list is the order of output in the algorithm.
	 * @throws IllegalNodeException if the Node passed is not part of the Graph.
	 * @throws NullPointerException if the Node passed is null.
	 */
	public <N extends Node, E extends Edge<N>> List<NodeInfo> BFS(Graph<N, E> graph, N root);
	
	/**
	 * Apply the Depth-First Search algorithm to a {@link Graph} instance. </br>
	 * </br>
	 * It starts at the tree root (an arbitrary node of a graph) and </br>
	 * explores as far as possible along each branch before backtracking. </br>
	 * 
	 * @param <N> Nodes type Class
	 * @param <E> Edges type Class
	 * @param graph - {@link Graph} instance to do the traversing
	 * @param root - {@link N} Node that will be the start of the traversing process. 
	 * @return A unmodifiable {@link List} of {@link NodeInfo}. The order of the list is the order of output in the algorithm.
	 * @throws IllegalNodeException if the Node passed is not part of the Graph.
	 * @throws NullPointerException if the Node passed is null.
	 */
	public <N extends Node, E extends Edge<N>> List<NodeInfo> DFS(Graph<N, E> graph, N root);
	
	/**
	 * Apply the Kruskal's algorithm to a {@link Graph} instance. </br>
	 * </br>
	 * 
	 * @param <N> Nodes type Class
	 * @param <E> Edges type Class
	 * @param graph - {@link Graph} instance to do the traversing
	 * @return A {@link Graph} containing only the minimun spanning tree
	 * @throws NullPointerException if the {@link Graph} passed is null.
	 * @throws IllegalGraphException if the {@link Graph} passed is not connected.
	 */
	public <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> AbstractGraph<N,E> kruskal(Graph<N, E> graph);

	/**
	 * 
	 * Method to check if a {@link Graph} is connected or not. </br>
	 * </br>
	 * It will perform an {@link #BFS(Graph, Node)} on the first node returned by {@link Graph#getAllNodes()} iterator. </br>
	 * Then check if each node of the {@link Graph} is present in the transversal.
	 * 
	 * @param graph - {@link Graph} instance to check
	 * @return true if it is connected; false otherwise.
	 */
	public <N extends Node, E extends Edge<N>> boolean checkGraphConnectionsByBFS(Graph<N, E> graph);
	
	/**
	 * 
	 * Method to check if a {@link Graph} is connected or not. </br>
	 * </br>
	 * It will perform an {@link #DFS(Graph, Node)} on the first node returned by {@link Graph#getAllNodes()} iterator. </br>
	 * Then check if each node of the {@link Graph} is present in the transversal.
	 * 
	 * @param graph - {@link Graph} instance to check
	 * @return true if it is connected; false otherwise.
	 */
	public <N extends Node, E extends Edge<N>> boolean checkGraphConnectionsByDFS(Graph<N, E> graph);
	
	public <CN extends AbstractColoredNode, E extends AbstractEdge<CN>> void applyColor(Graph<CN,E> graph);
}
