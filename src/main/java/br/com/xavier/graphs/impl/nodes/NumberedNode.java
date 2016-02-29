package br.com.xavier.graphs.impl.nodes;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.util.messages.MessageManager;

public class NumberedNode extends AbstractNode {
	
	private static final String NODE_LABEL_BASE_STR = "node.numbered.label.base";
	private int nodeNumber;
	
	//XXX CONSTRUCTOR
	public NumberedNode(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}
	
	//XXX OVERRIDE METHODS
	@Override
	public String getLabel() {
		return String.valueOf(nodeNumber);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nodeNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		
		NumberedNode other = (NumberedNode) obj;
		if (nodeNumber != other.nodeNumber) { return false; }
		
		return true;
	}

	@Override
	public String toString() {
		return String.format(MessageManager.getMessage(NODE_LABEL_BASE_STR), nodeNumber);
	}

}
