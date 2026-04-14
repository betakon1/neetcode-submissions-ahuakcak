class Solution {
    public boolean isValidBST(TreeNode root) {
        // Iniciamos con el rango más amplio posible
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Un árbol vacío es un BST válido
        if (node == null) {
            return true;
        }

        // El valor del nodo DEBE estar estrictamente entre min y max
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Al ir a la izquierda: el nuevo máximo es el valor del nodo actual
        // Al ir a la derecha: el nuevo mínimo es el valor del nodo actual
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}
