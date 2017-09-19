package com.example.demoroom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextId;
    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                new SignUpSync().execute(user);
            }
        });
    }


    public class SignUpSync extends AsyncTask<User, Void, Long>{

        @Override
        protected Long doInBackground(User... users) {
            return DatabaseManager.getInstance().getDatabase().getUserDao().insert(users[0]);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            String message;
            if(aLong != -1){
                message = "User created ! "+aLong;
            } else {
                message = "There was an error creating the user";
            }

            Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();

        }
    }

}
