package com.example.twikale.Views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twikale.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    //authentication listener
    FirebaseAuth.AuthStateListener authStateListener;

    FirebaseUser user;
    Button login,createAccount;

    EditText userName,userEmail,userPassword;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if(user != null){
                    intent = new Intent(MainActivity.this,HostActivity.class);
                    startActivity(intent);
                }else {
                    return;
                }
            }
        };

        userName = findViewById(R.id.edtUserName);

        userEmail = findViewById(R.id.edtUserEmail);

        userPassword = findViewById(R.id.edtUserPassword);

        firebaseAuth = FirebaseAuth.getInstance();



        login = (Button) findViewById(R.id.btn_login);
        createAccount = (Button) findViewById(R.id.btn_createAccount);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog();

//                DialogPlus dialogPlus = DialogPlus.newDialog(MainActivity.this)
//                        .setContentHolder(new ViewHolder(R.layout.create_account))
//                        .setExpanded(true,1950)
//                        .setGravity(Gravity.BOTTOM)
//                        .setCancelable(true)
//                        .create();
//
//                View view = dialogPlus.getHolderView();
//
//                EditText createEmail = (EditText) view.findViewById(R.id.edtCreateEmail);
//
//                EditText createPassword = (EditText) view.findViewById(R.id.edtCreatePassword);
//
//                EditText createUserName = (EditText) view.findViewById(R.id.edtCrateUserName);
//
//                Button makeAccount = (Button) view.findViewById(R.id.createAccountButton);
//
//
//                dialogPlus.show();
//
//                //listen for create account button
//                makeAccount.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(!TextUtils.isEmpty(createEmail.getText().toString())
//                                && !TextUtils.isEmpty(createPassword.getText().toString())
//                                &&!TextUtils.isEmpty(createUserName.getText().toString())){
//                            firebaseAuth.createUserWithEmailAndPassword(createEmail.getText().toString().trim(),createPassword.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                                @Override
//                                public void onSuccess(AuthResult authResult) {
//                                    Toast.makeText(MainActivity.this, "Account Created Successfully. Thank you!", Toast.LENGTH_SHORT).show();
//                                    dialogPlus.dismiss();
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(MainActivity.this, "Opps Something went wrong. try again", Toast.LENGTH_SHORT).show();
//
//                                    Log.i("Message",e.getLocalizedMessage().toString());
//
//                                }
//                            });
//                        }
                    }
//                });
//
//            }
        });


        //log in already existing user
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    logInUser(userEmail.getText().toString().trim(),userPassword.getText().toString().trim());

            }
        });

    }

    //log in method
    public void logInUser(String email, String password){
        if(!userEmail.getText().toString().isEmpty()
        && !userPassword.getText().toString().isEmpty()){
            //sign in user
            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(MainActivity.this,"Log in Successful",Toast.LENGTH_SHORT).show();
                            intent = new Intent(MainActivity.this,HostActivity.class);
                            startActivity(intent);
                            MainActivity.this.finishAffinity();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this,"Sorry something went wrong!",Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this,""+ e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });

        }else {
            Toast.makeText(MainActivity.this,"Please fill in all fields.",Toast.LENGTH_SHORT).show();
        }
    }

    //ensure to log in user if they are already authenticated not log in everytime they open app but after a log time


    @Override
    protected void onStart() {
        super.onStart();
        user = firebaseAuth.getCurrentUser();
        if(user != null){
            intent = new Intent(MainActivity.this, HostActivity.class);
            startActivity(intent);
            MainActivity.this.finishAffinity();
        }
    }

    void createDialog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.create_account);
        //handle clicks
        EditText createEmail = (EditText) dialog.findViewById(R.id.edtCreateEmail);

        EditText createPassword = (EditText) dialog.findViewById(R.id.edtCreatePassword);

        EditText createUserName = (EditText) dialog.findViewById(R.id.edtCrateUserName);

        Button createAccount = (Button) dialog.findViewById(R.id.createAccountButton);

        
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
    }
}