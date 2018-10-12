package somethingmonkey.hackduke;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.fragment.app.DialogFragment;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        TextView birthdayTextView = getActivity().findViewById(R.id.birthdayTextView);
        try {
            Date date = fmt.parse(String.format("%d-%d-%d", year, month+1, day)); // add 1 to month because month starts from 0 like an array index
            birthdayTextView.setText(DateFormat.getDateInstance(DateFormat.LONG).format(date));
        } catch (ParseException e) {
            Toast.makeText(getActivity(), "Date parsing error", Toast.LENGTH_LONG).show();
        }
    }

}
