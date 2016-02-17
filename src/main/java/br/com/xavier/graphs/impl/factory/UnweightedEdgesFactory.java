package br.com.xavier.graphs.impl.factory;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.xavier.graphs.impl.edges.DefaultUnweightedEdge;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.util.messages.Util;

public class UnweightedEdgesFactory implements EdgeFactory, Serializable {
	
	private static final long serialVersionUID = 1512147361298600511L;

	public UnweightedEdgesFactory() { }
	
	@Override
	public DefaultUnweightedEdge createEdge(Node sourceNode, Node targetNode, BigDecimal weight) {
		Util.checkNullParameter(sourceNode, targetNode);
		
		DefaultUnweightedEdge edge = new DefaultUnweightedEdge(sourceNode, targetNode);
		return edge;
	}

}
