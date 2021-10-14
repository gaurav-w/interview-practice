package Graphs;


// Java implementation of the approach

import java.util.*;

// Class to represent the graph
class Graph {

    private List<GraphNode> nodes;

    // Constructor to create an empty ArrayList
    // to store the nodes of the graph
    public Graph() {
        this.nodes = new ArrayList<GraphNode>();
    }

    // Constructor to set the graph's nodes
    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
        this.nodes = new ArrayList<GraphNode>();
    }

    // Function to add a node to the graph
    public void addNode(GraphNode node) {
        this.nodes.add(node);
    }

    // Function to return the list of nodes
    // for the graph
    public List<GraphNode> getNodes() {
        return this.nodes;
    }
}

// GraphNode class represents each
// Node of the Graph
class GraphNode {

    private int data;
    private List<GraphNode> children;

    // Constructor to initialize the node with value
    public GraphNode(int data) {
        this.data = data;
        this.children = new ArrayList<GraphNode>();
    }

    // Function to add a child to the current node
    public void addChild(GraphNode node) {
        this.children.add(node);
    }

    // Function to return a list of children
    // for the current node
    public List<GraphNode> getChildren() {
        return children;
    }

    // Function to set the node's value
    public void setData(int data) {
        this.data = data;
    }

    // Function to return the node's value
    public int getData() {
        return data;
    }
}

class GFG {

    // Function to clone the graph

    /**
     * Iterate over every Node of the graph and do a BFS
     * THe BFS should crate the cloned version of every node
     * <p>
     * ITerate over the keys of map to get the graph
     *
     * @param graph
     * @return
     */
    public Graph cloneGraph(Graph graph) {
        HashMap<GraphNode, GraphNode> map = new HashMap<>();

        for (int i = 0; i < graph.getNodes().size(); i++) {
            if (!map.containsKey(graph.getNodes().get(i)))
                cloneConnectedComponent(graph.getNodes().get(i), map);
        }
        Graph copyGraph = new Graph();
        for (Map.Entry<GraphNode, GraphNode> entry : map.entrySet()) {
            copyGraph.addNode(entry.getValue());
        }

        return copyGraph;
    }

    // Function to clone the connected components

    /**
     * Do the BFS
     *
     * @param node
     * @param map
     */
    private void cloneConnectedComponent(GraphNode node,
                                         Map<GraphNode, GraphNode> map) {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);


        while (!q.isEmpty()) {

            GraphNode currNode = q.poll();
            GraphNode copyNode = map.get(currNode);

            if (copyNode == null) {
                copyNode = new GraphNode(currNode.getData());
                map.put(currNode, copyNode);
            }

            for (int i = 0; i < currNode.getChildren().size(); i++) {
                GraphNode childNode = currNode.getChildren().get(i);

                GraphNode copyChildNode = map.get(childNode);
                if (copyChildNode == null) {
                    copyChildNode = new GraphNode(childNode.getData());
                    map.put(childNode, copyChildNode);
                    q.add(childNode);
                }
                copyNode.addChild(copyChildNode);


            }
        }
    }


    // Function to build the graph
    public Graph buildGraph() {

        // Create graph
        Graph g = new Graph();

        // Adding nodes to the graph
        GraphNode g1 = new GraphNode(1);
        g.addNode(g1);
        GraphNode g2 = new GraphNode(2);
        g.addNode(g2);
        GraphNode g3 = new GraphNode(3);
        g.addNode(g3);
        GraphNode g4 = new GraphNode(4);
        g.addNode(g4);
        GraphNode g5 = new GraphNode(5);
        g.addNode(g5);
        GraphNode g6 = new GraphNode(6);
        g.addNode(g6);

        // Adding edges
        g1.addChild(g2);
        g1.addChild(g3);
        g2.addChild(g1);
        g2.addChild(g4);
        g3.addChild(g1);
        g3.addChild(g4);
        g4.addChild(g2);
        g4.addChild(g3);
        g5.addChild(g6);
        g6.addChild(g5);

        return g;
    }

    // Function to print the connected components
    public void printConnectedComponent(GraphNode node,
                                        Set<GraphNode> visited) {
        if (visited.contains(node))
            return;

        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(node);

        while (!q.isEmpty()) {
            GraphNode currentNode = q.remove();
            if (visited.contains(currentNode))
                continue;
            visited.add(currentNode);
            System.out.println("Node "
                    + currentNode.getData() + " - " + currentNode);
            for (GraphNode child : currentNode.getChildren()) {
                System.out.println("\tNode "
                        + child.getData() + " - " + child);
                q.add(child);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        GFG gfg = new GFG();
        Graph g = gfg.buildGraph();

        // Original graph
        System.out.println("\tINITIAL GRAPH");
        Set<GraphNode> visited = new HashSet<GraphNode>();
        for (GraphNode n : g.getNodes())
            gfg.printConnectedComponent(n, visited);

        // Cloned graph
        System.out.println("\n\n\tCLONED GRAPH\n");
        Graph cloned = gfg.cloneGraph(g);
        visited = new HashSet<GraphNode>();
        for (GraphNode node : cloned.getNodes())
            gfg.printConnectedComponent(node, visited);
    }
}
