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

        // Удаление элемента из дерева
        private Node delete(int value) {
            if (this == null) {
                return null;
            }

            if (this.value == value) {
                if (this.left == null && this.right == null) {
                    return null;
                }
                if (this.right == null) {
                    return this.left;
                }
                if (this.left == null) {
                    return this.right;
                }
                int smallestValue = findSmallValue(this.right);
                this.value = smallestValue;
                this.right = this.right.delete(smallestValue);
                return this;
            }
            if (this.value < value) {
                this.left = this.left.delete(value);
                return this;
            }

            this.right = delete(value);
            return this;
        }
        // Поиск минимального значения
        private int findSmallValue(Node root) {
            return root.left == null ? root.value : findSmallValue(root.left);
        }

        // Поиск числа и его соседей
        private Node[] nearby(int value, Node parent) throws Exception {
            if (this.value == value) {
                return new Node[] {parent, this.right, this.left};
            }
            if (this.value < value && this.right != null) {
                return this.right.nearby(this.value, parent);
            }
            if (this.value > value && this.left != null) {
                return this.left.nearby(this.value, parent);
            }
            throw new Exception("Узел не существует");
        }
    }

    Node root;

    public void add(int value) {
        root = root.add(value);
    }

    public boolean find(int value) {
        return root.find(value);
    }

    public void delete(int value) {
        root = root.delete(value);
    }

    public BinarryTree[] nearby(int value) throws Exception {
        return nearby(value, null);
    }

}
