import java.util.Stack;

class Vertex {
        public char label;
        public boolean visited;

        public Vertex(char label) {
            this.label = label;
            this.visited = false;
        }
}

class MyGraphDFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack<Integer> theStack;

    public MyGraphDFS() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++) {
                adjMatrix[x][y] = 0;
            }
        }
        theStack = new Stack<>();
    }

    public void addVertex(char label) {
        vertexList[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].visited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < vertexCount; j++) {
            vertexList[j].visited = true;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[v][j] == 1 && vertexList[j].visited == false) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyGraphDFS g = new MyGraphDFS();
        g.addVertex('0');
        g.addVertex('1');
        g.addVertex('2');
        g.addVertex('3');
        g.addVertex('4');

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(3, 0);
        g.addEdge(4, 2);

        g.dfs();
    }
}

