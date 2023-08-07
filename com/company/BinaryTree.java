package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<K extends Comparable<K>, V> implements Iterable<BinaryTree.Entry<K, V>>
{
    private Node root;
    private int size;

    public BinaryTree()
    {
        this.root=null;
        this.size=0;
    }

    public void put(K key, V value)
    {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value)
    {
        if (node==null)
        {
            size++;
            return new Node(key, value);
        }

        int cmp=key.compareTo(node.key);
        if (cmp<0)
        {
            node.left=put(node.left, key, value);
        }
        else if (cmp>0)
        {
            node.right=put(node.right, key, value);
        }
        else
        {
            node.value=value;
        }
        return node;
    }

    public V get(K key)
    {
        Node node=get(root, key);
        return node!=null ? node.value:null;
    }

    private Node get(Node node, K key)
    {
        if (node==null)
        {
            return null;
        }
        int cmp=key.compareTo(node.key);
        if (cmp<0)
        {
            return get(node.left, key);
        }
        else if (cmp>0)
        {
            return get(node.right, key);
        }
        else
        {
            return node;
        }
    }

    public boolean contains(K key)
    {
        return get(key)!=null;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }


    @Override
    public Iterator<Entry<K, V>> iterator()
    {
        return new EntryIterator();
    }

    private class Node
    {
        private K key;
        private V value;
        private Node left;
        private Node right;

        Node(K key, V value)
        {
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    public class Entry<K, V>
    {
        K key;
        V value;
        public Entry(K key, V value)
        {
            this.key=key;
            this.value=value;
        }
    }

    private class EntryIterator implements Iterator<Entry<K, V>>
    {
        private Stack<Node> stack=new Stack<>();
        private Node current=root;

        @Override
        public boolean hasNext()
        {
            return current != null || !stack.isEmpty();
        }
        @Override
        public Entry<K, V> next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            Node node=stack.pop();
            current=node.right;
            return new Entry<>(node.key, node.value);
        }
    }

    public Entry<K, V> find(K key)
    {
        Node node = find(root, key);
        return node != null ? new Entry<>(node.key, node.value) : null;
    }

    private Node find(Node node, K key)
    {
        if (node==null)
        {
            return null;
        }
        int cmp=key.compareTo(node.key);
        if (cmp<0)
        {
            return find(node.left, key);
        }
        else if (cmp>0)
        {
            return find(node.right, key);
        }
        else
        {
            return node;
        }
    }


}
