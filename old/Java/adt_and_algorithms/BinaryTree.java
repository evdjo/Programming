package abtract_data_types;

/**
 * Abstract data type representing Binary Search Tree.
 *
 * @author Evdzhan Mustafa
 * @version 1.0
 * @see TreeNode
 */


@SuppressWarnings("unused")
public class BinaryTree {


    private TreeNode root;

    /**
     * Check if the tree is empty
     *
     * @return true if the linked list is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Adds node to the Tree.
     *
     * @param key  the key to which the node will correspond
     * @param data the data to be held in the node - any object
     */
    public void addNode(int key, Object data) {
        TreeNode node = new TreeNode(key, data);

        if (root == null) { // the tree is empty , the new node becomes root.

            root = node;

        } else {

            TreeNode current = root;

            TreeNode parent;

            while (true) {

                parent = current;

                if (key < current.getKey()) { // comparison to decide where to branch on - left or right

                    current = current.getLeft();

                    if (current == null) {

                        parent.setLeft(node);
                        return;
                    }

                } else {

                    current = current.getRight();

                    if (current == null) {

                        parent.setRight(node);
                        return;
                    }


                }
            }
        }
    }

    /**
     * Traverse the left subtree. Visit the root. Finally traverse the right subtree.
     *
     * @param node where to start from.
     */
    public void orderTraverse(TreeNode node) {
        if (node != null) {

            orderTraverse(node.getLeft());

            System.out.println(node.toString());

            orderTraverse(node.getRight());


        }
    }

    /**
     * Visit the root. Traverse the left subtree. Finally traverse the right subtree.
     *
     * @param node where to start from.
     */
    public void preOrderTraverse(TreeNode node) {
        if (node != null) {

            System.out.println(node.toString());

            preOrderTraverse(node.getLeft());

            preOrderTraverse(node.getRight());

        }
    }

    /**
     * Traverse the left subtree. Then traverse the right subtree. Finally visit the root.
     *
     * @param node where to start from.
     */
    public void postOrderTraverse(TreeNode node) {
        if (node != null) {

            postOrderTraverse(node.getLeft());

            postOrderTraverse(node.getRight());

            System.out.println(node.toString());

        }
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Finds the node with the corresponding key value.
     *
     * @param key the key looked for
     * @return The tree node if found , else null
     */
    public TreeNode find(int key) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;

        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    /**
     * Removes the Node with the corresponding key value.
     *
     * @param key the node with that key, to be removed
     * @return true if deleted, false if the element doesn't exist
     */
    public boolean remove(int key) {
        if (root == null) {
            return false;
        } // the tree is empty, cant remove

        TreeNode current = root;
        TreeNode parent = root;

        boolean isLeftChild = true;
        while (current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }

        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else {
            TreeNode toReplace = findReplacement(current);
            if (current == root) {
                root = toReplace;
            } else if (isLeftChild) {
                parent.setLeft(toReplace);
            } else {
                parent.setRight(toReplace);
            }

            toReplace.setLeft(current.getLeft());

        }

        return true;
    }

    /**
     * Used in the delete method. Finds best match when the deleted Node, has 2 children.
     */
    private TreeNode findReplacement(TreeNode current) {
        TreeNode parent = current;
        TreeNode replacement = current;

        TreeNode cursor = current.getRight();

        while (cursor != null) {
            parent = replacement;
            replacement = cursor;
            cursor = cursor.getLeft();
        }
        if (replacement != current.getRight()) {
            parent.setLeft(replacement.getRight());
            replacement.setRight(current.getRight());

        }

        return replacement;
    }
}


