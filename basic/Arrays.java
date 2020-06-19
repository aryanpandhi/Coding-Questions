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
        /* replaceSpaces Tests */
        assert replaceSpaces("ok hi hello").equals("ok%20hi%20hello");
        assert replaceSpaces("").equals("");
        assert replaceSpaces("apple").equals("apple");
        /* isPermutationOfPalindrome Tests */
        assert !isPermutationOfPalindrome("hello world");
        assert isPermutationOfPalindrome("Tact Coa");
        assert isPermutationOfPalindrome("");
        /* oneEditAway Tests */
        assert oneEditAway("coke", "come");
        assert !oneEditAway("b", "bee");
        assert oneEditAway("", "");
        assert oneEditAway("to","toe");
        assert oneEditAway("bee", "be");
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

    static String replaceSpaces(String str){
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

    static boolean isPermutationOfPalindrome(String str){
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

    static boolean oneEditAway(String s, String t){
        if (java.lang.Math.abs(s.length()-t.length())>1) return false;

        String s1 = s.length() < t.length() ? s : t;
        String s2 = s.length() < t.length() ? t : s;
        boolean diffChar = false;
        int index1 = 0;
        int index2 = 0;

        while(index1 < s1.length()){
            if (s1.charAt(index1) != s2.charAt(index2)){

                if (diffChar) return false;
                diffChar = true;

                if (s1.length() == s2.length()) index1++;

            } else {
                index1++;
            }
            index2++;
        }

        return true;
    }

}