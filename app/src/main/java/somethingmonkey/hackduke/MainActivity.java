package somethingmonkey.hackduke;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

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
        nextButton.hide();
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
