package somethingmonkey.hackduke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class GenderPickerActivity extends AppCompatActivity{
    FloatingActionButton nextButton;
    ImageView maleIcon;
    ImageView femaleIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        setContentView(R.layout.gender);

        nextButton = findViewById(R.id.next_button);
        maleIcon = findViewById(R.id.maleIcon);
        femaleIcon = findViewById(R.id.femaleIcon);
//        nextButton.hide();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void goToBirthdayPicker(View v){
        Intent intent = new Intent(this, BirthdayPickerActivity.class);
        startActivity(intent);
    }

    public void onClickMaleIcon(View v){
        setIcon(maleIcon, R.drawable.m_select);
        setIcon(femaleIcon, R.drawable.f_nonselect);
    }

    public void onClickFemaleIcon(View v){
        setIcon(maleIcon, R.drawable.m_nonselect);
        setIcon(femaleIcon, R.drawable.f_select);
    }

    private void setIcon(ImageView icon, int resid){
        nextButton.show();
        icon.setImageResource(resid);
        femaleIcon.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

}
