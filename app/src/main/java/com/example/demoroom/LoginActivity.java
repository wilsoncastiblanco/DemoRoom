package com.example.demoroom;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                new LoginSync().execute(userName, password);
            }
        });


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public class LoginSync extends AsyncTask<String, Void, User> {

        @Override
        protected User doInBackground(String... parameters) {
            return DatabaseManager.getInstance().getDatabase().getUserDao().login(parameters[0], parameters[1]);
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            String message;
            if(user != null){
                message = "Welcome ! "+user.getUserName();
            } else {
                message = "User doesn't exist";
            }

            Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();

        }
    }

}
