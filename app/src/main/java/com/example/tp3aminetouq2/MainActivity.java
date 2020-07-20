package com.example.tp3aminetouq2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnButtonClickedListener{
    private static Pattern pattern;
    private static Matcher matcher;
    LoginFragment fragment1;
    WelcomeFragment fragment2;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView textViewFragmentCount;
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        textViewFragmentCount=findViewById(R.id.textViewFragmentCount);
        textViewFragmentCount.setText("Compteur de Fragments en backStack:"+fragmentManager.getBackStackEntryCount());
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Compteur de Fragments en backStack:"+fragmentManager.getBackStackEntryCount());
            }
        });
        addLoginFragmentToActivity();

    }
    private void addLoginFragmentToActivity() {
        fragment1=new LoginFragment();

             fragmentTransaction=fragmentManager.beginTransaction();
             fragmentTransaction.add(R.id.fragmentLogin_layout, fragment1 );
             fragmentTransaction.commit();
    }

    private void addWelcomeFragmentToActivity() {
            fragment2 = new WelcomeFragment();

            fragmentManager.getBackStackEntryCount();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentWelcome_layout, fragment2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }

    @Override
    public void onButtonClicked(View view) {
        Log.e(getClass().getSimpleName(),"Button clicked !");
        if(isValidEmail(fragment1)&&isValidPassword(fragment1)){
            System.out.println("Trouvé !");
            addWelcomeFragmentToActivity();
        }
        else if (!isValidEmail(fragment1)) fragment1.txtEmail.setError("Email invalide");
            else fragment1.txtPassword.setError("Mot de passe invalide");



    }
    private boolean isValidEmail(LoginFragment lf){
        String email;
        email=lf.txtEmail.getText().toString();
        pattern=Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-][a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+" +
                                "@[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-][a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]" +
                                "[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+" +
                                ".(com|org|net)$");
        matcher=pattern.matcher(email);
        while(matcher.find()) {
            System.out.println("Trouvé !");
            return true;
        }
        System.out.println("Non Trouvé !");
        return false;


    }
    private boolean isValidPassword(LoginFragment lf){
        String psw;
        psw=lf.txtPassword.getText().toString();
        pattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_!#$%&’*+/=?`{|}~^.-]).{8,40}$");
        matcher=pattern.matcher(psw);
        while(matcher.find()) {
            System.out.println("Trouvé !");
            return true;
        }
        System.out.println("Non Trouvé !");
         return false;


    }

}
