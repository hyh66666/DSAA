import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainF {
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        QReader s = new QReader();
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt(), k = s.nextInt();
            Node6[] nodes = new Node6[n];
            for (int j = 0; j < n; j++) {
                Node6 temp = new Node6(j + 1);
                nodes[j] = temp;
            }
            for (int j = 0; j < n - 1; j++) {
                int num1 = s.nextInt() - 1, num2 = s.nextInt() - 1;
                Node6 cur1 = nodes[num1], cur2 = nodes[num2];
                cur1.nodes.add(cur2);
                cur2.nodes.add(cur1);
            }
            int[] friends = new int[k];
            for (int j = 0; j < k; j++) {
                friends[j] = s.nextInt();
            }
            //这里算是输入完毕吧，然后层序遍历,建立一个数组用来储存每个节点的深度
            int[] depth = new int[n];
            findDepth(depth, nodes[friends[0] - 1]);
            for (int j = 0; j < n; j++) {
                out.print(depth[j]+" ");
            }
            out.println();
            out.flush();
            int max = 0, firstCity = friends[0]-1;
            for (int friend : friends) {
                if (depth[friend - 1] > max) {
                    max = depth[friend - 1];
                    firstCity = friend - 1;
                }
            }
            for (int j = 0; j < n; j++) {
                nodes[j].isVisited = false;
                depth[j] = 0;
            }
            max = 0;
            findDepth(depth, nodes[firstCity]);
            for (int j = 0; j < n; j++) {
                out.print(depth[j]+" ");
            }
            out.println();
            out.flush();
            for (int friend : friends) {
                if (depth[friend - 1] > max) {
                    max = depth[friend - 1];
                }
            }
            if (max % 2 == 0) {
                out.println(max / 2);
            } else {
                out.println(max / 2 + 1);
            }
            out.flush();
        }
    }

    public static void findDepth(int[] depth, Node6 city) {
        int deep = 0;
        Queue queue = new LinkedList();
        Node6 cur = city;
        queue.add(cur);
        depth[city.val - 1] = deep;
        deep++;
        int size = cur.nodes.size();
        cur.isVisited = true;
        for (int j = 0; j < size; j++) {
            Node6 temp = cur.nodes.get(j);
            queue.add(temp);
            depth[temp.val - 1] = deep;
            temp.isVisited = true;
        }

        queue.poll();
        deep++;
        int count = 0, pollTimes = 0;
        while (queue.size() != 0) {
            cur = (Node6) queue.peek();
            count += cur.nodes.size() - 1;
            for (int j = 0; j < cur.nodes.size(); j++) {
                Node6 temp = cur.nodes.get(j);
                if (!temp.isVisited) {
                    queue.add(temp);
                    depth[temp.val - 1] = deep;
                    temp.isVisited = true;
                }
            }
            queue.poll();
            pollTimes++;
            if (pollTimes == size) {
                deep++;
                pollTimes = 0;
                size = count;
                count = 0;
            }
        }
    }

    static class Node6 {
        int val;
        boolean isVisited = false;
        ArrayList<Node6> nodes = new ArrayList<>();

        public Node6(int weight) {
            val = weight;
        }
    }

    static class QReader {
        BufferedReader br;
        StringTokenizer st;

        public QReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}