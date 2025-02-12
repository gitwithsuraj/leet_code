public class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: If either number is zero, return "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // To store the product

        // Multiply each digit of num1 and num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add to existing value
                
                result[i + j + 1] = sum % 10;      // Place the unit digit
                result[i + j] += sum / 10;         // Carry to the next position
            }
        }

        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (sb.length() == 0 && num == 0) continue;
            sb.append(num);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String num1 = "2", num2 = "3";
        System.out.println(solution.multiply(num1, num2)); // Output: "6"
        
        num1 = "123";
        num2 = "456";
        System.out.println(solution.multiply(num1, num2)); // Output: "56088"
    }
}
