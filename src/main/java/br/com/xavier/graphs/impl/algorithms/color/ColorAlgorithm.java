package br.com.xavier.graphs.impl.algorithms.color;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractColoredNode;
import br.com.xavier.graphs.impl.algorithms.degree.DegreeSortAlgorithm;
import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.impl.nodes.ColoredNode;
import br.com.xavier.graphs.impl.simple.undirected.DefaultSUUGraph;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.util.Util;

public class ColorAlgorithm {
	
	//XXX CONSTRUCTOR
	public ColorAlgorithm() {}
	
	public static void main(String[] args) {
		DefaultSUUGraph<ColoredNode, DefaultUnweightedEdge<ColoredNode>> graph = new DefaultSUUGraph<>();
		
		ColoredNode cn1 = new ColoredNode();
//		ColoredNode cn2 = new ColoredNode();
//		ColoredNode cn3 = new ColoredNode();
//		ColoredNode cn4 = new ColoredNode();
//		ColoredNode cn5 = new ColoredNode();
//		ColoredNode cn6 = new ColoredNode();
//		ColoredNode cn7 = new ColoredNode();
//		ColoredNode cn8 = new ColoredNode();
		
		graph.addNode(cn1);
//		graph.addNode(cn2);
//		graph.addNode(cn3);
//		graph.addNode(cn4);
//		graph.addNode(cn5);
//		graph.addNode(cn6);
//		graph.addNode(cn7);
//		graph.addNode(cn8);
		
//		DefaultUnweightedEdge<ColoredNode> edge12 = new DefaultUnweightedEdge<ColoredNode>(cn1, cn2);
//		DefaultUnweightedEdge<ColoredNode> edge13 = new DefaultUnweightedEdge<ColoredNode>(cn1, cn3);
//		DefaultUnweightedEdge<ColoredNode> edge23 = new DefaultUnweightedEdge<ColoredNode>(cn2, cn3);
//		DefaultUnweightedEdge<ColoredNode> edge34 = new DefaultUnweightedEdge<ColoredNode>(cn3, cn4);
//		DefaultUnweightedEdge<ColoredNode> edge35 = new DefaultUnweightedEdge<ColoredNode>(cn3, cn5);
//		DefaultUnweightedEdge<ColoredNode> edge36 = new DefaultUnweightedEdge<ColoredNode>(cn3, cn6);
//		DefaultUnweightedEdge<ColoredNode> edge45 = new DefaultUnweightedEdge<ColoredNode>(cn4, cn5);
//		DefaultUnweightedEdge<ColoredNode> edge47 = new DefaultUnweightedEdge<ColoredNode>(cn4, cn7);
//		DefaultUnweightedEdge<ColoredNode> edge56 = new DefaultUnweightedEdge<ColoredNode>(cn5, cn6);
//		DefaultUnweightedEdge<ColoredNode> edge57 = new DefaultUnweightedEdge<ColoredNode>(cn5, cn7);
//		DefaultUnweightedEdge<ColoredNode> edge58 = new DefaultUnweightedEdge<ColoredNode>(cn5, cn8);
//		DefaultUnweightedEdge<ColoredNode> edge68 = new DefaultUnweightedEdge<ColoredNode>(cn6, cn8);
//		DefaultUnweightedEdge<ColoredNode> edge78 = new DefaultUnweightedEdge<ColoredNode>(cn7, cn8);
//		
//		graph.addEdge(edge12);
//		graph.addEdge(edge13);
//		graph.addEdge(edge23);
//		graph.addEdge(edge34);
//		graph.addEdge(edge35);
//		graph.addEdge(edge36);
//		graph.addEdge(edge45);
//		graph.addEdge(edge47);
//		graph.addEdge(edge56);
//		graph.addEdge(edge57);
//		graph.addEdge(edge58);
//		graph.addEdge(edge68);
//		graph.addEdge(edge78);
		
		ColorAlgorithm ca = new ColorAlgorithm();
		ca.applyColor(graph);
		
		Set<ColoredNode> allNodes = graph.getAllNodes();
		for (ColoredNode node : allNodes) {
			System.out.println(node);
		}
	}
	
	//XXX METHDOS
	public <CN extends AbstractColoredNode, E extends AbstractEdge<CN>> void applyColorUnweightedGraph(Graph<CN, E> graph) {
		Util.checkNullParameter(graph);
		applyColor(graph);
	}
	
	public <CN extends AbstractColoredNode, E extends AbstractWeightedEdge<CN,T>, T extends Comparable<T>> void applyColorWeightedGraph(Graph<CN, E> graph) {
		Util.checkNullParameter(graph);
		applyColor(graph);
	}
	
	public <CN extends AbstractColoredNode, E extends AbstractEdge<CN>> void applyColor(Graph<CN, E> graph){
		Util.checkNullParameter(graph);
		
		if(graph.isEmpty()){
			return;
		}
		
		Set<Color> colorSet = ColorFactory.getPredefinedColorSet(4);
		Iterator<Color> colorIterator = colorSet.iterator();
		
		Set<CN> uncoloredNodesSet = new LinkedHashSet<>(graph.getAllNodes());
		Set<CN> neighborNodeSet = new LinkedHashSet<>();
		
		
		DegreeSortAlgorithm dsa = new DegreeSortAlgorithm();
		Map<Integer, List<CN>> degreeMap = dsa.getDegreeMap(graph);
		
		while(!uncoloredNodesSet.isEmpty()){
			Set<Integer> degreeSet = degreeMap.keySet();
			for (Integer degree : degreeSet) {
				Color color = colorIterator.next();
				
				List<CN> degreeNodesList = degreeMap.get(degree);
				ListIterator<CN> degreeIterator = degreeNodesList.listIterator();
				while(degreeIterator.hasNext()){
					CN node = degreeIterator.next();
					
					if(uncoloredNodesSet.contains(node) && !neighborNodeSet.contains(node)){
						uncoloredNodesSet.remove(node);
						neighborNodeSet.add(node);
						
						Set<E> allNodeEdges = graph.getAllEdges(node);
						for (E edge : allNodeEdges) {
							neighborNodeSet.add(edge.getTarget());
						}
						
						degreeIterator.remove();
						node.setColor(color);
					}
					
				} //end while
			} // end for
			
			neighborNodeSet.clear();
			
		} //end while
	}

}
