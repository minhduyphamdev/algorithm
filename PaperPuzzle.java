import java.util.Arrays;

public class PaperPuzzle {
    public static void main(String[] args) {
        int[] piece1 = {1, 4, 3, 2};
        int[] piece2 = {1, 2, 4, 3};

        int minPieces = findMinPieces(piece1, piece2);

        System.out.println("Số lượng mảnh giấy ít nhất cần để ghép lại là: " + minPieces);
    }

    // Hàm tìm số lượng mảnh giấy ít nhất cần để ghép lại
    public static int findMinPieces(int[] piece1, int[] piece2) {
        int n = piece1.length;

        int[] positions = new int[n + 1];
        for (int i = 0; i < n; i++) {
            positions[piece2[i]] = i;
        }

        boolean[] visited = new boolean[n];
        int minPieces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int j = i;
                int cycleSize = 0;

                do {
                    j = positions[piece1[j]];
                    visited[j] = true;
                    cycleSize++;
                } while (j != i);

                // Số lượng mảnh giấy cần để tạo ra chu kỳ là cycleSize
                minPieces += cycleSize - 1;
            }
        }

        return minPieces;
    }
}
