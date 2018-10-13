package somethingmonkey.hackduke.Impute;

import android.content.Context;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import somethingmonkey.hackduke.MainActivity;
import somethingmonkey.hackduke.R;

public class Map {
    private double[][] codebook;
    private double[] mask;
    private Context context;
    public Map(){
        context = MainActivity.getAppContext();
        codebook = readCB();
        mask = readMask();
    }

    private double[][] readCB(){
        InputStream raw = context.getResources().openRawResource(R.raw.codebook);
        ArrayList<double[]> result = new ArrayList<>();
        Scanner s = new Scanner(raw);
        while(s.hasNextLine()){
            String[] line = s.nextLine().split(",");
            double[] dline = new double[line.length];
            for(int i=0;i<line.length;i++){
                dline[i] = Double.parseDouble(line[i]);
            }
            result.add(dline);
        }
        double[][] realresult = new double[result.size()][result.get(0).length];
        for(int i=0;i<result.size();i++){
            realresult[i]=result.get(i);
        }
        return realresult;
    }

    private double[] readMask(){
        InputStream raw = context.getResources().openRawResource(R.raw.mask);
        ArrayList<double[]> result = new ArrayList<>();
        Scanner s = new Scanner(raw);
        while(s.hasNextLine()){
            String[] line = s.nextLine().split(",");
            double[] dline = new double[line.length];
            for(int i=0;i<line.length;i++){
                dline[i] = Double.parseDouble(line[i]);
            }
            result.add(dline);
        }
        double[] realresult = new double[result.size()];
        for(int i=0;i<result.size();i++){
            realresult[i] = result.get(i)[0];
        }
        return realresult;
    }

    public double[][] getCodebook() {
        return codebook;
    }

    public double[] getMask() {
        return mask;
    }
}
