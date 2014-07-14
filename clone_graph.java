/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


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


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Solution 1: BFS iterative
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        // store the frontier of nodes in the same depth
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        // store the old graph node and their accordingly copied node pair to prevent redundant copies of nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);

        UndirectedGraphNode copyHead = new UndirectedGraphNode(node.label);
        map.put(node, copyHead);

        while(!queue.isEmpty()) {
        	UndirectedGraphNode curNode = queue.remove();
        	UndirectedGraphNode copyCur = map.get(curNode);

        	for (UndirectedGraphNode neighbor : curNode.neighbors) {

        		// the neighbor node has not been copied before
        		if (!map.containsKey(neighbor)) {
        			UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(neighbor.label);
        			map.put(neighbor, copyNeighbor);
        			copyCur.neighbors.add(copyNeighbor);
        			queue.add(neighbor);
        		}
        		// the neighbor node has been copied 
        		else {
        			UndirectedGraphNode copyNeighbor = map.get(neighbor);
        			copyCur.neighbors.add(copyNeighbor);
        		}
        	}
        }
        return copyHead;
    }
}


// Solution 2: recursion
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;

        HashMap<Integer, UndirectedGraphNode> checker = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node, checker);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> checker){
        if (checker.containsKey(node.label)){
            return checker.get(node.label);
        }
        
        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        checker.put(newNode.label,newNode);
        
        for (UndirectedGraphNode tempNode: node.neighbors){
 
            newNode.neighbors.add(clone(tempNode, checker));
        }
        
        return newNode;
    }
}

// Solution 2: DFS
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
    }
}