package somethingmonkey.hackduke.Model;

interface RiskModel {
    /*
    * interface for risk models used to assess user risk.
    * @param params the double[] of parameter values to pass use in the computation
    * */
    double calculateRisk(double[] params);

}
