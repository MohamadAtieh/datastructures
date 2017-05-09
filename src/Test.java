import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by matie on 2017-04-17.
 */
public class Test {
    public static void main(String[] arg){
        System.out.println(sum(2, 3));
    }

    private static int sum(int a, int b){
        int c = a ^ b;
        int d = (a & b) << 1;
        return (b == 0) ? a : sum(c, d);
    }

}
