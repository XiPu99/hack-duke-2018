package somethingmonkey.hackduke;

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


public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    FloatingActionButton nextButton;
    TextInputEditText nameInput;
    boolean hide = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

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
