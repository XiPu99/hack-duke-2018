package somethingmonkey.hackduke.Impute;

import static somethingmonkey.hackduke.ImputeUtils.ImputeUtil.*;
/*
* Imputer to find the best-matching units (BMU) from the map for the given vector
 */

public class Imputer {
    private Map myMap;

    /*
    * @param map: the vectors from among which the BMUs are searched for.
    * These must not have any unknown components.
    * @param data: THe data vector for which the BMUs are searched.
    * */
    public Imputer(Map map){
        myMap = map;
    }

    public double[] impute(String[][] data){
        //Map setup
        double[][] M = myMap.getCodebook();
        int[] mdim = dim(M);
        System.out.println(mdim[0]+" "+mdim[1]);
        //Data setup
        String[][] D = data;
        int[] ddim = dim(D);
        System.out.println(ddim[0]+" "+ddim[1]);
        if(mdim[1]!=ddim[1]){
            System.out.println("Map and Data dimension mismatch!");
            return new double[]{};
        }
        //Mask import
        double[] mask = myMap.getMask();
        //Imputation setup
        double[] bmu = new double[M[0].length];
        double[] qerrors = bmu;
        //Block size
        int blen = Math.min(mdim[0],ddim[0]);
        //handle unknown components
        boolean[][] Known = known(D);
        double[][] W1 = multMatrix(mult(ctranspose(new double[][]{mask}),ones(1,ddim[0])),parseBoolMatrix(ctranspose(Known)));

        D = zeroNA(D);
        //constant matrices
        double[][] WD = scalar(2,mult(diag(mask),parseStringMatrix(ctranspose(D))));
        double[][] dconst = mult(expMatrix(2,parseStringMatrix(D)),ctranspose(new double[][]{mask}));

        int i=0;
        while(i+1<=ddim[0]){
            //calculate distance
            int[] inds = range(i+1,Math.min(ddim[0],i+blen));
            i+=blen;
            double[][] Dist = subtractMatrix(mult(expMatrix(2,M),colSelect(inds,W1)),mult(M,colSelect(inds,WD)));

            //find the bmus and the corresponding quantization errors
            double[][] qb = min(Dist);
            bmu = qb[1];
            qerrors = subtractMatrix(new double[][]{qb[0]}, scalar(-1,dconst))[0];
        }
        return new double[]{bmu[0],qerrors[0]};
    }


}
