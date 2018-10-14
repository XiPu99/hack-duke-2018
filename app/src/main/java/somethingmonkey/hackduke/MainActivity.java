package somethingmonkey.hackduke;

import android.app.ActivityOptions;
import android.content.Context;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import somethingmonkey.hackduke.Impute.Imputer;
import somethingmonkey.hackduke.Impute.Map;
import somethingmonkey.hackduke.Model.CSPPTModel;


public class MainActivity extends AppCompatActivity{
    private static Context context;
    ProgressBar mProgressBar;
    FloatingActionButton nextButton;
    TextInputEditText nameInput;
    boolean hide = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        context = this;
        CSPPTModel cm =  new CSPPTModel();
        //Log.d("score",String.valueOf(cm.calculateRisk(new double[]{25,0,0,0,0,0,13,120,70,6.92,0,0,0,8.672,13.44})));
        /*if(context==null)Log.d("test1","fk");
        else Log.d("test1","nice");
        Map map = new Map();
        Log.d("Map",String.valueOf(map.getCodebook().length)+" "+String.valueOf(map.getCodebook()[0].length));
        Log.d("Mask",String.valueOf(map.getMask().length));
        Log.d("Mask value",String.valueOf(map.getMask()[0]));
        Imputer imp = new Imputer(map);
        Log.d("Imputer","initialized");
        double[] result = imp.impute(new String[][]{{"60","0","0","0","0","0","NA","174","78","4.78","0","0","NA","NA","7.60"}});
        Log.d("result",String.valueOf(result[0]));
        Log.d("age",String.valueOf(map.getEntry((int)result[0],0)));*/
        nextButton = findViewById(R.id.next_button);
        nameInput = findViewById(R.id.nameInput);
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Log.d("Text", charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0){
                    nextButton.hide();
                }
                else{
                    nextButton.show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
//                Log.d("Text", editable.toString());
            }
        });



        new Thread(new Runnable() {
            @Override
            public void run() {
                testDb();
            }
        }) .start();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public static Context getAppContext() {
        Log.d("context request","called!");
        return context;
    }

    public void swipe(View v){
        if(!hide){
            nextButton.hide();
            hide = true;
        }
        else{
            nextButton.show();
            hide = false;
        }
    }




    private void testDb(){
//        DataDataBase db = Room.databaseBuilder(getApplicationContext(),
//                DataDataBase.class, "database-name").build();
//
//        DataEntity test = new DataEntity(0,0,0,0,0,
//                0,0,00,0,0,0,0,0,0,0,"","");
//
////        db.daoAccess().deleteAll();
//
//        db.daoAccess().insertAll(test);
//
//        for(DataEntity d: db.daoAccess().findUserWithName("")){
//            Log.d("Data", d.toString());
//        }



//        for( DataEntity d: db.daoAccess().getAll() ){
//            Log.d("Data", d.toString());
//        }
    }





    public void setProgressBar(View v){
//        mProgressBar.setProgress(mProgressBar.getProgress()-10);
        ProgressBarAnimation anim = new ProgressBarAnimation(mProgressBar, 0, 100);
        anim.setDuration(1000);
        mProgressBar.startAnimation(anim);
    }

    public void goToGenderSetup(View v){
        Intent intent = new Intent(this, GenderPickerActivity.class);
        startActivity(intent);
    }


    private void hideSystemUI(){
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
