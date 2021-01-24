public class solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0, length = gas.length, totalGas, totalCost, moveCount, curIndex;
        while (startIndex < length) {
            moveCount = 0;
            totalCost = 0;
            totalGas = 0;
            while (moveCount < length) {
                curIndex = (startIndex + moveCount) % length;
                totalCost += cost[curIndex];
                totalGas += gas[curIndex];
                if (totalCost > totalGas) {
                    break;
                }
                moveCount++;
            }
            if (moveCount == length) {
                return startIndex;
            }
            startIndex += moveCount + 1;
        }
        return -1;
    }
}