package com.example.npl_samples;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.shiksha.nlp.loc.posloc.NetworkProvideManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        requestPermissions();
    }
    void requestPermissions() {
        if (!NetworkProvideManager.isLocationPermissionsGranted(this)) {
            String[] permissions = NetworkProvideManager.permissions;
            ActivityCompat.requestPermissions(this, permissions, 10);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==10){
            if (NetworkProvideManager.isLocationPermissionsGranted(this)){
                Toast.makeText(this,"permissions are granted",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(this,"permissions are not granted",Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
}
