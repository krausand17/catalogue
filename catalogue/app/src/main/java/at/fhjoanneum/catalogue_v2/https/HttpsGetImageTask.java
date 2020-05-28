package at.fhjoanneum.catalogue_v2.https;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

public class HttpsGetImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;

    public HttpsGetImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        HttpsImageClient ic = new HttpsImageClient();
        Bitmap bitmap = null;
        try {
            bitmap = ic.getImage(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        //if (callback != null ) callback.onResult(bitmap);
    }
}
