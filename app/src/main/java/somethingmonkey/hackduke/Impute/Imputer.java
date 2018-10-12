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

    public double[] impute(Data data){
        //Map setup
        double[][] M = myMap.getCodebook();
        int[] mdim = dim(M);
        //Data setup
        String[][] D = data.getData();
        int[] ddim = dim(D);
        if(mdim!=ddim){
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
        boolean[][] W1 = (mask*ones(ddim[0]))

    }


}
