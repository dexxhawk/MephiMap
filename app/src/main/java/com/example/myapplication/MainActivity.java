package com.example.myapplication;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyCallback;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView ImageG1, ImageG2, ImageB2, ImageB3;
    Button button;
    Spinner spinnerf, spinnert;


    public ArrayList<Integer> Splitter(String str){
        try {
            String[] strings = str.split(" ");
            ArrayList<Integer> ints = new ArrayList<Integer>();
            for (int p = 0; p<strings.length; p++){
                ints.add(p, Integer.parseInt(strings[p]));
            }
            return ints;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> SplitterStr(String str){
        try {
            String[] strings = str.split(" ");
            ArrayList<String> stringr = new ArrayList<String>();
            for (int p = 0; p<strings.length; p++) {
                stringr.add(strings[p]);
            }
            return stringr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer idxValue(ArrayList<String> array, String string){
        Integer k = 0;
        while (!array.get(k).equals(string)){
            k++;
        }
        return k;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WayFounding wf = new WayFounding();
        wf.fillData();

        DataStore fillbuildings = new DataStore();
        DataStore G1 = fillbuildings.fillG1();
        DataStore G2 = fillbuildings.fillG2();
        DataStore B2 = fillbuildings.fillB2();
        DataStore B3 = fillbuildings.fillB3();

        Map<String, DataStore> GetMap = new HashMap<String, DataStore>();
        GetMap.put("G1", G1);
        GetMap.put("G2", G2);
        GetMap.put("B2", B2);
        GetMap.put("B3", B3);


        imageView = findViewById(R.id.imageView);
        ImageG1 = findViewById(R.id.G1);
        ImageG2 = findViewById(R.id.G2);
        ImageB2 = findViewById(R.id.B2);
        ImageB3 = findViewById(R.id.B3);
        spinnerf = findViewById(R.id.spinnerFrom);
        spinnert = findViewById(R.id.spinnerTo);
        button = findViewById(R.id.Load);

        Map<String, ImageView> GetImageview = new HashMap<String, ImageView>();
        GetImageview.put("G1", ImageG1);
        GetImageview.put("G2", ImageG2);
        GetImageview.put("B2", ImageB2);
        GetImageview.put("B3", ImageB3);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = spinnerf.getSelectedItem().toString();
                String to = spinnert.getSelectedItem().toString();
                String fromsub = from.substring(0,2);
                String tosub = to.substring(0,2);
                ArrayList<OBJ> result = new ArrayList<OBJ>();
                result = wf.wayfounding(fromsub, tosub);


                if(result.get(0).F1==0){
                    Button buttonn = newbutton2(result.get(0).F2.get(0));
                    String build = result.get(0).F2.get(0);

                    String idxFrom = GetMap.get(fromsub).rooms.get(from);
                    String idxTo = GetMap.get(tosub).rooms.get(to);
                    String coord = GetMap.get(fromsub).Center.get("Center");

                    assert idxFrom != null;
                    ArrayList<Integer> Fxy = Splitter(idxFrom);
                    ArrayList<Integer> Txy = Splitter(idxTo);
                    ImageView Draws = GetImageview.get(build);
                    //Draw drawer = new Draw();

                    draws(Draws, Fxy.get(0), Fxy.get(1), Txy.get(0), Txy.get(1), build, coord);

                    RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout);
                    layout.addView(buttonn);
                    buttonn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Map<String, ImageView> GetImageview = new HashMap<String, ImageView>();
                            GetImageview.put("G1", ImageG1);
                            GetImageview.put("G2", ImageG2);
                            GetImageview.put("B2", ImageB2);
                            GetImageview.put("B3", ImageB3);
                            ImageG1.setVisibility(View.INVISIBLE);
                            ImageG2.setVisibility(View.INVISIBLE);
                            ImageB2.setVisibility(View.INVISIBLE);
                            ImageB3.setVisibility(View.INVISIBLE);
                            imageView.setVisibility(View.INVISIBLE);
                            GetImageview.get(build).setVisibility(View.VISIBLE);
                        }
                    });
                }
                else{
                    ArrayList<Button> buttons = new ArrayList<Button>();
                    for (int i = 0; i<=result.get(0).F1; i++){
                        //System.out.println("HELLO");
                        buttons.add(i, newbutton2(result.get(0).F2.get(i)));
                        String build = result.get(0).F2.get(i);
                        if(i==0) {
                            String nextbuild = result.get(0).F2.get(i + 1);
                            String idxFrom = GetMap.get(build).rooms.get(from);
                            ArrayList<Integer> Fxy = Splitter(idxFrom);

                            String idxTo = GetMap.get(build).TransitPoints.get(nextbuild);
                            ArrayList<Integer> Txy = Splitter(idxTo);

                            String coord = GetMap.get(build).Center.get("Center");

                            ImageView Draws = GetImageview.get(build);

                            draws(Draws, Fxy.get(0), Fxy.get(1), Txy.get(0), Txy.get(1),build,coord);
                        }
                        else if (i==result.get(0).F1){
                            String prevbuild = result.get(0).F2.get(i - 1);
                            String idxFrom = GetMap.get(build).TransitPoints.get(prevbuild);
                            ArrayList<Integer> Fxy = Splitter(idxFrom);

                            String idxTo = GetMap.get(build).rooms.get(to);
                            ArrayList<Integer> Txy = Splitter(idxTo);

                            ImageView Draws = GetImageview.get(build);

                            String coord = GetMap.get(build).Center.get("Center");

                            draws(Draws, Fxy.get(0), Fxy.get(1), Txy.get(0), Txy.get(1), build, coord);
                        }

                        else {

                            String nextbuild = result.get(0).F2.get(i + 1);
                            String prevbuild = result.get(0).F2.get(i - 1);

                            String idxFrom = GetMap.get(build).TransitPoints.get(prevbuild);
                            String idxTo = GetMap.get(build).TransitPoints.get(nextbuild);

                            ArrayList<Integer> Fxy = Splitter(idxFrom);
                            ArrayList<Integer> Txy = Splitter(idxTo);
                            ImageView Draws = GetImageview.get(build);
                            String coord = GetMap.get(build).Center.get("Center");

                            draws(Draws, Fxy.get(0), Fxy.get(1), Txy.get(0), Txy.get(1), build, coord);

                        }

                    }
                    Integer tor = 0;
                    RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout);
                    for (int l = 0; l<buttons.size(); l++){
                        String corp = buttons.get(l).getText().toString();
                        tor+=100;
                        layout.addView(buttons.get(l));
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) buttons.get(l).getLayoutParams();
                        params.setMargins(45, tor, tor ,tor);
                        buttons.get(l).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Map<String, ImageView> GetImageview = new HashMap<String, ImageView>();
                                GetImageview.put("G1", ImageG1);
                                GetImageview.put("G2", ImageG2);
                                GetImageview.put("B2", ImageB2);
                                GetImageview.put("B3", ImageB3);
                                ImageG1.setVisibility(View.INVISIBLE);
                                ImageG2.setVisibility(View.INVISIBLE);
                                ImageB2.setVisibility(View.INVISIBLE);
                                ImageB3.setVisibility(View.INVISIBLE);
                                imageView.setVisibility(View.INVISIBLE);
                                GetImageview.get(corp).setVisibility(View.VISIBLE);
                            }
                        });
                    }

                }


            }
        });


    }



    Integer top = 0;

    public void draws(ImageView v, Integer FromX, Integer FromY, Integer ToX, Integer ToY, String build, String coord){

        ArrayList<Integer> Xy = Splitter(coord);
        Integer Cx = Xy.get(0);
        Integer Cy = Xy.get(1);

        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        System.out.println(v.getWidth());
        System.out.println(v.getHeight());
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);


        canvas.drawLine(Math.round(FromX*v.getWidth()/1920), Math.round(FromY*v.getHeight()/1080), Cx*v.getHeight()/1080, Cy*v.getHeight()/1080, paint);
        canvas.drawLine(Cx*v.getHeight()/1080, Cy*v.getHeight()/1080, Math.round(ToX*v.getWidth()/1920), Math.round(ToY*v.getHeight()/1080), paint);

        v.setImageBitmap(bitmap);
        v.getLayoutParams().width = 1080;
        v.getLayoutParams().height = 1920;
        top+=20;
        spinnert.requestLayout();
    }


    public Button newbutton2(String corp) {
        //System.out.println(corp);
        Button myButton = new Button(MainActivity.this);
        myButton.setText(corp);
        return myButton;
    }

    Integer Tag = 0;
    public Button newbutton(String corp){
        try {
            Tag++;
            Button myButton = new Button(MainActivity.this);
            myButton.setText(corp);
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout);
            myButton.setTag(Tag);
            myButton.setId(Tag);
            layout.addView(myButton);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Map<String, ImageView> GetImageview = new HashMap<String, ImageView>();
                    GetImageview.put("G1", ImageG1);
                    GetImageview.put("G2", ImageG2);
                    GetImageview.put("B2", ImageB2);
                    GetImageview.put("B3", ImageB3);
                    ImageG1.setVisibility(View.INVISIBLE);
                    ImageG2.setVisibility(View.INVISIBLE);
                    ImageB2.setVisibility(View.INVISIBLE);
                    ImageB3.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    GetImageview.get(corp).setVisibility(View.VISIBLE);
                    top+=10;
                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) GetImageview.get(corp).getLayoutParams();
                    params.setMargins(45, top, 0 ,0);
                    top+=20;

                }
            });
            return myButton;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}