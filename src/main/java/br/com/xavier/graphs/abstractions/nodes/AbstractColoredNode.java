package br.com.xavier.graphs.abstractions.nodes;

import java.awt.Color;

import br.com.xavier.graphs.interfaces.nodes.ColoredNode;

public abstract class AbstractColoredNode extends AbstractNode implements ColoredNode{
	
	private Color nodeColor;
	
	//XXX CONSTRUCTORS
	public AbstractColoredNode() {
		this(Color.WHITE);
	}
	
	public AbstractColoredNode(Color color) {
		this.nodeColor = color;
	}
	
	//XXX OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeColor == null) ? 0 : nodeColor.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AbstractColoredNode other = (AbstractColoredNode) obj;
		if (nodeColor == null) {
			if (other.nodeColor != null) {
				return false;
			}
		} else if (!nodeColor.equals(other.nodeColor)) {
			return false;
		}
		return true;
	}
	
	@Override
	public Color getColor() {
		return nodeColor;
	}


	@Override
	public void setColor(Color color) {
		this.nodeColor = color;
	}
}
