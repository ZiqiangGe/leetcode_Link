package example1;

import java.util.ArrayList;

/**
 * 检测链表是否循环
 */
public class LinkCycleCheck
{
    /**
     * 节点
     * @param <T>
     */
    public static class Node<T>
    {
        T value;

        boolean flag = false;

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
        e.next = a;
        boolean flag = hasCycle1(a);
        boolean flag1 = hasCycle2(a);
        System.out.println("flag "+ flag);
        System.out.println("flag1 "+ flag1);
    }

    /**
     * 节点添加标志位
     * @param node
     * @param <T>
     * @return
     */
    public static<T> boolean hasCycle2(Node<T> node)
    {
        //空
        if (node == null)
        {
            return false;
        }

        //1个
        if (node == node.next)
        {
            return true;
        }
        while (node != null)
        {
            node.flag = true;
            if (node.next == null)
            {
                return false;
            }
            else
            {
                if (node.next.flag == true)
                {
                    return true;
                }
            }
            node = node.next;
        }

        return false;
    }


    /**
     * 处理过的节点放入集合中
     * @param node
     * @param <T>
     * @return
     */
    public static<T> boolean hasCycle1(Node<T> node)
    {
        //空
        if (node == null)
        {
            return false;
        }

        //1个循环，不需要创建集合了
        if (node == node.next)
        {
            return true;
        }

        ArrayList<Node<T>> list = new ArrayList<>();
        while (node != null)
        {
            if (list.contains(node))
            {
                return true;
            }
            list.add(node);
            node = node.next;
        }
        return false;
    }



}
