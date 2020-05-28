package at.fhjoanneum.catalogue_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.material.bottomappbar.BottomAppBar;

import org.json.JSONArray;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.fhjoanneum.catalogue_v2.https.HttpsGetImageTask;
import at.fhjoanneum.catalogue_v2.https.RequestCallback;

public class MainActivity extends AppCompatActivity implements RequestCallback {

    private BottomAppBar bottomAppBar;
    private List<String> breeds = new ArrayList<>();
    private Map<String,String> breedMap = new HashMap();
    private ImageView mainImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainImageView = (AppCompatImageView) findViewById(R.id.main_image);

        bottomAppBar = findViewById(R.id.bottomBar);
        setSupportActionBar(bottomAppBar);
       testList();
       testMap();

       setMainImage("https://cdn2.thecatapi.com/images/au1.jpg");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.breed_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add("Random");
        for(String breed : breedMap.keySet()){
            menu.add(breedMap.get(breed));
        }
        return true;
    }


    public void testList(){
        if(breeds.isEmpty()) {

            breeds.add("bobcat");
            breeds.add("abbessian");
            breeds.add("lynx");
        }
    }

    public void setMainImage(String newImageUrl) {
        HttpsGetImageTask it = new HttpsGetImageTask(this.mainImageView);
        it.execute(newImageUrl);

    }

    public void testMap(){
        if(breedMap.isEmpty()){
            breedMap.put("abys","Abyssinian");
            breedMap.put("chee","Cheetoh");
            breedMap.put("java","Javanese");


        }
    }

    

    @Override
    public void onResult(Bitmap bitmap) {
        mainImageView.setImageBitmap(bitmap);
        mainImageView.refreshDrawableState();

    }

    @Override
    public void onResult(JSONArray json) {

    }
}
