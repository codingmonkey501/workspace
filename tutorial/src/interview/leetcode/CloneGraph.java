package interview.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

	
	/**
	 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


		OJ's undirected graph serialization:
		Nodes are labeled uniquely.
		
		We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
		As an example, consider the serialized graph {0,1,2#1,2#2,2}.
		
		The graph has a total of three nodes, and therefore contains three parts as separated by #.
		
		First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
		Second node is labeled as 1. Connect node 1 to node 2.
		Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
		Visually, the graph looks like the following:
		
		       1
		      / \
		     /   \
		    0 --- 2
		         / \
		         \_/
	 */
	public static void main(String[] args) {

	}
	
	
	
	/**
	 * I am not sure wether you understand correctly the problem or not. In this
	 * problem, the graph is not given by an adjacency list or an adjacency
	 * matrix as you are describing. We are dealing here with a graph of
	 * objects. Each object contains a list of its neighbors. So if a node node1
	 * has node2 in its neighbors list, then node2 will also have node1 in its
	 * own neighbors list since the graph is undirected.
	 * 
	 * You do not need to understand what {0,1,2#1,2#2,2} to solve the problem.
	 * Your code will never deal with inputs that look like that. (You have to
	 * understand it however to debug your code as the online judge will show
	 * you the inputs of the tests serialized this way.)
	 * 
	 * {0,1,2#1,2#2,2} is the serialization of an undirected graph, it is not
	 * the concatenation of the adjacency lists. It is implied that this
	 * represents an undirected graph. 0,1,2 means that there is an edge between
	 * 0 and 1, and an edge between 0 and 2. There is no need later in
	 * serialization to encode again the edge between 1 and 0 since it has
	 * already been encoded.
	 */
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<Integer, UndirectedGraphNode> visted = new HashMap<Integer, UndirectedGraphNode>();
		UndirectedGraphNode firstnode = new UndirectedGraphNode(node.label);
		visted.put(firstnode.label, firstnode);
		
		DFS(node, firstnode, visted);
		return firstnode;

	}

	public void DFS(UndirectedGraphNode node, UndirectedGraphNode from,
			Map<Integer, UndirectedGraphNode> visitedMap) {

		for (UndirectedGraphNode neighbor : node.neighbors) {
			
			if (visitedMap.containsKey(neighbor.label)) {
				
				//if visited
				UndirectedGraphNode exist = visitedMap.get(neighbor.label);
				from.neighbors.add(exist);
			
			} else {
				
				//if not visited
				UndirectedGraphNode newneighbor = new UndirectedGraphNode(neighbor.label);
				visitedMap.put(newneighbor.label, newneighbor);
				from.neighbors.add(newneighbor);
				DFS(neighbor, newneighbor, visitedMap);
			}

		}

	}
	
	public class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

}
