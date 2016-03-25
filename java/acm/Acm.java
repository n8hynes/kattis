/** Solution for kattis problem
 * @author: echoenzo
 */
import java.io.*;
import java.util.*;

public class Acm {

    Kattio io;
    Kattio debug;
    int i = 0, j = 0;

    void solve() {
        /**************START**************/

        HashMap<String, Integer> times = new HashMap<String, Integer>();
        ArrayList<String> solved = new ArrayList<String>();
        int time = io.getInt();
        while (time != -1) {
            String problem = io.nextToken();
            String rw = io.nextToken();
            if (!solved.contains(problem)) {
                switch (rw) {
                    case "wrong":
                        if (times.containsKey(problem)) {
                            times.put(problem, times.get(problem)+20);
                        }
                        else times.put(problem, 20);
                        break;
                    case "right":
                        solved.add(problem);
                        if (times.containsKey(problem)) {
                            times.put(problem, times.get(problem)+time);
                        }
                        else times.put(problem, time);
                }
            }
            time = io.getInt();
        }
        int score = 0;
        for (String s : solved) {
            debug.println(s);
            score += times.get(s);
        }
        io.println(solved.size() + " " + score);

        /***************END***************/
    }

    public static void main(String[] args) {
        new Acm().runIO();
    }

    void runIO() {
        io = new Kattio(System.in, System.out);
        debug = new Kattio(System.in, System.err);
        solve();
        io.close();
        debug.close();
    }

    /** Simple yet moderately fast I/O routines.
     * @author: Kattis
     */
    class Kattio extends PrintWriter {

        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        // returns a character grid of the next lines of input, until EOF or empty line.
        public char[][] getCharGrid() {
            ArrayList<char[]> lines = new ArrayList<char[]>();
            String ans = nextLine();
            if (ans == null) return null;
            while (ans != null && ans.length() > 0) {
                lines.add(ans.toCharArray());
                ans = nextLine();
            }
            char[][] grid = new char[lines.size()][];
            for (int row = 0; row < grid.length; row++) {
                grid[row] = lines.get(row);
            }
            return grid;
        }

        public void printGrid(char[][] g) {
            for (int a = 0; a < g.length; a++) {
                println(new String(g[a]));
            }
        }

        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null) try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { e.printStackTrace(); }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }

        public String nextLine() {
            st = null;
            String s = null;
            try {
                s = r.readLine();
            } catch (IOException e) { e.printStackTrace(); }
            return s;
        }

    }

}
