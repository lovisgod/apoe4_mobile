package hng.tech.apoe_4;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    private TextView signUp;
    private EditText email_input;
    private Button reset_pass;
    private String userEmail;
    private Boolean error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        signUp = findViewById(R.id.sign_up_link);
        email_input = findViewById(R.id.email_input);
        reset_pass = findViewById(R.id.reset_button);



        signUp.setOnClickListener(v -> openSignUpPage());
        reset_pass.setOnClickListener(v -> resetPassword());
    }

    private void resetPassword() {
        userEmail = email_input.getText().toString().trim();
        if (ValidateEmail(userEmail) == false) {
            SendResetRequest(userEmail);
        }

    }


    private void openSignUpPage() {
        Intent signUp = new Intent(ForgotPassword.this, RegisterActivity.class);
        startActivity(signUp);
        finish();
    }

    private void SendResetRequest(String userEmail) {
        Toast.makeText(this, userEmail + " is valid", Toast.LENGTH_LONG).show();
        //this is where the show starts

    }

    private boolean ValidateEmail(String userEmail) {
        Log.d("TAG", "ValidateEmail: " + userEmail);
        error = false;
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            error = true;
            email_input.setError("Please enter a valid email address");
        }else {
            error = false;
        }
        return error;
    }

}
