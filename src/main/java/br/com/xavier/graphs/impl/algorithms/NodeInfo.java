package br.com.xavier.graphs.impl.algorithms;

import java.io.Serializable;

import br.com.xavier.graphs.interfaces.nodes.Node;

public final class NodeInfo implements Serializable {
	
	private static final long serialVersionUID = 4006849223999420506L;
	
	//XXX CLASS PROPERTIES
	private final Node node;
	private Node parent;
	private Integer distance;
	private boolean visited;
	
	//XXX CLASS CONSTRUCTOR
	public NodeInfo(Node node) {
		this.node = node;
		this.distance = Integer.MAX_VALUE; 
		this.parent = null;
		this.visited = false;
	}
	
	//XXX OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + (visited ? 1231 : 1237);
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
		
		NodeInfo other = (NodeInfo) obj;
		if (distance == null) {
			if (other.distance != null) {
				return false;
			}
		} else if (!distance.equals(other.distance)) {
			return false;
		}
		if (node == null) {
			if (other.node != null) {
				return false;
			}
		} else if (!node.equals(other.node)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (visited != other.visited) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "NodeInfo [" 
			+ "node=" + node 
			+ ", parent=" + parent 
			+ ", distance=" + distance 
			+ ", visited=" + visited
		+ "]";
	}

	//XXX GETTERS
	public Node getNode() {
		return node;
	}
	
	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
