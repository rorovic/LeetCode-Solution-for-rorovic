package main.java.solution;

/**
 * Created by dujinyuan on 17/7/10.
 */

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 Credits:
 Special thanks to @fujiaozhu for adding this problem and creating all test cases.

 point: 二进制,异或运算,与运算
 11 => 用11除以2，11/2，商5余1，在用商的5/2，商2余1，再用商的2除以2，商1余0，再用商的1除以2，商0余1，最后取余数：1，1，0，1.从下到上读取数据，则结果为：1011.
 5 => 5除2,5/2,商2余1 2除2,商1余0 1/2 商0余1  0101
 异或:如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。

 思路: 这里用到了一个半加法的思想, 即两位单独的位相加其结果可以用异或得到, 进位可以用与得到. 然后对于两个数字来说同样可以延伸这个思想.
 举个例子: 11+5, 其二进制形式为11: 1011, 5: 0101

 1. 那么两个位置都为1的地方就需要进位, 所以进位值就为0001. 原位置两个数相加的结果为那个位置值的异或即1110, 即两个位置值如果不一样就为1, 一样的话要么两个位置原来值都为0结果也为0, 要么进位, 那么结果依然是0.
 2. 接下来就要把进位位和下一位相加, 所以进位值左移一位,即0001变为0010, 重复上面操作可得新的进位值为0010, 原位置异或(即相加)结果为1100.
 3. 继续重复上面操作直到进位为0, 可得到最终结果10000, 即16
 位运算
 http://zhedahht.blog.163.com/blog/static/254111742011125100605/
 */
public class SumTwoIntegers371 {

    /**
     * 递归
     * @param a
     * @param b
     * @return
     */
    public static Integer SumTwoIntegers(int a,int b) {
        int result = a^b; //按位运算符 异或
        int carry = (a&b) <<1; //按位与运算  运算规则：0&0=0; 0&1=0;  1&0=0;  1&1=1; 即：两位同时为“1”，结果才为“1”，否则为0
        //carry在不为0之前,都会一直递归执行,直到carry为0,才会返回结果
        if(carry!=0)
            return SumTwoIntegers(result,carry);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        SumTwoIntegers(11,5);
        System.out.println(1^11);
    }

}
