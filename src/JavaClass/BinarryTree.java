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

import org.junit.platform.engine.support.hierarchical.Node;

public class BinarryTree {

    public BinarryTree(int value) {
        this.root = new Node(value);
    }

    public class Node {
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
            // Сравниваем числа
            if (value > this.value) {
                // Если число больше то оно пойдет направо
                if (right == null) {
                    // Если до этого числа справа не было, то создается новая ветка
                    right = new Node(value);
                }
                // Иначе просто идет направо
                else right.add(value);
            } else if (value < this.value) {
                // Если число меньше то идет налево
                if (left == null) {
                    // Если до этого числа слева не было, то создается новая ветка
                    left = new Node(value);
                }
                // Иначе просто идет налево
                else left.add(value);
            }
        }

        // Поиск нужного элемента в дереве

        private boolean find(int value) {
            // Если элементы равны, то это и есть искомый элемент
            if (this.value == value) {
                return true;
            }
            if (this.value > value) {
                // Если элемент меньше и слева есть ветка, то идем налево
                if (left != null) {
                    return left.find(value);
                }
            }
            if (this.value < value) {
                // Если элемент больше и справа есть ветка, то идем направо
                if (right != null) {
                    return right.find(value);
                }
            } return false;
        }

        // Удаление элемента из дерева
        private Node delete(int value) {
            // Сравниваем элементы
            if (this.value == value) {
                if (this.left == null && this.right == null) {
                    // Если элемнты равны и у него нет предков то удаляем его и возвращаем null
                    return null;
                }
                if (this.right == null) {
                    // Если нет правого предка, то возвращаем левого предка
                    return this.left;
                }
                if (this.left == null) {
                    // Если нет левого предка, то возвращаем правого предка
                    return this.right;
                }
                int smallestValue = findSmallValue(this.right);
                this.value = smallestValue;
                this.right = this.right.delete(smallestValue);
                return this;
            }
            if (this.value < value && right != null) {
                // Если значение больше текущего и правое не пустое, то идем по правой ветке
                this.right = this.right.delete(value);
            }
            if (this.value > value && left != null) {
                // Если значение меньше текущего и левое не пустое, то идем по левой ветке
                this.left = this.left.delete(value);
            }
            return this;
        }
        // Поиск минимального значения
        private int findSmallValue(Node root) {
            // Если левого предка нет то данное значение и есть минимальным, иначе идем налево, и там делаем тоже самое
            return root.left == null ? root.value : findSmallValue(root.left);
            // ? и : используются по принципу if и else
        }

        // Поиск значения и его соседей
        private Node[] nearby(int value, Node parent) throws Exception {
            if (this.value == value) {
                // Если значения равны, мы возвращаем массив
                return new Node[] {parent, this.right, this.left};
            }
            if (this.value < value && this.right != null) {
                // Если данное значение больше и правый ребенок не пуст, то мы идем по правой ветке и применяем метод к правому значению
                return this.right.nearby(value, this);
            }
            if (this.value > value && this.left != null) {
                // Если данное значение меньше и левый ребенок не пуст, то мы идем по левой ветке и применяем метод к левому значению
                return this.left.nearby(value, this);
            }
            // Возвращаем исключение
            throw new Exception("Узел не существует");
        }
        // Возвратить значение
        public int getValue() {
            return value;
        }
    }

    Node root;

    public void add(int value) { root.add(value); }

    public boolean find(int value) {
        return root.find(value);
    }

    public void delete(int value) { root = root.delete(value); }

    public Node[] nearby(int value) throws Exception { return root.nearby(value, null); }
}
