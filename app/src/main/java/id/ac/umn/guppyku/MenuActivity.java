package id.ac.umn.guppyku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){
        }
        Button btnLogin=(Button) findViewById(R.id.btnLogin);
        Button btnSignUp=(Button) findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kemenulogin=new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(kemenulogin);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kemenusignup=new Intent(MenuActivity.this, SignUpActivity.class);
                startActivity(kemenusignup);
            }
        });
    }
}