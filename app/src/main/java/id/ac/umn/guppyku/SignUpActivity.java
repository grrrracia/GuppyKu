package id.ac.umn.guppyku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText etNama, etEmail, etPassword;
    Button btnBuatAkun;

    private FirebaseAuth mAuth;

    private static final String TAG = "SignUp";

    DatabaseReference mDatabase;

    TextView tvlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNama=findViewById(R.id.etNama);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnBuatAkun=findViewById(R.id.btnBuatAkun);

        tvlogin=(TextView) findViewById(R.id.tvSignIn);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();

//        if(mAuth.getCurrentUser()!=null){
//            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
//            finish();
//        }

        btnBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                String name = etNama.getText().toString();

                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Email mohon diisi ya :)");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Mohon untuk diisi passwordnya :)");
                    return;
                }
                if(password.length()>0 && password.length()<6){
                    etPassword.setError("masukkan password lebih dari 6");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);

                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(name)
                                            .build();

                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Log.d(TAG, "User profile updated.");
                                                    }
                                                }
                                            });

                                    Toast.makeText(SignUpActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                }else{
                                    Toast.makeText(SignUpActivity.this, "Gagal"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    updateUI(null);
                                }
                            }
                        });
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent balikkelogin=new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(balikkelogin);
            }
        });

        getSupportActionBar().hide();
    }

    private void updateUI(FirebaseUser user) {

    }
}