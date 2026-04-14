class Solution {
    // Variable para rastrear el máximo global
    private int maxGlobal;

    public int maxPathSum(TreeNode root) {
        maxGlobal = Integer.MIN_VALUE;
        dfs(root);
        return maxGlobal;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 1. Recursión: obtener el máximo de los hijos. 
        // Si el valor es negativo, usamos 0 (ignoramos esa rama).
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // 2. Calcular el valor de la ruta si este nodo fuera el "pico" (arco)
        int currentPathSum = node.val + leftMax + rightMax;

        // 3. Actualizar el máximo global si el camino actual es mayor
        maxGlobal = Math.max(maxGlobal, currentPathSum);

        // 4. Retornar la contribución máxima a la llamada del padre
        // (Solo podemos elegir un camino: izquierda o derecha + el valor del nodo)
        return node.val + Math.max(leftMax, rightMax);
    }
}
