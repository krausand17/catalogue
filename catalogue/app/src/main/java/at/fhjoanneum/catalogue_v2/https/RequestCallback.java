package at.fhjoanneum.catalogue_v2.https;

import android.graphics.Bitmap;

import org.json.JSONArray;

public interface RequestCallback {
    public void onResult(Bitmap bitmap);
    public void onResult(JSONArray json);

}
