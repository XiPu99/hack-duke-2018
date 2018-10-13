package somethingmonkey.hackduke.ImputeUtils;

/*Various utilities used during imputation computation
* Based on MatLab counterparts
* */
public class ImputeUtil {
    //change row of a matrix to another row
    public static double[][] rowchange(int row, double[] newrow, double[][] data){
        double[][] result = data;
        data[row] = newrow;
        return result;
    }

    //change rows of a matrix to just 1's
    public static double[][] onerow(int[] rows,double[][] data){
        double[][] result = data;
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[rows[i]][j] = 1;
            }
        }
        return result;
    }

    //find minimum in each column of a matrix and which entry it belongs to
    public static double[][] min(double[][] data){
        System.out.println("data rows "+data.length+" data cols "+data[0].length);
        double[][] result = new double[2][data[0].length];
        for(int i=0;i<data[0].length;i++){
            double min = data[i][0];
            int index = 0;
            for(int j=1;j<data.length;j++){
                if(data[j][i]<min){
                    min = data[j][i];
                    index = j;
                }
            }
            result[0][i] = min;
            result[1][i] = index;
        }
        return result;
    }

    //create integer array for range given
    public static int[] range(int a, int b){
        int[] result = new int[b-a+1];
        for(int i=0;i<b-a+1;i++){
            result[i] = a+i;
        }
        return result;
    }

    //extract specific rows of a matrix
    public static double[][] rowSelect(int[] rows, double[][] matrix){
        double[][] result = new double[rows.length][matrix[0].length];
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                result[i][j] = matrix[rows[i]][j];
            }
        }
        return result;
    }

    //extract specific columns of a matrix
    public static double[][] colSelect(int[] cols, double[][] matrix){
        double[][] result = new double[matrix.length][cols.length];
        for(int i=0;i<cols.length;i++){
            for(int j=0;j<matrix.length;j++){
                result[j][i]=matrix[j][cols[i]-1];
            }
        }
        return result;
    }

    //element wise matrix subtraction a-b, make sure a and b have same dimensions!
    public static double[][] subtractMatrix(double[][] a, double[][] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    //element wise matrix multiplication, make sure and b have same dimensions!!
    public static double[][] multMatrix(double[][] a,double[][] b){
        double[][] result = new double[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                result[i][j] = a[i][j] * b[i][j];
            }
        }
        return result;
    }

    //element-wise power operation
    public static double[][] expMatrix(double a, double[][] data){
        double[][] result = new double[data.length][data[0].length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[i][j] = Math.pow(data[i][j],a);
            }
        }
        return result;
    }

    //convert boolean matrix to double matrix
    public static double[][] parseBoolMatrix(boolean[][] data){
        double[][] result = new double[data.length][data[0].length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                if(data[i][j]){
                    result[i][j]=1;
                }
                else{
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    //convert String matrix to double matrix
    public static double[][] parseStringMatrix(String[][] data){
        double[][] result = new double[data.length][data[0].length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[i][j] = Double.parseDouble(data[i][j]);
            }
        }
        return result;
    }

    //scalar multiple to matrix
    public static double[][] scalar(double c, double[][]matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = c* matrix[i][j];
            }
        }
        return matrix;
    }
    
    //multiply two matrices. ncol(A)==nrow(B) or else won't work!
    public static double[][] mult(double[][] a, double[][] b){
        int aRows = a.length;
        int aColumns = a[0].length;
        int bRows = b.length;
        int bColumns = b[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] C = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return C;
    }

    //diagonalize a vector
    public static double[][] diag(double[] vec){
        double[][] result = new double[vec.length][vec.length];
        for(int i=0;i<vec.length;i++){
            for(int j=0;j<vec.length;j++){
                if(i==j){
                    result[i][j] = vec[i];
                }
                else{
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    //replace NA with 0
    public static String[][] zeroNA(String[][] data){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                if("NA".equalsIgnoreCase(data[i][j])){
                    data[i][j] = "0";
                }
            }
        }
        return data;
    }

    //complex conjugate transpose for double
    public static double[][] ctranspose(double[][] data){
        double[][] result = new double[data[0].length][data.length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[j][i]=data[i][j];
            }
        }
        return result;
    }

    //complex conjugate transpose for boolean
    public static boolean[][] ctranspose(boolean[][] data){
        boolean[][] result = new boolean[data[0].length][data.length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[j][i]=data[i][j];
            }
        }
        return result;
    }

    //complex conjugate transpose for String
    public static String[][] ctranspose(String[][] data){
        String[][] result = new String[data[0].length][data.length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                result[j][i]=data[i][j];
            }
        }
        return result;
    }

    //creates a matrix of all ones
    public static double[][] ones(int r, int c){
        double[][] result = new double[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                result[i][j] = 1;
            }
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
        return new int[]{r,c};
    }

    public static int[] dim(double[][] data){
        int r = data.length;
        int c = data[0].length;
        return new int[]{r,c};
    }
}
