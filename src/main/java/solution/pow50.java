package main.java.solution;

/**
 * Created by dujinyuan on 17/3/26.
 */

/**
 * leetcode num 50
 * 题目
 * 求解x的n次幂
 * 实现浮点类型的幂运算
 */
public class pow50 {

    /**第一种解题思路
     * @param x 浮点数
     * @param n n次幂
     * @return
     */
    public static double myPow(double x, int n) {
        //正整数的0次方是1 ,0的0次方没意义, 负整数的0次方也是1.
        if(n==0)
            return 1.0;
        //2的负3次方,就是2的三次方分之1.就是八分之一  比如说4的-2次方,就是4的2次方的倒数,既16的倒数1/16
        if(n<0)
            return 1/myPow(x, -n);
        return x*myPow(x,n-1);
        //return x*myPow(x, n - 1);
    }



    /**
     * 第二种解题思路
     * 通过一点点数学推导我们可以知道，
     * 如果n是偶数 $$ x^nx^n = x^{2n}$$
     * 如果n是奇数 $$ x^nx^nx = x^{2n+1}$$ 根据这几条原则递归，我们就不用将x相乘n次，而只要logN次就行了
     * @param x
     * @param n
     * @return
     */
    public static double myProPow(double x, int n) {
        if(n < 0){
            // n为负返回倒数
            return 1/pow(x, -n);
        } else {
            // n为正直接返回结果
            return pow(x, n);
        }
    }

    private static double pow(double x, int n){
        // 递归终止条件
        if(n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }
        double val = pow(x, n / 2);
        // 根据奇数还是偶数返回不同的值
        if(n % 2 == 0){
            return val * val;
        } else {
            return val * val * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myProPow(1.09, 0));
        System.out.println(myProPow(1.09, -3));
        System.out.println(myProPow(1.09,3));
    }

}
