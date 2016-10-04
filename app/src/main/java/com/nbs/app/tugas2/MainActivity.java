package com.nbs.app.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String USER_NAME = "admin@uinsgd.ac.id";
    private final String PASSWORD = "admin";
    private EditText inputUsername, inputPassword;
    private TextInputLayout inputLayoutUsername, inputLayoutPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputLayoutUsername = (TextInputLayout)
                findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout)
                findViewById(R.id.input_layout_password);
        inputUsername = (EditText)
                findViewById(R.id.input_email);
        inputPassword = (EditText)
                findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        inputUsername.addTextChangedListener(new
                MyTextWatcher(inputUsername));
        inputPassword.addTextChangedListener(new
                MyTextWatcher(inputPassword));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }
    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateUsername())
            return;
        if (!validatePassword())
            return;
        if(inputUsername.getText().toString().trim().equals(USER_NAME) &&
                inputPassword.getText().toString().trim().equals(PASSWORD)){
            Intent i = new Intent(MainActivity.this, KrsActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(), "anda salah memasukan Username atau Password", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean validateUsername() {
        String email = inputUsername.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutUsername.setError(getString(R.string.err_msg_username)
            );
            requestFocus(inputUsername);
            return false;
        } else {
            inputLayoutUsername.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty())
        {
            inputLayoutPassword.setError(getString(R.string.err_msg_password)
            );
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private class MyTextWatcher implements TextWatcher {
        private View view;
        private MyTextWatcher(View view) {
            this.view = view;
        }
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        public void onTextChanged(CharSequence charSequence, int
                i, int i1, int i2) {
        }
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_email:
                    validateUsername();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }
}