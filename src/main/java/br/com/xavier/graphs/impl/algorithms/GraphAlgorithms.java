package br.com.xavier.graphs.impl.algorithms;

import java.util.List;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractColoredNode;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.impl.algorithms.color.ColorAlgorithm;
import br.com.xavier.graphs.impl.algorithms.mst.KruskalAlgorithm;
import br.com.xavier.graphs.impl.algorithms.transversal.BFSAlgorithm;
import br.com.xavier.graphs.impl.algorithms.transversal.ConnectedGraphAlgorithm;
import br.com.xavier.graphs.impl.algorithms.transversal.DFSAlgorithm;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.algorithms.IGraphAlgorithms;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;

public final class GraphAlgorithms implements IGraphAlgorithms {
	
	//XXX CONSTRUCTOR
	public GraphAlgorithms(){ }
	
	//XXX TRASVERSAL METHODS
	@Override
	public <N extends Node, E extends Edge<N>> boolean checkGraphConnectionsByBFS(Graph<N,E> graph) {
		return new ConnectedGraphAlgorithm().checkGraphConnectionsByBFS(graph);
	}
	
	@Override
	public <N extends Node, E extends Edge<N>> boolean checkGraphConnectionsByDFS(Graph<N,E> graph) {
		return new ConnectedGraphAlgorithm().checkGraphConnectionsByDFS(graph);
	}
	
	@Override
	public <N extends Node, E extends Edge<N>> List<NodeInfo> BFS(Graph<N, E> graph, N root) {
		BFSAlgorithm bfs = new BFSAlgorithm();
		return bfs.doAlgorithm(graph, root);
	}
	
	@Override
	public <N extends Node, E extends Edge<N>> List<NodeInfo> DFS(Graph<N, E> graph, N root) {
		DFSAlgorithm dfs = new DFSAlgorithm();
		return dfs.doAlgorithm(graph, root);
	}
	
	@Override
	public <N extends AbstractNode, E extends AbstractWeightedEdge<N, T>, T extends Comparable<T>> AbstractGraph<N, E> kruskal(Graph<N, E> graph) {
		KruskalAlgorithm ka = new KruskalAlgorithm();
		AbstractGraph<N, E> mst = ka.doAlgorithm(graph);
		return mst;
	}

	@Override
	public <CN extends AbstractColoredNode, E extends AbstractEdge<CN>> void applyColor(Graph<CN, E> graph) {
		new ColorAlgorithm().applyColor(graph);
	}

}
