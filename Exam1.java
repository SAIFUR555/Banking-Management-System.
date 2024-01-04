public class Exam1 {
    public static void main(String[] args) {
        char[] input = {'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        int n = input.length; // Corrected the length retrieval
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[(j + i) % n]); // Corrected System.out.print
                if (j % 2 == 0) {
                    j++;
                }
            }
            System.out.println();
        }
    }
}
 
 
 
 
 
 