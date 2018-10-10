package somethingmonkey.hackduke;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);
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
