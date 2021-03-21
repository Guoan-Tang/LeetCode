

public class solution154 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int left = 0, right = numbers.length - 1, res = 0, mid;
        while (numbers[left] >= numbers[right]) {
            mid = (left + right) / 2;
            if (numbers[0] <= numbers[mid]) {
                if (numbers[0] == numbers[mid] && numbers[mid] == numbers[numbers.length - 1]) {
                    return findMin(numbers, left, right);
                }
                left = mid;
            } else {
                right = mid;
            }
            if (left + 1 == right) {
                res = right;
                break;
            }
        }
        return numbers[res];
    }

    public int findMin(int[] numbers, int left, int right) {
        int res = numbers[left];
        for (int i : numbers) {
            if (res > i) {
                res = i;
            }
        }
        return res;
    }
}
