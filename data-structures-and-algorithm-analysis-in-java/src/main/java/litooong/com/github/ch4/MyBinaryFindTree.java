package litooong.com.github.ch4;

import java.nio.BufferUnderflowException;

public class MyBinaryFindTree<T extends Comparable<? super T>> {

    // 根
    private BinaryNode<T> root;

    public MyBinaryFindTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).element;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    public void remove(T data) {
        root = remove(data, root);
    }

    public void printTree() {

    }


    private boolean contains(T data, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }

        int compareResult = data.compareTo(node.element);
        if (compareResult < 0) {
            return contains(data, node.left);
        } else if (compareResult > 0) {
            return contains(data, node.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        // 使用递归
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        // 不使用递归
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }
        return node;
    }

    private BinaryNode<T> insert(T data, BinaryNode<T> node) {
        // 1. 不能加入 null
        if (data == null) {
            return node;
        }
        // 2. 如果node为 null
        if (node == null) {
            BinaryNode<T> newNode = new BinaryNode<>(data);
            return newNode;
        }

        int compareResult = data.compareTo(node.element);
        if (compareResult > 0) {
            node.right = insert(data, node.right);
        } else if (compareResult > 0) {
            node.left = insert(data, node.left);
        } else {
            // do-nothing
        }

        return node;
    }

    private BinaryNode<T> remove(T data, BinaryNode<T> node) {
        // 1. 排除 null
        if (data == null || node == null) {
            return node;
        }
        int compareResult = data.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(data, node.left);
        } else if (compareResult > 0) {
            node.right = remove(data, node.right);
        } else if (node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private void printTree(BinaryNode<T> node) {
    }


    // 节点
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
