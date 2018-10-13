package somethingmonkey.hackduke;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class DataEntity {
    @PrimaryKey(autoGenerate = true)
    private int entry_id;

    private int sex;
    private int smoke1;
    private int smoke2;
    private int alcohol1;
    private int alcohol2;
    private int dm;
    private int c677t1;
    private int c677t2;;

    private double fa;
    private double hcy;
    private double bmi;
    private double sbp;
    private double dbp;
    private double tcho;
    private double age;

    private String name;
    private String date;

    public DataEntity(int sex, int smoke1, int smoke2, int alcohol1, int alcohol2,
                      int dm, int c677t1, int c677t2, double fa, double hcy, double bmi,
                      double sbp, double dbp, double tcho, double age, String name, String date) {
        this.sex = sex;
        this.smoke1 = smoke1;
        this.smoke2 = smoke2;
        this.alcohol1 = alcohol1;
        this.alcohol2 = alcohol2;
        this.c677t1 = c677t1;
        this.c677t2 = c677t2;
        this.fa = fa;
        this.hcy = hcy;
        this.bmi = bmi;
        this.sbp = sbp;
        this.dbp = dbp;
        this.tcho = tcho;
        this.age = age;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "DataEntry{" + entry_id + sex + smoke1 + smoke2 + alcohol1 + alcohol2 + c677t1 +
                c677t2 + fa + hcy + bmi + sbp + dbp + tcho + age + name + date + '}';
    }


    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSmoke1() {
        return smoke1;
    }

    public void setSmoke1(int smoke1) {
        this.smoke1 = smoke1;
    }

    public int getSmoke2() {
        return smoke2;
    }

    public void setSmoke2(int smoke2) {
        this.smoke2 = smoke2;
    }

    public int getAlcohol1() {
        return alcohol1;
    }

    public void setAlcohol1(int alcohol1) {
        this.alcohol1 = alcohol1;
    }

    public int getAlcohol2() {
        return alcohol2;
    }

    public void setAlcohol2(int alcohol2) {
        this.alcohol2 = alcohol2;
    }

    public int getDm() {
        return dm;
    }

    public void setDm(int dm) {
        this.dm = dm;
    }

    public int getC677t1() {
        return c677t1;
    }

    public void setC677t1(int c677t1) {
        this.c677t1 = c677t1;
    }

    public int getC677t2() {
        return c677t2;
    }

    public void setC677t2(int c677t2) {
        this.c677t2 = c677t2;
    }

    public double getFa() {
        return fa;
    }

    public void setFa(double fa) {
        this.fa = fa;
    }

    public double getHcy() {
        return hcy;
    }

    public void setHcy(double hcy) {
        this.hcy = hcy;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getSbp() {
        return sbp;
    }

    public void setSbp(double sbp) {
        this.sbp = sbp;
    }

    public double getDbp() {
        return dbp;
    }

    public void setDbp(double dbp) {
        this.dbp = dbp;
    }

    public double getTcho() {
        return tcho;
    }

    public void setTcho(double tcho) {
        this.tcho = tcho;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
