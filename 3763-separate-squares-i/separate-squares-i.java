class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0.0;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
            totalArea += (double) s[2] * s[2];
        }

        for (int iter = 0; iter < 80; iter++) { // sufficient precision
            double mid = (low + high) / 2.0;
            double below = areaBelow(squares, mid);

            if (below * 2.0 >= totalArea) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    private double areaBelow(int[][] squares, double y) {
        double area = 0.0;

        for (int[] s : squares) {
            double bottom = s[1];
            double top = s[1] + s[2];
            double side = s[2];

            if (y <= bottom) {
                continue;
            } else if (y >= top) {
                area += side * side;
            } else {
                area += side * (y - bottom);
            }
        }

        return area;
    }
}
