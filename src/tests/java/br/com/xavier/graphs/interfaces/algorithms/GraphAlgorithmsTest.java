package br.com.xavier.graphs.interfaces.algorithms;

import org.junit.Test;

import br.com.xavier.graphs.impl.algorithms.GraphAlgorithms;
import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.impl.nodes.NumberedNodesFactory;
import br.com.xavier.graphs.impl.simple.undirected.DefaultSUWGraph;

//TODO refactor to proper test
public class GraphAlgorithmsTest {
	
	@Test
	public void test() {
		System.out.println("#> START OF GRAPH CONSTRUCTION ");
		NumberedNodesFactory nnf = new NumberedNodesFactory();
		DefaultSUWGraph<NumberedNode, DefaultWeightedEdge<NumberedNode,Integer>, Integer> graph = new DefaultSUWGraph<>();
		
		//5 nodes
		NumberedNode node1 = nnf.createNode();
		NumberedNode node2 = nnf.createNode();
		NumberedNode node3 = nnf.createNode();
		NumberedNode node4 = nnf.createNode();
		NumberedNode node5 = nnf.createNode();
		//NumberedNode node6 = nnf.createNode();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		graph.addNode(node4);
		graph.addNode(node5);
		//graph.addNode(node6);
		
//		DefaultWeightedEdge<NumberedNode, Integer> edge12 = new DefaultWeightedEdge<NumberedNode, Integer>(node1, node2, 7);
//		DefaultWeightedEdge<NumberedNode, Integer> edge13 = new DefaultWeightedEdge<NumberedNode, Integer>(node1, node3, 8);
//		
//		DefaultWeightedEdge<NumberedNode, Integer> edge23 = new DefaultWeightedEdge<NumberedNode, Integer>(node2, node3, 9);
//		DefaultWeightedEdge<NumberedNode, Integer> edge24 = new DefaultWeightedEdge<NumberedNode, Integer>(node2, node4, 10);
//		DefaultWeightedEdge<NumberedNode, Integer> edge25 = new DefaultWeightedEdge<NumberedNode, Integer>(node2, node5, 11);
//		
//		DefaultWeightedEdge<NumberedNode, Integer> edge35 = new DefaultWeightedEdge<NumberedNode, Integer>(node3, node5, 12);
//		DefaultWeightedEdge<NumberedNode, Integer> edge36 = new DefaultWeightedEdge<NumberedNode, Integer>(node3, node6, 13);
//		
//		DefaultWeightedEdge<NumberedNode, Integer> edge45 = new DefaultWeightedEdge<NumberedNode, Integer>(node4, node5, 14);
//		DefaultWeightedEdge<NumberedNode, Integer> edge56 = new DefaultWeightedEdge<NumberedNode, Integer>(node5, node6, 15);
		
//		graph.addEdge(edge12);
//		graph.addEdge(edge13);
//		graph.addEdge(edge23);
//		graph.addEdge(edge24);
//		graph.addEdge(edge25);
//		graph.addEdge(edge35);
//		graph.addEdge(edge36);
//		graph.addEdge(edge45);
//		graph.addEdge(edge56);
		
		DefaultWeightedEdge<NumberedNode, Integer> edge12 = new DefaultWeightedEdge<NumberedNode, Integer>(node1, node2, 3);
		DefaultWeightedEdge<NumberedNode, Integer> edge15 = new DefaultWeightedEdge<NumberedNode, Integer>(node1, node5, 1);
		
		DefaultWeightedEdge<NumberedNode, Integer> edge23 = new DefaultWeightedEdge<NumberedNode, Integer>(node2, node3, 5);
		DefaultWeightedEdge<NumberedNode, Integer> edge25 = new DefaultWeightedEdge<NumberedNode, Integer>(node2, node5, 4);
		
		DefaultWeightedEdge<NumberedNode, Integer> edge34 = new DefaultWeightedEdge<NumberedNode, Integer>(node3, node4, 2);
		DefaultWeightedEdge<NumberedNode, Integer> edge35 = new DefaultWeightedEdge<NumberedNode, Integer>(node3, node5, 6);
		
		DefaultWeightedEdge<NumberedNode, Integer> edge45 = new DefaultWeightedEdge<NumberedNode, Integer>(node4, node5, 7);
		
		graph.addEdge(edge12);
		graph.addEdge(edge15);
		graph.addEdge(edge23);
		graph.addEdge(edge25);
		graph.addEdge(edge34);
		graph.addEdge(edge35);
		graph.addEdge(edge45);
		
		System.out.println("#> END OF GRAPH CONSTRUCTION ");
		
		IGraphAlgorithms ga = new GraphAlgorithms();
		
//		System.out.println("#> BFS > ");
//		List<NodeInfo> bfsNode1 = ga.BFS(graph, node1);
//		for (NodeInfo nodeInfo : bfsNode1) {
//			System.out.println(nodeInfo.toString());
//		}
//		
//		System.out.println("#> DFS > ");
//		List<NodeInfo> dfsNode1 = ga.DFS(graph, node1);
//		for (NodeInfo nodeInfo : dfsNode1) {
//			System.out.println(nodeInfo.toString());
//		}
		
//		System.out.println("#> KRUSKAL > ");
//		AbstractGraph<NumberedNode, DefaultWeightedEdge<NumberedNode, Integer>> kruskalGraph = ga.kruskal(graph);
		
//		GraphsParser<NumberedNode, DefaultWeightedEdge<NumberedNode, Integer>> parser = new CytoscapeWeightedParser<>();
//		String parsed = parser.parse(kruskalGraph, "container", "cy");
//		System.out.println(parsed);
	}

}
