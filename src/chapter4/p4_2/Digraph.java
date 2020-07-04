package chapter4.p4_2;

/**
 * 有向图定义
 * @author wgq
 * @date 2020/7/2 2:43 下午
 */
public abstract class Digraph {

    /**
     * @return 顶点数
     */
    abstract int V();

    /**
     * @return 边数
     */
    abstract int E();

    /**
     * 向有向图增加一条边 v -> w
     */
    abstract void addEdge(int v, int w);

    /**
     * @return v的出边对应的邻接顶点
     */
    abstract Iterable<Integer> adj(int v);

    /**
     * @return 此有向图的反向图
     */
    abstract Digraph reverseGraph();

    /**
     * 计算顶点v的度数
     */
    public int degree(int v) {
        int degree = 0;
        for (Integer ignored : adj(v)) {
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
