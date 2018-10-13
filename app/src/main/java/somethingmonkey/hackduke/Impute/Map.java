package somethingmonkey.hackduke.Impute;

public class Map {
    private double[][] codebook;
    private double[] mask;
    public Map(double[][] cb, double[] m){
        codebook = cb;
        mask = m;
    }

    public double[][] getCodebook() {
        return codebook;
    }

    public double[] getMask() {
        return mask;
    }
}
