package com.example.yhislaraf.loggy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences spref;

    private EditText email;
    private EditText pass;
    private Switch remember;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindUI();
        spref = getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    private void BindUI(){
// referencias
        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPass);
        remember = (Switch) findViewById(R.id.SRemember);
        btnLogin = (Button) findViewById(R.id.btnLog);
    }

    private void logOut(){
        Intent logout = new Intent(this,LoggyActivity.class);
        logout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logout);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                logOut();
                return true;
            case R.id.item2:
                Utils.deleteUserAndPass(spref);
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
