package br.com.xavier.graphs.interfaces;

public interface Node {
	
	public String getLabel();
	public abstract boolean equals(Object other);
	public abstract int hashCode();

}
