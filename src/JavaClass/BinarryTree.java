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
    public int value;
    public BinarryTree r;
    public BinarryTree l;

    class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    // Добавление элемента в дерево
    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.value) {
            current.right = add(current.right, value);
        } else if (value < current.value) {
            current.left = add(current.left, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = add(root, value);
    }

    // Поиск нужного элемента в дереве
    private boolean find(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.value == value) {
            return true;
        }
        return current.value > value ? find(current.left, value) : find(current.right, value);
        // ? и : используются по принципу if и else
    }

    public boolean find(int value) {
        return find(root, value);
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
    private BinarryTree[] nearby(int value, BinarryTree parent) throws Exception {
        if (this.value == value)
            return new BinarryTree[] {parent, r, l};
        if (this.value < value && this.r != null)
            return r.nearby(value, this);
        if (this.value > value && this.l != null)
            return l.nearby(value, this);
        throw new Exception("Узел не существует");
    }

    public BinarryTree[] nerby(int value) throws Exception {
        return nearby(value, null);
    }

}
