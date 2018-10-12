package somethingmonkey.hackduke.Impute;

public class Map {
    private double[][] codebook;
    private Topol topol;
    private String[] labels;
    private String neigh;
    private double[] mask;
    private TrainHist[] trainhist;
    private String name;
    private String[] comp_names;
    private Norm[] comp_norm;
    public Map(double[][] cb, Topol top, String[] lb, String neighbor, double[] m,
               TrainHist[] th, String n, String[] cname, Norm[] cnorm){
        codebook = cb;
        topol = top;
        labels = lb;
        neigh = neighbor;
        mask = m;
        trainhist = th;
        name = n;
        comp_names = cname;
        comp_norm = cnorm;
    }

    public double[][] getCodebook() {
        return codebook;
    }

    public double[] getMask() {
        return mask;
    }
}
