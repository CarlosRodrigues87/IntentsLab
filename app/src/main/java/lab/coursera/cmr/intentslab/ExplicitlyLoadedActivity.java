package lab.coursera.cmr.intentslab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ExplicitlyLoadedActivity extends Activity {

    static private final String TAG = "Lab-Intents";

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicitly_loaded);


        // Get a reference to the EditText field
        mEditText = (EditText) findViewById(R.id.editText);

        // Declare and setup "Enter" button
        Button enterButton = (Button) findViewById(R.id.enter_button);
        enterButton.setOnClickListener(new View.OnClickListener() {

            // Call enterClicked() when pressed

            @Override
            public void onClick(View v) {

                enterClicked();

            }
        });


    }

    // Sets result to send back to calling Activity and finishes

    private void enterClicked() {

        Log.i(TAG, "Entered enterClicked()");

        String txtValue = mEditText.getText().toString();

        Log.i(TAG, "valor da label :" + txtValue);

        Intent intent = new Intent(ExplicitlyLoadedActivity.this, ActivityLoaderActivity.class);

        intent.putExtra("txtValue",txtValue);

        setResult(RESULT_OK, intent);
        super.finish();
    }

}
