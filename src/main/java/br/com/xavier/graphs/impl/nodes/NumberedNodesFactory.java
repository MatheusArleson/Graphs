package br.com.xavier.graphs.impl.nodes;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberedNodesFactory implements Serializable {
	
	private static final long serialVersionUID = 1297667289617456801L;
	
	private AtomicInteger currentNumber;
	
	public NumberedNodesFactory(){ 
		this.currentNumber = new AtomicInteger(0);
	}
	
	public NumberedNode createNode() {
		NumberedNode nn = new NumberedNode(currentNumber.incrementAndGet());
		return nn;
	}
	
	public LinkedHashSet<NumberedNode> createNodeSet(int size){
		LinkedHashSet<NumberedNode> nodesSet = new LinkedHashSet<NumberedNode>();
		
		if(size < 0){
			return nodesSet;
		}
		
		for (int i = 0; i < size; i++) {
			nodesSet.add(createNode());
		}
		
		return nodesSet;
	}
}
