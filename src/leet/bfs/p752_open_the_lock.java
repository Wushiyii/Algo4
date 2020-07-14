package leet.bfs;

import java.util.*;

/**
 * p725 - 打开转盘锁
 * @author wgq
 * @date 2020/7/14 3:52 下午
 */
public class p752_open_the_lock {

    public int openLock(String[] deadends, String target) {

        Set<String> deadendSet = new HashSet<>(10000);
        Set<String> visitSet = new HashSet<>(10000);

        deadendSet.addAll(Arrays.asList(deadends));

        if (deadendSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visitSet.add("0000");
        int count = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                String poll = queue.poll();
                List<String> nextCodeList = getNextCode(poll);

                for (String nextCode : nextCodeList) {
                    if (!visitSet.contains(nextCode) && !deadendSet.contains(nextCode)) {
                        if (nextCode.equals(target)) {
                            return count;
                        }
                        visitSet.add(nextCode);
                        queue.add(nextCode);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public List<String> getNextCode(String now) {
        StringBuilder sb = new StringBuilder(now);
        int oldInt = 0, newInt = 0;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < now.length(); i++) {
            // 符号位+1
            oldInt = sb.charAt(i) - '0';
            newInt = (oldInt + 1) % 10;
            sb.setCharAt(i, (char) (newInt + '0'));
            list.add(sb.toString());

            // 符号位-1
            newInt = (oldInt + 9) % 10;
            sb.setCharAt(i, (char) (newInt + '0'));
            list.add(sb.toString());
            sb.setCharAt(i, (char) (oldInt + '0'));
        }
        return list;
    }



}
