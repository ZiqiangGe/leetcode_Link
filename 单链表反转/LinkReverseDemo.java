package example1;

public class LinkReverseDemo
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
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node<String> head = reverseLink(a);
        while (head != null)
        {
            System.out.println(head.value);
            head = head.next;
        }
    }

    /**
     * 反转
     * @param node
     * @param <T>
     * @return 返回链表头
     */
    private static <T> Node<T> reverseLink(Node<T> node)
    {
        if (node == null || node.next == null)
        {
            return node;
        }
        Node<T> prev = null;
        while (node != null)
        {
            Node<T> tempNext = node.next;
            node.next = prev;
            prev = node;
            node = tempNext;
        }
        return prev;

    }



}
