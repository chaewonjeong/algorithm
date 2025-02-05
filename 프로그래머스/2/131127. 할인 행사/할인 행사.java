import java.util.HashMap;

class Solution {
    
    boolean checkItem(HashMap<String, Integer> box, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            String name = want[i];
            int num = number[i];

            // NullPointerException 방지
            if (box.getOrDefault(name, 0) < num) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> box = new HashMap<>();
        
        int count = 0;
        int frontIdx = 0;
        int rearIdx = 9;

        // 초기 10개 아이템 등록
        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            box.put(item, box.getOrDefault(item, 0) + 1);
        }
        
        while (true) {
            if (checkItem(box, want, number)) {
                count++;
            }

            // 배열 범위 초과 체크 (인덱스 초과 방지)
            if (rearIdx + 1 >= discount.length) {
                break;
            }

            String deleteItem = discount[frontIdx];
            String addItem = discount[rearIdx + 1];

            // NullPointerException 방지
            if (box.getOrDefault(deleteItem, 0) <= 1) {
                box.remove(deleteItem);
            } else {
                box.put(deleteItem, box.get(deleteItem) - 1);
            }

            box.put(addItem, box.getOrDefault(addItem, 0) + 1);
            frontIdx++;
            rearIdx++;
        }
        
        return count;
    }
}
