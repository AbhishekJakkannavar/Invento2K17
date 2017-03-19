package infinityinc.com.invento2k17.Register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import infinityinc.com.invento2k17.R;

public class userDetails extends AppCompatActivity {

    final static String DB_URL="https://invento2k17app.firebaseio.com/";

    EditText nameText,emailText,collegeText,phoneNoText;
    Button saveButton;
    registerDescription description;  //Here Object of registerDescription is created


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        //Intialise
        initializeFirebase();

        nameText = (EditText)findViewById(R.id.NameeditText);
        emailText = (EditText)findViewById(R.id.EmailditText);
        collegeText = (EditText)findViewById(R.id.CollegeEditText);
        phoneNoText = (EditText)findViewById(R.id.PhoneEditText);
        saveButton = (Button)findViewById(R.id.saveToServerButton);


        //Get Firebase instance

        final Firebase fire = new Firebase(DB_URL);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerDescription desc = new registerDescription();
                desc.setName(nameText.getText().toString());
                desc.setCollegeName(nameText.getText().toString());
                desc.setEmailId(nameText.getText().toString());
                desc.setPhoneNo(nameText.getText().toString());

                //Send Data To FireBase Database
                fire.child("Participants").setValue(desc);

                nameText.setText("");
                emailText.setText("");
                collegeText.setText("");
                phoneNoText.setText("");

            }
        });


    }

    //Initialise our Firebase
    private void initializeFirebase(){
        Firebase.setAndroidContext(this);
    }
}
