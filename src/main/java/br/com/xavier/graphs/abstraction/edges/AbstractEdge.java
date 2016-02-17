package br.com.xavier.graphs.abstraction.edges;

import java.io.Serializable;

import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.Edge;

public abstract class AbstractEdge implements Edge, Serializable {
	
	private static final long serialVersionUID = -321501262100391879L;
	
	//XXX CLASS PROPERTIES
	private final Node source;
	private final Node target;
	
	//XXX CONSTRUCTOR
	public AbstractEdge(Node source, Node target) {
		super();
		this.source = source;
		this.target = target;
	}
	
	//XXX OVERRIDE METHODS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		
		AbstractEdge other = (AbstractEdge) obj;
		if (source == null) {
			if (other.source != null) { return false; }
		} else if (!source.equals(other.source)) { return false; }
		
		if (target == null) {
			if (other.target != null) { return false; }
		} else if (!target.equals(other.target)) { return false; }
		
		return true;
	}
	
	//XXX GETTERS
	
	@Override
	public Node getSource(){
		return source;
	}

	@Override
	public Node getTarget() {
		return target;
	}
	
}
