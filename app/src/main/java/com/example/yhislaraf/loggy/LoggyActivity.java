package com.example.yhislaraf.loggy;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Console;

/**
 * Created by yhislaraf on 18-05-17.
 */

public class LoggyActivity extends AppCompatActivity {

    private SharedPreferences spref;

    private EditText mail;
    private EditText pass;
    private Switch remember;
    private Button btnLog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        BindUI();

        spref = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        setCredentialIfExist();

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mail.getText().toString();
                String password = pass.getText().toString();
                Boolean sremember = remember.isChecked();
                if(Verificar(email,password)){
                    SavePreferences(email,password,sremember);
                    goToMain();
                }

            }
        });
    }

    private void BindUI(){

        mail = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPass);
        remember = (Switch) findViewById(R.id.SRemember);
        btnLog = (Button) findViewById(R.id.btnLog);

    }

    private Boolean Verificar(String email, String password){

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"this fields mail can't be empty, please try again",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"this fields pass can't be empty, please try again", Toast.LENGTH_LONG).show();
            return false;
        }
 else{
            return true;
        }
    }

    private void goToMain(){
        Intent main = new Intent(this,MainActivity.class);
        //flags para cerrar activity y no regresar a la anterior
        main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(main);
    }

    private void SavePreferences(String email,String password, Boolean sremember){
        if(sremember){
            SharedPreferences.Editor editor = spref.edit();
            editor.putString("email",email);
            editor.putString("pass",password);
            editor.commit();
            editor.apply();
        }
        else{
            Utils.deleteUserAndPass(spref);
        }
    }

    private void setCredentialIfExist(){
        String email = Utils.getUserMailPref(spref);
        String password = Utils.getUserPassPref(spref);

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mail.setText(email);
            pass.setText(password);
            remember.setChecked(true);
        }
    }
    }

