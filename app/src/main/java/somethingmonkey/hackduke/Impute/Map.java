package somethingmonkey.hackduke.Impute;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Map {
    private double[][] codebook;
    private double[] mask;
    public Map(String cb, String m){
        codebook = readCB(cb);
        mask = readMask(m);
    }

    private double[][] readCB(String path){
        File file = new File(path);
        ArrayList<double[]> result = new ArrayList<>();
        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                String[] line = s.nextLine().split(",");
                double[] dline = new double[line.length];
                for(int i=0;i<line.length;i++){
                    dline[i] = Double.parseDouble(line[i]);
                }
                result.add(dline);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double[][] realresult = new double[result.size()][result.get(0).length];
        for(int i=0;i<result.size();i++){
            realresult[i]=result.get(i);
        }
        return realresult;
    }

    private double[] readMask(String path){
        File file = new File(path);
        ArrayList<double[]> result = new ArrayList<>();
        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                String[] line = s.nextLine().split(",");
                double[] dline = new double[line.length];
                for(int i=0;i<line.length;i++){
                    dline[i] = Double.parseDouble(line[i]);
                }
                result.add(dline);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
