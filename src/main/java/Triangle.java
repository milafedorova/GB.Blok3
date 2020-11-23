public class Triangle {

    public static double areaTriangle(int a, int b, int c){
        double aa = a;
        double bb =b;
        double cc = c;

        double p = (aa+bb+cc)/2;
        double s = Math.sqrt(p*(p-aa)*(p-bb)*(p-cc));

        return s;
    }

    public static void main(String[] args) {
        System.out.println(areaTriangle(3,4,5));
    }
}
