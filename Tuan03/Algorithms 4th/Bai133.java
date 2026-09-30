//Tư duy: mượn ý tưởng từ hàng đợi ưu tiên để giải thích hiện tượng chọn cho bài này
//Cụ thể:
// + Về cơ bản khi đẩy chuỗi 0 -> 9 vào stack. Thì khi pop ra kết quả là chiều giảm xuống từ 9 -> 0
// + Nhưng giả sử trong, 10 lần đẩy vào stack. Có n lần ta tự dưng muốn pop trước:
//    ví dụ dễ hiểu: coi stack ban đầu là hàng xử lí, nào đẩy hết vào ta sẽ xử lí từ 9 -> 0 lần lượt.
//    tuy nhiên có n số là ưu tiên (tức được ưu tiên xử lí in màn hình trước - vì ta thích thế)
//    lúc này n số này sẽ được in ra trước
//    Tuy nhiên, do chính việc push của stack là từ 0 -> 9. Chịu sự ảnh hưởng tăng dần đó, bắt buộc chiều của dãy
//    ưu tiên này phải có chiều tăng
//    Lúc này khi chạm số 9, ta sẽ pop lần lượt ra, và chiều in ra lúc này sẽ là chiều giảm theo tính chất của stack
//    Vậy dãy hợp lệ phải có dạng tăng -> giảm
//
// + Tuy nhiên, đấy mới chỉ đang nói tới việc pop ở các vị trí sao cho chúng không thành 1 list pop liên tục
// + Nếu pop liên tục được thực hiện thì:
// -> Các đầu của mỗi dãy giảm dần của O phải tăng dần: ví dụ: 4 3 1 7 6 5 2 0. Ở đây có 2 dãy giảm là 4 3 1 và 7 6 5 2 0
// đầu mỗi dãy là 4<7 thỏa mãn:
// -> Nhưng nếu 4 3 1 2 0 thì 4 < 2: ta không thể tìm tổ hợp nào thỏa mãn
// -> đáp án: b f g là chuỗi không thể xảy ra
// Để kiểm tra tôi xin trình bày một đoạn code thuật toán class tên ValidStack để kiểm tra đáp án


import Bai2.Solution;
import java.util.Arrays;
import java.util.Stack;

/**
 * Giải quyết bài toán bằng cách sử dụng stack
 * Một stack sẽ để lưu kết quả
 *
 */
class ValidStack{
    private int parseInt(char c){
        return Integer.parseInt(String.valueOf(c));
    }

    public boolean solve(String s){
        Stack<Integer> store = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int p = 0;
        int i = 0;
        while(i <= 9){
            store.push(i);
//                System.out.println("store:" + store.toString());
//
//                System.out.println("char s:" + s.charAt(p));
//                System.out.println("i: " + i)

            ;
            if(parseInt(s.charAt(p)) == store.peek()){
                temp.push(store.pop());
//                    System.out.println("temp 1: " + temp.toString());
//                    System.out.println("store 1:" + store.toString());

                while(p <= 8 && parseInt(s.charAt(p + 1)) < parseInt(s.charAt(p))){
                    if(parseInt(s.charAt(p + 1)) == store.peek()){
                        temp.push(store.pop());
                        p++;

//                            System.out.println("temp 2: " + temp.toString());
//                            System.out.println("store 2:" + store.toString());
                    }else {
                        break;
                    }
                }
                p++;


            }

            i++;
        }
        return store.isEmpty();
    }

}
public class Bai133{
    void main(){
        ValidStack solution = new ValidStack();

        // --- CÁC CÂU TRONG ĐỀ BÀI GỐC ---
        System.out.println("4321098765 -> " + solution.solve("4321098765") + " (Kỳ vọng: true  - Đề câu a)");

        System.out.println("4687532901 -> " + solution.solve("4687532901") + " (Kỳ vọng: false - Đề câu b, sai đoạn cuối 9 0 1)");

        System.out.println("2567489310 -> " + solution.solve("2567489310") + " (Kỳ vọng: true  - Đề câu c, đan xen sâu)");

        System.out.println("4321056789 -> " + solution.solve("4321056789") + " (Kỳ vọng: true  - Đề câu d)");

        System.out.println("1234569870 -> " + solution.solve("1234569870") + " (Kỳ vọng: true  - Đề câu e)");

        System.out.println("0465381729 -> " + solution.solve("0465381729") + " (Kỳ vọng: false - Đề câu f, lỗi cụm 1 7 2)");

        System.out.println("1479865302 -> " + solution.solve("1479865302") + " (Kỳ vọng: false - Đề câu g, sai đuôi 3 0 2)");

        System.out.println("2143658790 -> " + solution.solve("2143658790") + " (Kỳ vọng: true  - Đề câu h)");


    }

}

