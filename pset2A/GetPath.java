package pset2A;


import java.util.ArrayList;

public class GetPath {

    //Fill in your answer for this method
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        if (c < 0 || r < 0 || grid[r][c] == 1) return false;
        // first condition is when destination is reached
        if ((r == 0 && c == 0) || getPath(r-1, c, path, grid) || getPath(r, c-1, path, grid)) {
            Point way = new Point(r,c);
            path.add(way);
            return true;
        }
        return false;
    }
}

//You do not need to change any code below ---------
class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}