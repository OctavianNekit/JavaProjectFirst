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

        private void add(int value) {
            if (value > this.value) {
                if (right == null) {
                    right = new Node(value);
                }
                else right.add(value);
            } else if (value < this.value) {
                if (left == null) {
                    left = new Node(value);
                }
                else left.add(value);
            }
        }

        // Поиск нужного элемента в дереве

        private boolean find(int value) {
            if (this.value == value) {
                return true;
            }
            if (this.value > value) {
                if (left != null) {
                    return left.find(value);
                }
            }
            if (this.value < value) {
                if (right != null) {
                    return right.find(value);
                }
            } return false;
        }

        // Удаление элемента из дерева
        private Node delete(int value) {
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
            // ? и : используются по принципу if и else
        }

        // Поиск значения и его соседей
        private Node[] nearby(int value, Node parent) throws Exception {
            if (this.value == value) {
                return new Node[] {parent, this.right, this.left};
            }
            if (this.value < value && this.right != null) {
                return this.right.nearby(value, parent);
            }
            if (this.value > value && this.left != null) {
                return this.left.nearby(value, parent);
            }
            throw new Exception("Узел не существует");
        }
    }

    Node root;

    public void add(int value) { root.add(value); }

    public boolean find(int value) {
        return root.find(value);
    }

    public void delete(int value) {
        root = root.delete(value);
    }

    public Node[] nearby(int value, Node parent) throws Exception {
        return root.nearby(value, parent);
    }
}
