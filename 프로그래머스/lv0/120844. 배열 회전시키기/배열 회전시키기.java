class Solution {
    public int[] solution(int[] numbers, String direction) {
        int size = numbers.length;
        if(direction.equals("left")) {
            int tmp = numbers[0];
            for(int i = 0; i < size-1; i++) {
                numbers[i] = numbers[i+1];
            }
            numbers[size - 1] = tmp;
        } else {
            int tmp = numbers[size-1];
            for(int i = size-2; i >= 0; i--) {
                numbers[i+1] = numbers[i];
            }
            numbers[0] = tmp;
        }
        
        return numbers;
    }
}