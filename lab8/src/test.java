import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static class Node implements Comparable<Node> {
        public int getValue() {
            return value;
        }

        private int value;

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        private Node leftNode;

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        private Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        //getter   setter   toString

        //前序遍历
        public void preOrder() {
            System.out.println(this.value);
            if (this.getLeftNode() != null) {
                this.getLeftNode().preOrder();
            }
            if (this.getRightNode() != null) {
                this.getRightNode().preOrder();
            }
        }

        private Node getRightNode() {
            return rightNode;
        }

        private Node getLeftNode() {
            return leftNode;
        }

        @Override
        public int compareTo(Node o) {
            //从小到大
            return this.value - o.value;
        }
    }

    public static class HuffmanTree {
        public static void main(String[] args) {
            int[] array = {5,1,9,2};
            Node root = createHuffmanTree(array);
            System.out.println(root.value);
            preOrder(root);
        }

        public static void preOrder(Node node) {
            if (node == null) {
                return;
            } else {
                node.preOrder();
            }
        }

        public static Node createHuffmanTree(int[] array) {
            ArrayList<Node> nodes = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                nodes.add(new Node(array[i]));
            }
            while (nodes.size() > 1) {
//                Collections.sort(nodes);
                mergeSort(nodes);
                System.out.println(nodes);

                Node node1 = nodes.get(0);//排完序第一个元素最小
                Node node2 = nodes.get(1);
                Node newNode = new Node(node1.getValue() + node2.getValue());
                newNode.setLeftNode(node1);//左子节点的值小于右子节点
                newNode.setRightNode(node2);

                nodes.remove(node1);
                nodes.remove(node2);

                nodes.add(newNode);
            }
            return nodes.get(0);

        }
    }
    public static void mergeSort(ArrayList<Node> arrayList1){
        int length= arrayList1.size();
        int mid=length/2;
        if(length>1){
            ArrayList<Node>left = new ArrayList<>();
            ArrayList<Node>right = new ArrayList<>();
            for (int i = 0; i < mid; i++) {
                left.add(arrayList1.get(i));
            }
            for (int i = mid; i < length; i++) {
                right.add(arrayList1.get(i));
            }
            mergeSort(left);
            mergeSort(right);
            merge(arrayList1,left,right);
        }
    }
    public static void merge(ArrayList<Node> arrayList1, ArrayList<Node>left, ArrayList<Node>right){
        int i=0,j=0,n=0;
        while(i<left.size()&&j<right.size()){
            if(left.get(i).value<=right.get(j).value){
                arrayList1.set(n,left.get(i));
                i++;
            }else{
                arrayList1.set(n,right.get(j));
                j++;
            }
            n++;
        }
        while(j<right.size()){
            arrayList1.set(n,right.get(j));
            n++;
            j++;
        }
        while(i<left.size()){
            arrayList1.set(n,left.get(i));
            n++;
            i++;
        }
    }
}
