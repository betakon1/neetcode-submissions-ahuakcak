/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // ¡Encontramos el nodo a eliminar!
            
            // Caso 1 y 2: Nodo con un solo hijo o sin hijos
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Caso 3: Nodo con dos hijos
            // Buscamos el sucesor (el más pequeño del subárbol derecho)
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val; // Reemplazamos el valor
            // Eliminamos el sucesor en el subárbol derecho
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
