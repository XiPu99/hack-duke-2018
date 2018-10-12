package somethingmonkey.hackduke.Impute;

public class TrainHist {
    private String algorithm;
    private String data_name;
    private String neigh;
    private double[] mask;
    private int radius_ini;
    private int radius_fin;
    private int alpha_ini;
    private String alpha_type;
    private int trainlen;
    private String time;
    TrainHist(String alg, String name, String n, double[] m, int ri, int rf,
              int ai, String at, int tl, String ti){
        algorithm = alg;
        data_name = name;
        neigh = n;
        mask = m;
        radius_ini = ri;
        radius_fin = rf;
        alpha_ini = ai;
        alpha_type = at;
        trainlen = tl;
        time = ti;
    }
}
