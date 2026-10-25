class Solution {
    public int solution(int[] common) {
        int len = common.length;

        // 등차수열
        if (common[1] - common[0] ==
            common[2] - common[1]) {

            int d = common[1] - common[0];
            return common[len - 1] + d;
        }

        // 등비수열
        int r = common[1] / common[0];
        return common[len - 1] * r;
    }
}