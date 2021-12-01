package id.ac.umn.guppyku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.WindowManager;
import android.window.SplashScreen;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent darisplashkemenu=new Intent(MainActivity.this, MenuActivity.class);
                startActivity(darisplashkemenu);
                finish();
            }
        }, SPLASH_SCREEN);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }
}