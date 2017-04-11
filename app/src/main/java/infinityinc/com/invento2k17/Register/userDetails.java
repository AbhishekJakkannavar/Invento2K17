package infinityinc.com.invento2k17.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import infinityinc.com.invento2k17.MainActivity.MainActivity;
import infinityinc.com.invento2k17.R;

public class userDetails extends AppCompatActivity {


    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //View Objects
    EditText nameText, emailText, collegeText, phoneNoText;
    Button saveButton;

    private DatabaseReference databaseReference;

    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        //Initiating Firebase Authentication Object
        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference();


        nameText = (EditText) findViewById(R.id.NameeditText);
        emailText = (EditText) findViewById(R.id.EmailditText);
        collegeText = (EditText) findViewById(R.id.CollegeEditText);
        phoneNoText = (EditText) findViewById(R.id.PhoneEditText);
        saveButton = (Button) findViewById(R.id.saveToServerButton);

        FirebaseUser user = firebaseAuth.getCurrentUser();


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = nameText.getText().toString();
                String email = emailText.getText().toString();
                String college = collegeText.getText().toString();
                String phone = phoneNoText.getText().toString();
                registerDescription desc = new registerDescription(name,email,college,phone);

                FirebaseUser user = firebaseAuth.getCurrentUser();
                databaseReference.child(user.getUid()).setValue(desc);



                nameText.setText("");
                emailText.setText("");
                collegeText.setText("");
                phoneNoText.setText("");

                Toast.makeText(userDetails.this, "Registration Successful", Toast.LENGTH_LONG).show();

                Intent sendToMainActivity = new Intent(userDetails.this, MainActivity.class);
                startActivity(sendToMainActivity);

            }
        });

    }
}
