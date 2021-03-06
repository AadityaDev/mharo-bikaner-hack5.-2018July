// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.technawabs.app.mharo.base.barcodescanning;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.technawabs.app.mharo.base.activities.DashboardActivity;
import com.technawabs.app.mharo.base.scanner.FrameMetadata;
import com.technawabs.app.mharo.base.scanner.GraphicOverlay;
import com.technawabs.app.mharo.base.scanner.VisionProcessorBase;
import com.technawabs.app.mharo.base.utils.XMLReader;

import java.io.IOException;
import java.util.List;

/** Barcode Detector Demo. */
public class BarcodeScanningProcessor extends VisionProcessorBase<List<FirebaseVisionBarcode>> {

  private static final String TAG = "BarcodeScanProc";

  private final FirebaseVisionBarcodeDetector detector;

  private Context context;

  public BarcodeScanningProcessor(Context context) {
    // Note that if you know which format of barcode your app is dealing with, detection will be
    // faster to specify the supported barcode formats one by one, e.g.
    // new FirebaseVisionBarcodeDetectorOptions.Builder()
    //     .setBarcodeFormats(FirebaseVisionBarcode.FORMAT_QR_CODE)
    //     .build();
      this.context = context;
    detector = FirebaseVision.getInstance().getVisionBarcodeDetector();
  }

  @Override
  public void stop() {
    try {
      detector.close();
    } catch (IOException e) {
      Log.e(TAG, "Exception thrown while trying to close Barcode Detector: " + e);
    }
  }

  @Override
  protected Task<List<FirebaseVisionBarcode>> detectInImage(FirebaseVisionImage image) {
    return detector.detectInImage(image);
  }

  @Override
  protected void onSuccess(
      @NonNull List<FirebaseVisionBarcode> barcodes,
      @NonNull FrameMetadata frameMetadata,
      @NonNull GraphicOverlay graphicOverlay) {
    graphicOverlay.clear();
    for (int i = 0; i < barcodes.size(); ++i) {
      FirebaseVisionBarcode barcode = barcodes.get(i);
      Log.d(TAG,barcode.getRawValue()+"\t"+i);
      if(barcode!=null&&barcode.getRawValue()!=null){
          String res = barcode.getRawValue();
          boolean isValidXML=XMLReader.readXMLResponse(res);
          if(isValidXML||res.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                  "<PrintLetterBarcodeData ")){
              Intent intent = new Intent(context,DashboardActivity.class);
              context.startActivity(intent);
          }
      }
      BarcodeGraphic barcodeGraphic = new BarcodeGraphic(graphicOverlay, barcode);
      graphicOverlay.add(barcodeGraphic);
    }
  }

  @Override
  protected void onFailure(@NonNull Exception e) {
    Log.e(TAG, "Barcode detection failed " + e);
  }
}
