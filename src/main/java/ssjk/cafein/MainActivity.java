package ssjk.cafein;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.SearchView;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;


public class MainActivity extends AppCompatActivity {

    private long lastTimeBackPressed;
    private static int check = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize(getApplicationContext());
        updatesuggestion(getApplicationContext());

        /*android.app.ActionBar myActionBar = getActionBar();

        //For hiding android actionbar
        myActionBar.hide();*/

        Button btn_toCoffee = (Button) findViewById(R.id. btn_toCoffee);
        Button btn_7gram = (Button) findViewById(R.id. btn_7gram);
        Button btn_CafeHoney = (Button) findViewById(R.id. btn_CafeHoney);
        Button btn_Soleil = (Button) findViewById(R.id. btn_Soleil);
        Button btn_LazyGeek = (Button) findViewById(R.id. btn_LazyGeek);
        Button btn_Hippo = (Button) findViewById(R.id. btn_Hippo);
        Button btn_CafeDan = (Button) findViewById(R.id. btn_CafeDan);
        Button btn_Azit = (Button) findViewById(R.id. btn_Azit);
        Button btn_Trianon = (Button) findViewById(R.id. btn_Trianon);
        Button btn_Creative = (Button) findViewById(R.id. btn_Creative);
        Button btn_TakeBean = (Button) findViewById(R.id. btn_TakeBean);
        Button btn_Hollys = (Button) findViewById(R.id. btn_Hollys);
        Button btn_Rehoboth = (Button) findViewById(R.id. btn_Rehoboth);
        Button btn_Botong = (Button) findViewById(R.id. btn_Botong);
        Button btn_BongJuice = (Button) findViewById(R.id. btn_BongJuice);
        Button btn_WafflePan = (Button) findViewById(R.id. btn_WafflePan);
        Button btn_Juicy = (Button) findViewById(R.id. btn_Juicy);
        Button btn_CafeLondon = (Button) findViewById(R.id. btn_CafeLondon);
        Button btn_TomNToms = (Button) findViewById(R.id. btn_TomNToms);
        Button btn_coffeeman = (Button) findViewById(R.id. btn_Coffeeman);
        Button btn_Coffeeban = (Button) findViewById(R.id.btn_Coffeeban);
        Button btn_search = (Button) findViewById(R.id. btn_search);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent;
                int buttonid = v.getId();
                if (buttonid == R.id. btn_toCoffee){
                    intent = new Intent(MainActivity.this, CoffeeActivity.class);
                    startActivity(intent);
                }
                else if(buttonid == R.id. btn_search){
                    intent = new Intent(MainActivity.this, BeginSearchActivity.class);
                    startActivity(intent);
                }
                else if (buttonid > 0){
                    intent = new Intent(MainActivity.this, CafeInformation.class);
                    switch (buttonid){
                        case R.id. btn_7gram:
                            intent.putExtra("CafeName","7gram");
                            break;
                        case R.id. btn_CafeHoney:
                            intent.putExtra("CafeName","CAFE HONEY");
                            break;
                        case R.id. btn_Soleil:
                            intent.putExtra("CafeName","Soleil");
                            break;
                        case R.id. btn_LazyGeek:
                            intent.putExtra("CafeName","LAZY GEEK");
                            break;
                        case R.id. btn_Hippo:
                            intent.putExtra("CafeName","HIPPO");
                            break;
                        case R.id. btn_CafeDan:
                            intent.putExtra("CafeName","카페단");
                            break;
                        case R.id. btn_Azit:
                            intent.putExtra("CafeName","Azit");
                            break;
                        case R.id. btn_Trianon:
                            intent.putExtra("CafeName","TRIANON");
                            break;
                        case R.id. btn_Creative:
                            intent.putExtra("CafeName","CREATIVE COFFEE");
                            break;
                        case R.id.btn_Coffeeban:
                            intent.putExtra("CafeName", "커피에 반하다");
                            break;
                        case R.id. btn_Coffeeman:
                            intent.putExtra("CafeName","COFFEEMAN");
                            break;
                        /*case R.id. btn_TakeBean:
                            intent.putExtra("CafeName","TAKEBEAN");
                            break;*/
                        case R.id. btn_Hollys:
                            intent.putExtra("CafeName","HOLLYS");
                            break;
                        case R.id. btn_Rehoboth:
                            intent.putExtra("CafeName","Rehoboth");
                            break;
                        case R.id. btn_Botong:
                            intent.putExtra("CafeName","보통카페");
                            break;
                        case R.id. btn_BongJuice:
                            intent.putExtra("CafeName","봉쥬스");
                            break;
                        case R.id. btn_WafflePan:
                            intent.putExtra("CafeName","Waffle Pan");
                            break;
                        case R.id. btn_Juicy:
                            intent.putExtra("CafeName","JUICY");
                            break;
                        case R.id. btn_CafeLondon:
                            intent.putExtra("CafeName","CAFE LONDON");
                            break;
                        case R.id. btn_TomNToms:
                            intent.putExtra("CafeName","TOM N TOMS");
                            break;
                    }
                    startActivity(intent);
                }

            }
        };



        btn_toCoffee.setOnClickListener(listener);
        btn_7gram.setOnClickListener(listener);
        btn_CafeHoney.setOnClickListener(listener);
        btn_Soleil.setOnClickListener(listener);
        btn_LazyGeek.setOnClickListener(listener);
        btn_Hippo.setOnClickListener(listener);
        btn_CafeDan.setOnClickListener(listener);
        btn_Azit.setOnClickListener(listener);
        btn_Trianon.setOnClickListener(listener);
        btn_Creative.setOnClickListener(listener);
        btn_TakeBean.setOnClickListener(listener);
        btn_Hollys.setOnClickListener(listener);
        btn_Rehoboth.setOnClickListener(listener);
        btn_Botong.setOnClickListener(listener);
        btn_BongJuice.setOnClickListener(listener);
        btn_WafflePan.setOnClickListener(listener);
        btn_LazyGeek.setOnClickListener(listener);
        btn_Juicy.setOnClickListener(listener);
        btn_CafeLondon.setOnClickListener(listener);
        btn_TomNToms.setOnClickListener(listener);
        btn_coffeeman.setOnClickListener(listener);
        btn_Coffeeban.setOnClickListener(listener);
        btn_search.setOnClickListener(listener);
    }

    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-lastTimeBackPressed<1500){
            finish();
            return;
        }

        Toast.makeText(this,"'뒤로' 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();

        lastTimeBackPressed = System.currentTimeMillis();

    }
    public static final String PACKAGE_DIR = "/data/data/ssjk.cafein/";
    public static final String DATABASE_NAME = "cafe.sqlite";
    public static final String COPY2DATABASE_NAME = "cafesd1.db";
    public static void initialize(Context ctx) {
        // check
        File folder = new File(PACKAGE_DIR + "databases");
        folder.mkdirs();
        File outfile = new File(PACKAGE_DIR + "databases/" + COPY2DATABASE_NAME);

        if (outfile.exists()){
            check = 1;
            outfile.delete();
            outfile = new File(PACKAGE_DIR + "databases/" + COPY2DATABASE_NAME);
        }

        if (outfile.length() <= 0) {
            AssetManager assetManager = ctx.getResources().getAssets();
            try {
                InputStream is = assetManager.open(DATABASE_NAME, AssetManager.ACCESS_BUFFER);
                long filesize = is.available();
                byte [] tempdata = new byte[(int)filesize];
                is.read(tempdata);
                is.close();
                outfile.createNewFile();
                FileOutputStream fo = new FileOutputStream(outfile);
                fo.write(tempdata);
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void updatesuggestion(Context context) {
        if (check == 1) {
            SQLiteDatabase cafedb = openOrCreateDatabase("cafesd1.db", Context.MODE_PRIVATE, null);
            String select = String.format("SELECT * FROM Cafein");
            Cursor cur = cafedb.rawQuery(select, null);
            cur.moveToFirst();

            while (cur.getString(1).equals("EOF") == false) {
                String text = cur.getString(1);
                ContentValues values = new ContentValues();
                values.put("FIELD_SUGGESTION", text);
                cafedb.insert("TABLE_SUGGESTION", null, values);
                Log.d("TABLE INSERT", text);
                while (text.equals(cur.getString(1)))
                    cur.moveToNext();
            }
            select = String.format("SELECT * FROM Cafein");
            cur = cafedb.rawQuery(select, null);
            cur.moveToFirst();
            while (cur.getString(1).equals("EOF") == false) {
                String text = cur.getString(1);
                String text2 = cur.getString(3);
                if (text2 != null) {
                    String select1 = String.format("SELECT * FROM TABLE_SUGGESTION WHERE FIELD_SUGGESTION= '%s'", text2);
                    Cursor cur1 = cafedb.rawQuery(select1, null);
                    cur1.moveToFirst();
                    if (cur1.getCount() == 0) {
                        ContentValues values = new ContentValues();
                        values.put("FIELD_SUGGESTION", text2);
                        Log.d("TABLE INSERT", text2);
                        cafedb.insert("TABLE_SUGGESTION", null, values);
                    }
                }
                cur.moveToNext();
            }
        }
    }
}

            /*
            select = String.format("SELECT * FROM Cafein WHERE Cafe_Name = '%s'", text);
            cur = cafedb.rawQuery(select,null);

            if (cur.getCount() == 0) {
            }*/
/*
            select = String.format("SELECT Drink_Name FROM Cafein");
            cur = cafedb.rawQuery(select,null);
            cur.moveToFirst();
            text = cur.getString(1);
            select = String.format("SELECT * FROM Cafein WHERE Drink_Name = '%s'", text);
            cur = cafedb.rawQuery(select,null);

            if (cur.getCount() == 0) {
                ContentValues values = new ContentValues();
                values.put("suggestion", text);
                cafedb.insert("SUGGESTION_TB", null, values);
            }*
    }
}*/
