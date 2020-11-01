package pset2A;

import java.util.ArrayList;

public class Permutation {
    private String in;
    private ArrayList<String> a = new ArrayList<String>();
    private int pos;
    private int last;

    Permutation(String str){
        in = str;
        pos = 0;
        last = str.length() -1;
    }

    public String swap(String in, int pos, int ii) {
        char[] S = in.toCharArray();
        char x = S[pos];
        S[pos] = S[ii]; //swap
        S[ii] = x;
        return String.valueOf(S);
    }

    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        if (pos == last) a.add(in);
        else {
            for (int ii = pos; ii <= last; ii++) {
                in = swap(in, pos, ii);
                pos += 1;
                permute();
                pos -= 1;
                in = swap(in, pos, ii);
                if (a.contains(in)) continue;
                else a.add(in);
            }
        }
    }
    public ArrayList<String> getA(){
        return a;
    }
}


