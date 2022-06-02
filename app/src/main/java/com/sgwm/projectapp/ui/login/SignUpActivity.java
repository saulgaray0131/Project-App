package com.sgwm.projectapp.ui.login;

import static android.view.View.GONE;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.sgwm.projectapp.R;
import com.sgwm.projectapp.ui.login.LoginViewModel;
import com.sgwm.projectapp.ui.login.LoginViewModelFactory;
import com.sgwm.projectapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivitySignUpBinding binding;
    private Fragment confirmFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText emailEditText = binding.emailSignup;
        final EditText passwordEditText = binding.passwordSignup;
        final Button createButton = binding.createButton;
        final ProgressBar loadingProgressBar = binding.loading;


        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(emailEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };

        emailEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(emailEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //loadingProgressBar.setVisibility(View.VISIBLE);

                AuthSignUpOptions options = AuthSignUpOptions.builder()
                        .userAttribute(AuthUserAttributeKey.email(), emailEditText.getText().toString())
                        .build();

                Amplify.Auth.signUp(emailEditText.getText().toString(), passwordEditText.getText().toString(), options,
                        result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                        error -> Log.e("AuthQuickStart", "Sign up failed", error)
                );

                emailEditText.setVisibility(GONE);
                passwordEditText.setVisibility(GONE);
                createButton.setVisibility(GONE);

                confirmFragment = new AccountConfirmFragment(emailEditText.getText().toString());
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.signup_fragment_layout, confirmFragment, "CONFIRM_TAG")
                        .commit();
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}