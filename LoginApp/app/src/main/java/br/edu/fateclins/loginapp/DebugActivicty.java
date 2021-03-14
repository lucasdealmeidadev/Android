package br.edu.fateclins.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class DebugActivicty extends AppCompatActivity {

    protected  static final String TAG = "Marca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG,  getClassName() + ".onCreate chamado: " + savedInstanceState);
    }

    protected  void onStart(){
        super.onStart();
        Log.i(TAG,  getClassName() + ".onStart chamado.");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,  getClassName() + ".onRestart chamado.");
    }

    protected void onResume(){
        super.onResume();
        Log.i(TAG, getClassName() + ".onResume() chamado.");
    }

    protected void onPause(){
        super.onPause();
        Log.i(TAG, getClassName() + ".onPause() chamado.");
    }

    protected void onStop(){
        super.onStop();
        Log.i(TAG, getClassName() + ".onStop() chamado.");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, getClassName() + ".onDestroy() chamado.");
    }

    private String getClassName() {
        String s = getClass().getName();
        return s.substring(s.indexOf("."));
    }

    public void onBackPressed(){
        super.onBackPressed();
        Log.i(TAG, getClassName() + ".onBackPressed() chamado.");
    }
}