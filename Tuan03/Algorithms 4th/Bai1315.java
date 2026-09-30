import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Bai1315 {

    /**
     * Trả về chuỗi thứ k tính ngược từ chuỗi cuối cùng được đọc
     * @param k vị trí tính ngược (1 <= k <= số lượng chuỗi)
     * @param scanner nguồn đọc input chuẩn
     */
    public String findKthFromLast(int k, Scanner scanner) {
        Queue<String> queue = new ArrayDeque<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            queue.offer(word);

            // Giữ kích thước Queue tối đa là k
            if (queue.size() > k) {
                queue.poll();
            }
        }

        // Phần tử đầu hàng đợi lúc này chính là phần tử thứ k tính từ cuối
        return queue.peek();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Vui lòng truyền tham số dòng lệnh k!");
            return;
        }

        int k = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);

        Bai1315 solver = new Bai1315();
        String result = solver.findKthFromLast(k, scanner);

        System.out.println(result);
    }
}