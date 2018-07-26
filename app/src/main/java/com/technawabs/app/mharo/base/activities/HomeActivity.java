package com.technawabs.app.mharo.base.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.technawabs.app.mharo.R;

public class HomeActivity extends AppCompatActivity {

    private FirebaseVisionBarcodeDetectorOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        options = new FirebaseVisionBarcodeDetectorOptions.Builder()
                        .setBarcodeFormats(
                                FirebaseVisionBarcode.FORMAT_QR_CODE,
                                FirebaseVisionBarcode.FORMAT_AZTEC)
                        .build();
    }
}
