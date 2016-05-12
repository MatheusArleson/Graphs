package br.com.xavier.graphs.abstractions;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.Util;
import br.com.xavier.matrix.impl.indexed.DefaultSquareObjectIndexedMatrix;

public abstract class AdjacencyMatrixGraph<N extends AbstractNode, E extends Edge<N>> extends MapBackedGraph<N,E> {
	
	private DefaultSquareObjectIndexedMatrix<N, Integer> graphMatrix;
	
	public AdjacencyMatrixGraph(
		boolean isDirected, boolean isWeighted, 
		boolean loopsAllowed, boolean multipleEdgesAllowed
	) {
		super(isDirected, isWeighted, loopsAllowed, multipleEdgesAllowed);
		
		try {
			this.graphMatrix = new DefaultSquareObjectIndexedMatrix<N, Integer>();
		} catch (Exception e) {
			//FIXME TODO put in external string
			throw new RuntimeException("Error creation internal matrix.");
		}
	}
	
	//------------------------------------------
	// 			NODES METODS
	//------------------------------------------
	
	@Override
	public boolean addNode(N node) throws NullPointerException {
		boolean nodeAdded = super.addNode(node);
		if(!nodeAdded){
			return false;
		}
		
		graphMatrix.addColumAndRow(node);
		return true;
	}
	
	@Override
	public boolean removeNode(N node) throws NullPointerException {
		boolean nodeRemoved = super.removeNode(node);
		if(!nodeRemoved){
			return false;
		}
		
		graphMatrix.removeColumAndRow(node);
		return true;
	}
	
	//------------------------------------------
	// 			EDGES METODS
	//------------------------------------------
	
	@Override
	public boolean containsEdge(E edge) throws NullPointerException {
		Util.checkNullParameter(edge);
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		Integer matrixElement = graphMatrix.get(sourceNode, targetNode);
		boolean isNotPresent = graphMatrix.checkEmpty(matrixElement);
		
		return !isNotPresent;
	}
	
	@Override
	public boolean existsEdge(N sourceNode, N targetNode) throws IllegalNodeException, NullPointerException {
		Util.checkIllegalNode(this, sourceNode, targetNode);
		
		if(!isLoopsAllowed() && sourceNode.equals(targetNode)){
			return false;
		}
		
		Integer matrixElement = graphMatrix.get(sourceNode, targetNode);
		boolean isNotPresent = graphMatrix.checkEmpty(matrixElement);
		
		return !isNotPresent;
	}

	@Override
	public boolean addEdge(E edge) throws IllegalNodeException, NullPointerException {
		boolean isAdded = super.addEdge(edge);
		if(!isAdded){
			return false;
		}
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		
		graphMatrix.set(sourceNode, targetNode, 1);
		
		if(!isDirected()){
			graphMatrix.set(targetNode, sourceNode, 1);
		}
		
		return true;
	}
	
	public boolean removeEdge(E edge) throws NullPointerException {
		boolean edgeRemoved = super.removeEdge(edge);
		if(!edgeRemoved){
			return false;
		}
		
		N sourceNode = edge.getSource();
		N targetNode = edge.getTarget();
		graphMatrix.set(sourceNode, targetNode, graphMatrix.representsEmpty());
		
		if(!isDirected()){
			graphMatrix.set(targetNode, sourceNode, graphMatrix.representsEmpty());
		}
		
		return true;
	}
	
}
