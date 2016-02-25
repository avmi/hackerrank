public class ffx {
    static int f(int x) {
        return (x == 0) ? x : (x > 0) ? ((x % 2 == 0) ? x - 1 : -(++x)) : (((-x) % 2 != 0) ? 1 - x : 1 + x);
    }

    public static void main(String[] args) {
        int x = f(f(-2));
        System.out.println(x);
    }
}