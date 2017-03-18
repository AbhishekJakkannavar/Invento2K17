package infinityinc.com.invento2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int RC_SIGN_IN = 0;
    private FirebaseAuth auth;
    public ImageButton button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (ImageButton) findViewById(R.id.eventsButton);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            //user logged in
            Log.d("AUTH", auth.getCurrentUser().getEmail());
        } else {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                    .setProviders(
                            AuthUI.FACEBOOK_PROVIDER,
                            AuthUI.EMAIL_PROVIDER,
                            AuthUI.GOOGLE_PROVIDER).build(), RC_SIGN_IN);
        }

        findViewById(R.id.log_out_button).setOnClickListener(this);
        button = (ImageButton) findViewById(R.id.eventsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,details.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                //user logged in
                Log.d("AUTH", auth.getCurrentUser().getEmail());
            } else {
                //User net authenticated
                Log.d("AUTH", "NOT AUTHENTICATED");
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.log_out_button) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent goBackToLoginAgain = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(goBackToLoginAgain);
                        }
                    });
        }


    }




}


