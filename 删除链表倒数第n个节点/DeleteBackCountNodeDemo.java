package example1;

public class DeleteBackCountNodeDemo
{

    /**
     * 节点
     * @param <T>
     */
    public static class Node<T>
    {
        T value;

        Node<T> next;

        public Node()
        {

        }

        public Node(T value)
        {
            this.value = value;
        }
    }

    public static void main(String[] args)
    {
        Node<String> p1 = new Node<>();
        Node<String> a = new Node<>("aa");
        Node<String> b = new Node<>("bb");
        Node<String> c = new Node<>("cc");
        Node<String> d = new Node<>("dd");
        Node<String> e = new Node<>("ee");
        Node<String> f = new Node<>("ff");
        Node<String> p2 = new Node<>();
        p1.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = p2;


        //反转1
        Node<String> trailer = reverseLink(p1);
        //删除数据
        Node<String> header = deleteData(trailer,1);
        //header.next是删除p2
        header = reverseLink(header.next);

        Node<String > temp = a;
        while (temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    private static<T> Node<T> deleteData(Node<T> head,int count)
    {

        if (count <= 0)
        {
            return head;
        }
        int index = 0;
        Node<T> first = head;
        while (head != null && head.next != null)
        {
            if (count-1 == index)
            {
                head.next = head.next.next;
                break;
            }
            head = head.next;
            index ++;
        }
        return first;
    }


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
