package somethingmonkey.hackduke.ImputeUtils;

/*Various utilities used during imputation computation
* Based on MatLab counterparts
* */
public class ImputeUtil {

    //vector dot product
    public static double dot(double[] a, double[] b){
        
    }

    //complex conjugate transpose
    public static boolean[][] ctranspose(boolean[][] data){
        boolean[][] result = new boolean[data[0].length][data.length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[j][i]=data[i][j];
            }
        }
        return result;
    }

    //creates an array of all ones
    public static double[] ones(int size){
        double[] result = new double[size];
        for(int i=0;i<result.length;i++){
            result[i] = 1;
        }
        return result;
    }

    //creates a version of data that contains TRUE if not NA for each entry
    public static boolean[][] known(String[][] data){
        boolean[][] result = new boolean[data.length][data[0].length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[i][j] = !"NA".equalsIgnoreCase(data[i][j]);
            }
        }
        return result;
    }

    //get dimensions of a matrix
    public static int[] dim(Object[][] data){
        int r = data.length;
        int c = data[0].length;
        return new int[]{r,c,};
    }

    public static int[] dim(double[][] data){
        int r = data.length;
        int c = data[0].length;
        return new int[]{r,c,};
    }
}
