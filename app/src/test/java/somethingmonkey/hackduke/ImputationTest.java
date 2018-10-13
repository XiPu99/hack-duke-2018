package somethingmonkey.hackduke;

import org.junit.Test;

import java.util.Arrays;

import somethingmonkey.hackduke.Impute.Imputer;
import somethingmonkey.hackduke.Impute.Map;

import static org.junit.Assert.*;

public class ImputationTest {

    Map map = new Map(null,"E:\\Duke\\FALL 2018\\HackDuke2018\\hack-duke-2018\\app\\src\\test\\res\\codebook.csv",
            "E:\\Duke\\FALL 2018\\HackDuke2018\\hack-duke-2018\\app\\src\\test\\res\\mask.csv");

    @Test
    public void read_csv_works(){
        double[] expected = new double[]{1.0,1.0,1.0,1.0};
        for(int i=0;i<10;i++){
            System.out.println(map.getCodebook()[i][0]);
        }
        assertEquals(true, Arrays.equals(expected,map.getMask()));
    }

    @Test
    public void impute_works(){
        Imputer imp = new Imputer(map);
        double[] ans = imp.impute(new String[][]{{"0.5","0.5","0.5","0.5"}});
        assertEquals((long)60,(long)ans[0]);
    }
}
