package br.com.xavier.graphs.impl.factory;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.xavier.graphs.impl.nodes.NumberedNode;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class NumberedNodesFactory implements NodeFactory, Serializable {
	
	private static final long serialVersionUID = 1297667289617456801L;
	
	private AtomicInteger currentNumber;
	
	public NumberedNodesFactory(){ 
		this.currentNumber = new AtomicInteger(0);
	}
	
	@Override
	public NumberedNode createNode() {
		NumberedNode nn = new NumberedNode(currentNumber.incrementAndGet());
		return nn;
	}
}
