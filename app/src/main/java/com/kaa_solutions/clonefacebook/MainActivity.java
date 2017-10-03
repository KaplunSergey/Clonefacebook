package com.kaa_solutions.clonefacebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginb = (Button) findViewById(R.id.button);
        Button regb = (Button) findViewById(R.id.button2);

        final TextView login = (TextView) findViewById(R.id.editText);
        final TextView password = (TextView) findViewById(R.id.editText3);

        loginb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent motionEvent) {

                if (login.getText().length() == 0) {
                    toast = Toast.makeText(getApplicationContext(),
                                           "Ener login",
                                           Toast.LENGTH_SHORT
                    );
                    toast.show();
                    return false;
                }

                Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(login.getText());
                boolean checkEmail = matcher.matches();
                if (checkEmail) {
                    toast = Toast.makeText(getApplicationContext(), "Entry", Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(getApplicationContext(),
                                           "Wrong email",
                                           Toast.LENGTH_SHORT
                    );
                }

                if (password.getText().length() < 4) {
                    toast = Toast.makeText(getApplicationContext(),
                                           "Password is less than 4 characters",
                                           Toast.LENGTH_SHORT
                    );
                    toast.show();
                    return false;
                }

                toast.show();
                return checkEmail;
            }
        });

        regb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                toast = Toast.makeText(getApplicationContext(),
                                       "Registration",
                                       Toast.LENGTH_SHORT
                );
                toast.show();
                return true;
            }
        });
    }
}
