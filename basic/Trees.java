import java.util.*;

class Trees{

    int Value;
    Trees Left;
    Trees Right;

    Trees(int Value){
        this.Value = Value;
        Left = null;
        Right = null;
    }

    Trees(int Value, Trees Left, Trees Right){
        this.Value = Value;
        this.Left = Left;
        this.Right = Right;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Integer.toString(Value);
    }

    static Trees createMinimalBST(int[] arr, int start, int end){
        if (start > end) return null;

        int mid = (end+start)/2;
        int root = arr[mid];

        Trees t = new Trees(root);
        Trees left = createMinimalBST(arr, start, mid-1);
        t.Left = left;
        Trees right = createMinimalBST(arr, mid+1, end);
        t.Right = right;

        return t;
    }

    static ArrayList<LinkedList<Trees>> createLevelLinkedList(Trees t){
        ArrayList<LinkedList<Trees>> levels = new ArrayList<>();
        LinkedList<Trees> children = new LinkedList<>();
        children.add(t);

        while(!children.isEmpty()){
            levels.add(children);
            LinkedList<Trees> parents = children;
            children = new LinkedList<>();
            for (Trees parent: parents){
                if (parent.Left != null) children.add(parent.Left);
                if (parent.Right != null) children.add(parent.Right);
            }
        }

        return levels;
    }

    static int checkHeight(Trees t){
        if (t == null) return -1;

        int leftHeight = checkHeight(t.Left);
        if (leftHeight == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        int rightHeight = checkHeight(t.Right);
        if (rightHeight == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff <= 1) {
            return Math.max(leftHeight, rightHeight)+1;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    static boolean isBalanced(Trees t){
        int height = checkHeight(t);
        if (height != Integer.MAX_VALUE) return true;
        return false;
    }

}