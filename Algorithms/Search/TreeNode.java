
public class TreeNode {
    
    static class Node{
        int key;
        Node leftChild, rightChild;

        public Node(int key){
            this.key = key;
            leftChild = rightChild = null;
        }
    }

    Node root;
    public TreeNode(){
        root = null;
    }

    public void postOrder(Node tree){
        if(tree == null)
            return;
        postOrder(tree.leftChild);
        postOrder(tree.rightChild);
        System.out.print(tree.key + ", ");
    }

    public void inOrder(Node tree){
        if(tree == null)
            return;
        inOrder(tree.leftChild);
        System.out.print(tree.key + ", ");
        inOrder(tree.rightChild);    
    }

    public void preOrder(Node tree){
        if(tree == null)
            return;
        System.out.print(tree.key + ", ");
        preOrder(tree.leftChild);
        preOrder(tree.rightChild);
    }

    public void levelOrder(Node tree){
        int h = height(tree);
        for(int i = 0; i<=h; ++i)
            lOrder(tree, i);
    }

    public int height(Node tree){
        if(tree == null)
            return 0;
        else{
            int lheight = height(tree.leftChild);
            int rheight = height(tree.rightChild);

            return Math.max(lheight, rheight) + 1 ;
        }
    }

    public void lOrder(Node tree, int level){
        if(tree == null)
            return;
        if(level == 1)
            System.out.print(tree.key + ", ");
        else if (level > 1){
            lOrder(tree.leftChild, level-1);
            lOrder(tree.rightChild, level-1);
        }
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode();
        tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        System.out.println("Post-order: ");
        tree.postOrder(tree.root);
        System.out.println("\nIn-Order: ");
        tree.inOrder(tree.root);
        System.out.println("\nPre-order: ");
        tree.preOrder(tree.root);
        System.out.println("\nLevel-order: ");
        tree.levelOrder(tree.root);
    }
}
