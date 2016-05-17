package br.com.xavier.graphs.impl.nodes;

import java.awt.Color;

import br.com.xavier.graphs.abstractions.nodes.AbstractColoredNode;

public class ColoredNode extends AbstractColoredNode {
	
	public ColoredNode() {
		super();
	}
	
	public ColoredNode(Color color){
		super(color);
	}

	@Override
	public String toString() {
		return "ColoredNode ["
			+ "color=" + getColor() 
		+ "]";
	}
}
