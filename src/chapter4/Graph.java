package chapter4;

/**
 * @author wgq
 * @date 2020/6/30 4:15 下午
 */
public abstract class Graph {

    /**
     * 顶点数
     */
    abstract int V();

    /**
     * 边数
     */
    abstract int E();

    /**
     * 向图中增加一条v到w的边
     */
    abstract void addEdge(int v, int w);

    /**
     * 和v相邻的所有顶点
     */
    abstract Iterable<Integer> adj(int v);

    /**
     * 计算顶点v的度数
     */
    public int degree(int v) {
        int degree = 0;
        for (Integer w : adj(v)) {
            degree ++;
        }
        return degree;
    }
    /**
     * 最大度数
     */
    public int maxDegree() {
        int max = 0;
        for (int v = 0; v < V(); v++) {
            int vDegree = degree(v);
            if (vDegree > max) {
                max = vDegree;
            }
        }
        return max;
    }

    /**
     * 平均度数
     */
    public double avgDegree() {
        return 2 * E() / V();
    }

    /**
     * 自环数
     */
    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V(); v++) {
            for (Integer w : adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        // 每条边都被记过两次
        return count / 2;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("V:" + V() + ", E:" + E() + "\n");
        for (int v = 0; v < V(); v++) {
            s.append(v).append(": ");
            for (Integer w : adj(v)) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
