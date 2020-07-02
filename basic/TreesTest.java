public class TreesTest {
    
    public static void main(String[] Args){
        int[] arr = new int[]{0,1,2,3,4,5,6};
        Trees p = Trees.createMinimalBST(arr, 0, arr.length-1);
        System.out.println(Trees.createLevelLinkedList(p));
        assert Trees.isBalanced(p);
    }

}