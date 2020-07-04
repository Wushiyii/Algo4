package chapter4.p4_1;

/**
 * @author wgq
 * @date 2020/6/30 8:02 下午
 */
public interface GraphSearch {

    /**
     * 判断起点s与v是否连通
     * @param v v顶点
     * @return true/false
     */
    boolean marked(int v);


    /**
     * 计算与起点s连通的顶点总数
     * @return 总数
     */
    int count();
}
