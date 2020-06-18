class Arrays{

    public static void main(String[] Args){
        /* allUnique Tests */
        assert !allUnique("apple");
        assert allUnique("aple");
        assert allUnique("");
        assert !allUnique("wejfbejbf");
        /* isPermutation Tests */
        assert isPermutation("label","eball");
        assert isPermutation("happy", "happo");
        assert isPermutation("", "");
        assert isPermutation("lol", "lol");
        /* urlify Tests */
        assert urlify("ok hi hello").equals("ok%20hi%20hello");
        assert urlify("").equals("");
        assert urlify("apple").equals("apple");
        /* isPalPer Tests */
        assert !isPalPer("hello world");
        assert isPalPer("Tact Coa");
        assert isPalPer("");

        System.out.println("All Tests Passed!");
    }

    static boolean allUnique(String str){
        if (str.length() > 128) return false;

        boolean check[] = new boolean[128];
        char[] str_arr = str.toCharArray();
        for (char c : str_arr){
            if (check[c]){
                return false;
            }
            check[c] = true;
        }

        return true;
    }

    static boolean isPermutation(String s, String t){
        if (s.length() != t.length()) return false;

        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++){
            int ind = t.charAt(i);
            count[ind]--;
            if (count[ind]<0) return false;
        }
        return true;
    }

    static String urlify(String str){
        StringBuilder output = new StringBuilder();

        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            if (c ==' '){
                output.append("%20");
            } else {
                output.append(c);
            }
        }

        return output.toString();

    }

    static boolean isPalPer(String str){
        str.toLowerCase();

        int[] count = new int[128];
        for(int i = 0; i< str.length(); i++){
            if (str.charAt(i)!=' ')
            count[str.charAt(i)]++;
        }

        int numOfOdd = 0;
        for (int i = 0; i < 128; i++){
            if (count[i]%2 == 1) {
                numOfOdd++;
                if (numOfOdd>1) return false;
            }
        }

        return true;

    }

}