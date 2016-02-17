package br.com.xavier.graphs.impl.factory;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.xavier.graphs.impl.edges.DefaultWeightedEdge;
import br.com.xavier.graphs.interfaces.Node;
import br.com.xavier.graphs.interfaces.edges.WeightedEdge;
import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.util.messages.Util;

public class WeightedEdgesFactory implements EdgeFactory, Serializable {
	
	private static final long serialVersionUID = 5629439412199692096L;

	public WeightedEdgesFactory() {}
	
	@Override
	public WeightedEdge createEdge(Node sourceNode, Node targetNode, BigDecimal weight) {
		Util.checkNullParameter(sourceNode, targetNode, weight);
		
		WeightedEdge edge = new DefaultWeightedEdge(sourceNode, targetNode, weight);
		return edge;
	}
}
