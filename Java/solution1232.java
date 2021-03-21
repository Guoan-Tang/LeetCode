public class solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return true;
        }
        int x = coordinates[0][0], y = coordinates[0][1], dx = coordinates[1][0] - x, dy = coordinates[1][1] - y;
        for (int i = 2; i < coordinates.length; i++) {
            if (((coordinates[i][0] - x) * dy) != ((coordinates[i][1] - y) * dx)) {
                return false;
            }
        }
        return true;
    }
}