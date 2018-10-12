package somethingmonkey.hackduke.Impute;

public class Data {
    private String[][] data;
    private String[] labels;
    private String name;
    private String[] comp_names;
    private Norm[] comp_norm;
    private String[] label_names;
    Data(String[][] d, String[] lb, String n, String[] cnames, Norm[] cnorm, String[] lbnames){
        data = d;
        labels = lb;
        name = n;
        comp_names = cnames;
        comp_norm = cnorm;
        label_names = lbnames;
    }

    public String[][] getData() {
        return data;
    }
}
