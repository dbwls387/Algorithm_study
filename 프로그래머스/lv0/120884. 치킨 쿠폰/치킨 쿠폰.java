class Solution {
    public int solution(int chicken) {
        int answer = 0;
//         int remain = 0;
        
//         while(true) {
//             if(chicken < 10)
//                 break;
            
//             chicken /= 10;
//             answer += chicken;
//             remain += chicken % 10;
//         }
        
//         while(true) {
//             if(remain < 10)
//                 break;
            
//             answer += remain / 10;
//             remain %= 10;           
//         }
        
        if(chicken > 10) {   
            answer = (chicken - 10);
            int a = answer / 9;
            int b = answer % 9;
                
            answer = a+1;
        }
            
        return answer;
    }
}