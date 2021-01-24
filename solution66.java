public class solution66 {
    public int[] plusOne(int[] digits) {
        return recursive(digits, digits.length - 1);
    }

    public int[] recursive(int[] digits, int index) {
        if (digits[index] == 9) {
            if (index == 0) {
                digits[index] = 0;
                int[] newRes = new int[digits.length + 1];
                newRes[0] = 1;
                for (int i = digits.length - 1; i >= 0; i--) {
                    newRes[i + 1] = digits[i];
                }
                return newRes;
            } else {
                digits[index] = 0;
                return recursive(digits, index - 1);
            }
        } else {
            digits[index]++;
            return digits;
        }
    }

    public static void main(String[] args) {
        
    }
}
