import java.util.Arrays;

class Jan1 {
    public static int findContentChildren(int[] g, int[] s) {
        // Sort the greed factor and cookie size arrays
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int greedIndex = 0;
        int cookieIndex = 0;

        // Iterate through the arrays and assign cookies to children
        while (greedIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[greedIndex]) {
                // If the cookie is large enough, assign it to the child
                contentChildren++;
                greedIndex++;
            }
            cookieIndex++;
        }

        return contentChildren;
    }

    public static void main(String[] args){
        int[] a = {1,2};
        int[] b = {1,2,3};
        int value = findContentChildren(a,b);
        System.out.println(value);
    }
}