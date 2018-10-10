package somethingmonkey.hackduke;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
        mProgressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void swipe(View v){
//        getWindow().setExitTransition(new Slide(Gravity.LEFT));
        Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
//        startActivity(intent,
//                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        startActivity(intent);
    }

    public void setProgressBar(View v){
//        mProgressBar.setProgress(mProgressBar.getProgress()-10);
        ProgressBarAnimation anim = new ProgressBarAnimation(mProgressBar, mProgressBar.getProgress(), 100);
        anim.setDuration(1000);
        mProgressBar.startAnimation(anim);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
