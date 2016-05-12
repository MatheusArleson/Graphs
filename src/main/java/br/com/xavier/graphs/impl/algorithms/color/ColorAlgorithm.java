package br.com.xavier.graphs.impl.algorithms.color;

import java.awt.Color;
import java.util.Set;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractColoredNode;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.util.Util;

public class ColorAlgorithm {
	
	//XXX CONSTRUCTOR
	public ColorAlgorithm() {}
	
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
		
		
	}

}
