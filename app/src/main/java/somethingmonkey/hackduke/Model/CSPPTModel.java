package somethingmonkey.hackduke.Model;

public class CSPPTModel implements RiskModel {

    public static final double SD = 0.6313588;
    public static final double PI = 3.14159265;
    public static final double MEAN = 6.658;

    public CSPPTModel(){

    }

    @Override
    public double calculateRisk(double[] params) {
        if(params.length<15){
            throw new IndexOutOfBoundsException("params not long enough");
        }
        double risk =  0.033116622*params[0]+
                        0.388792965*params[1]+
                        0.130156425*params[2]+
                        0.055110387*params[3]+
                        -0.139966599*params[4]+
                        -0.10524916*params[5]+
                        -0.004788797*params[6]+
                        0.01653021*params[7]+
                        0.014178248*params[8]+
                        0.151970888*params[9]+
                        0.607291116*params[10]+
                        -0.164337861*params[11]+
                        0.057980826*params[12]+
                        -0.026832393*params[13]+
                        -0.000731346*params[14];
        if(risk<=0){
            return 0;
        }
        else{
            return 1 - ((1/Math.sqrt(2* PI *Math.pow(SD,2)))*Math.exp(-(Math.pow(risk - MEAN,2)/(2*Math.pow(SD,2)))));
        }
    }
}
