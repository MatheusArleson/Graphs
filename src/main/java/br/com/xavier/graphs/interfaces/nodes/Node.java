package br.com.xavier.graphs.interfaces.nodes;

public interface Node {
	
	public default String getLabel(){
		return toString();
	}
	
	public abstract boolean equals(Object other);
	public abstract int hashCode();

}
