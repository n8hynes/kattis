/** Solution for kattis problem
 * @author: echoenzo
 */
import java.io.*;
import java.util.*;

public class WhatDoesTheFoxSay {

    Kattio io;
    Kattio debug;
    int i = 0, j = 0;

    void solve() {
        /**************START**************/

        int T = io.getInt();
        String s;
        ArrayList<String> sounds;
        String animal;
        String sound;
        String in;
        for (i = 0; i < T; i++) {
            s = io.nextLine();
            debug.println(s);
            sounds = new ArrayList<String>(Arrays.asList(s.split(" ")));
            animal = io.nextToken();
            while (!animal.equals("what")) {
                in = io.nextToken();
                sound = io.nextToken();
                while (sounds.contains(sound)) { sounds.remove(sound); }
                animal = io.nextToken();
            }
            String res = "";
            for (String str : sounds) {
            res += str + " ";
            }
            res = res.substring(0, res.length()-1);
            io.println(res);
        }

        /***************END***************/
    }

    public static void main(String[] args) {
        new WhatDoesTheFoxSay().runIO();
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
