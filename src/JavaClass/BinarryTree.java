/*
Бинарное дерево поиска
Задача:
Хранит целые числа в виде бинарного дерева поиска.
Дерево не может содержать одно и тоже число
более одного раза.
Методы:
1.Добавление числа.
2.Удаление числа.
3.Поиск числа в дереве.
4.Определение соседей числа в дереве(предок, левый потомок, правый потомок).
 */
package JavaClass;

public class BinarryTree {

    public BinarryTree(int value) {
        this.root = new Node(value);
    }

    class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }

        // Добавление элемента в дерево

        private Node add(int value) {
            if (this == null) {
                return new Node(value);
            }
            if (value > this.value) {
                this.right = right.add(value);
            } else if (value < this.value) {
                this.left = left.add(value);
            }
                return this;
        }

        // Поиск нужного элемента в дереве

        private boolean find(int value) {
            if (this == null) {
                return false;
            }
            if (this.value == value) {
                return true;
            }
            return this.value > value ? find(left.value) : find(right.value);
            // ? и : используются по принципу if и else
        }
    }

    Node root;

    public void add(int value) {
        root = root.add(value);
    }

    public boolean find(int value) {
        return root.find(value);
    }

    // Удаление элемента из дерева
    private Node delete(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (current.value == value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;
        }
        if (current.value < value) {
            current.left = delete(current.left, value);
            return current;
        }

        current.right = delete(current.right, value);
        return current;
    }
    // Поиск минимального значения
    private int findSmallValue(Node root) {
        return root.left == null ? root.value : findSmallValue(root.left);
    }
    public void delete(int value) {
        root = delete(root, value);
    }

    // Поиск числа и его соседей
    private BinarryTree nearby(int value, BinarryTree parent) throws Exception {
        if (this.root == value)
            return new Node;
        if (this.value < value && this.r != null)
            return Node.nearby(value, this);
        if (this.value > value && this.l != null)
            return Node.nearby(value, this);
        throw new Exception("Узел не существует");
    }

    public BinarryTree[] nearby(int value) throws Exception {
        return nearby(value, null);
    }

}
