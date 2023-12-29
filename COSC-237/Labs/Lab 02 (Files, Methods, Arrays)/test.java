public class test {
    public static void main (String[] args){
        int[] list = {34, 55, 18, 47, 89, 45, 67, 59, 88, 37, 20, 27, 10, 78, 39, 21,};

        System.out.println(getMean(list, list.length));
        System.out.println(getVariance(list, list.length));

    }

 
    public static double getVariance(int[] list, int size) {
        double mean = getMean(list, size);
        double variance = 0;

        for (int i = 0; i < size; i++)
            variance += Math.pow((list[i] - mean),2);
            
        return variance / size;
    }

    public static double getMean(int[] list, int size) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list[i];
        }
        return sum / size;
    }

}
