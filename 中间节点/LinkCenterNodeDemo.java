package example1;

public class LinkCenterNodeDemo
{
    /**
     * 节点
     * @param <T>
     */
    public static class Node<T>
    {
        T value;

        Node<T> next;

        public Node(T value)
        {
            this.value = value;
        }
    }

    public static void main(String[] args)
    {
        Node<String> a = new Node<>("aa");
        Node<String> b = new Node<>("bb");
        Node<String> c = new Node<>("cc");
        Node<String> d = new Node<>("dd");
        Node<String> e = new Node<>("ee");
        Node<String> f = new Node<>("ff");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        Node<String>[] centers = centerNode(a);
        for (Node<String> node :centers)
        {
            if (node != null)
            {
                System.out.println(node.value);
            }
        }

    }

    public static <T> Node<T>[] centerNode(Node<T> head)
    {
        Node<T>[] nodes = new Node[2];
        if (head == null || head.next == null)
        {
            nodes[0] = head;
            return nodes;
        }
        Node<T> prev = head;
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next !=null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (fast == null)
        {
            nodes[0] = prev;
            nodes[1] = slow;
        }
        else
        {
            nodes[0] = slow;
        }
        return nodes;
    }





}
