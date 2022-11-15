package org.mhiginio.courseschedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[0], prerequisite[1]);
        }
        return !new GraphCycleDetector(graph).isCyclic();
    }

    private static class Graph {
        private final int nodes;
        private Map<Integer, Set<Integer>> adj;

        public Graph(int nodes) {
            this.nodes = nodes;
            adj = new HashMap<>();
        }

        public void addEdge(int origin, int destination) {
            adj.computeIfAbsent(origin, k -> new HashSet<>()).add(destination);
        }

    }

    private static class GraphCycleDetector {
        private Graph graph;
        boolean[] visited;
        boolean[] recursive;

        public GraphCycleDetector(Graph graph) {
            this.graph = graph;
            visited = new boolean[graph.nodes];
            recursive = new boolean[graph.nodes];
        }

        public boolean isCyclic() {
            for (int i = 0; i < graph.nodes; i++) {
                if (isCyclic(i)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isCyclic(int node) {
            if (recursive[node]) {
                return true;
            }
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            recursive[node] = true;

            if (anyChildrenIsCyclic(node)) {
                return true;
            }

            recursive[node] = false;
            return false;
        }

        private boolean anyChildrenIsCyclic(int node) {
            Set<Integer> children = graph.adj.getOrDefault(node, Collections.emptySet());
            for (Integer child : children) {
                if (isCyclic(child)) {
                    return true;
                }
            }
            return false;
        }
    }
}