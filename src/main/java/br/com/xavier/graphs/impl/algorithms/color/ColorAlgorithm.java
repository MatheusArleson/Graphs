package br.com.xavier.graphs.impl.algorithms.color;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
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
import br.com.xavier.graphs.impl.nodes.Room;
import br.com.xavier.graphs.impl.simple.undirected.DefaultSUUGraph;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.util.Util;

public class ColorAlgorithm {
	
	//XXX CONSTRUCTOR
	public ColorAlgorithm() {}
	
	public static void main(String[] args) {
		DefaultSUUGraph<Room, DefaultUnweightedEdge<Room>> graph = new DefaultSUUGraph<>();
		
		Room r1 = new Room("SALA1", 0, 0, 10, 20);
		Room r2 = new Room("SALA2", 0, 20, 10, 20);
		Room r3 = new Room("SALA3", 0, 40, 10, 20);
		Room r4 = new Room("SALA4", 0, 60, 10, 20);
		Room r5 = new Room("SALA5", 0, 80, 10, 20);
		
		graph.addNode(r1);
		graph.addNode(r2);
		graph.addNode(r3);
		graph.addNode(r4);
		graph.addNode(r5);
		
		DefaultUnweightedEdge<Room> edge12 = new DefaultUnweightedEdge<Room>(r1, r2);
		DefaultUnweightedEdge<Room> edge13 = new DefaultUnweightedEdge<Room>(r1, r3);
		DefaultUnweightedEdge<Room> edge23 = new DefaultUnweightedEdge<Room>(r2, r3);
		DefaultUnweightedEdge<Room> edge34 = new DefaultUnweightedEdge<Room>(r3, r4);
		DefaultUnweightedEdge<Room> edge35 = new DefaultUnweightedEdge<Room>(r3, r5);
		DefaultUnweightedEdge<Room> edge45 = new DefaultUnweightedEdge<Room>(r4, r5);
		
		graph.addEdge(edge12);
		graph.addEdge(edge13);
		graph.addEdge(edge23);
		graph.addEdge(edge34);
		graph.addEdge(edge35);
		graph.addEdge(edge45);
		
		ColorAlgorithm ca = new ColorAlgorithm();
		ca.applyColor(graph);
		
		Set<Room> allNodes = graph.getAllNodes();
		for (Room room : allNodes) {
			System.out.println(room);
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
		List<Integer> degreesList = new ArrayList<>(degreeMap.keySet());
		Collections.sort(degreesList, Collections.reverseOrder());
		
		while(!uncoloredNodesSet.isEmpty()){
			Color color = colorIterator.next();
			
			for (Integer degree : degreesList) {
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
