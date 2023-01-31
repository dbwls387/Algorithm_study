class Solution {
    
    static int[][] arr;
    static int[] answer;
    
    public int[] solution(int[][] arr) {
        this.answer = new int[2];
        this.arr = arr;
                
        dc(0, 0, arr.length);
        
        return answer;
    }
    
    private static void dc(int sx, int sy, int size) {
        if (isQuad(sx, sy, size)) {
            answer[arr[sx][sy]]++;
            return;
        }
        
        dc(sx, sy, size / 2);
        dc(sx + (size / 2), sy + (size / 2), size / 2);
        dc(sx + (size / 2), sy, size / 2);
        dc(sx, sy + (size / 2), size / 2);
    }
    
    private static boolean isQuad(int startX, int startY, int size) {           
        int target = arr[startX][startY];
        
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (target != arr[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}