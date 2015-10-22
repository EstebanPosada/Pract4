package com.estebanposada.pract4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class list_hotels extends AppCompatActivity {

    ArrayAdapter<String> adaptador2;
    ListView lsthotel;
    int selh;

    private   Lista_hotel[] datosh =
            new Lista_hotel[]{
                    new Lista_hotel(R.drawable.hcasa_de_alferez1, "Casa de Alferez", "Visit us"),
                    new Lista_hotel(R.drawable.hdan_carltoned, "Dan Carlton", "Visit us"),
                    new Lista_hotel(R.drawable.hinterlogo, "Internacional", "Visit us")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotels);

        String[] nombre =getResources().getStringArray(R.array.Mhotel);
       // String[] info =getResources().getStringArray(R.array.Minfo);
        datosh[0].setHotel(nombre[0]);    //datos[0].setInfo(info[0]);
        datosh[1].setHotel(nombre[1]);    //datos[1].setInfo(info[1]);
        datosh[2].setHotel(nombre[2]);   // datos[2].setInfo(info[2]);


        Adapter2 adaptador2 = new Adapter2(this, datosh);
        lsthotel = (ListView) findViewById(R.id.lsth);
        lsthotel.setAdapter(adaptador2);

        lsthotel.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, String.valueOf(parent.getItemIdAtPosition(position)), Toast.LENGTH_LONG).show();
                selh = (int)parent.getItemIdAtPosition(position);
                switch (selh) {
                    case 0:
                        Toast.makeText(list_hotels.this, "Casa de Alferez", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), hotel1.class));
                        break;
                    case 1:
                        Toast.makeText(list_hotels.this, "Dan Carlton", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), hotel2.class));
                        break;
                    case 2:
                        Toast.makeText(list_hotels.this, "Internacional", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), hotel3.class));
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_hotels, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class Adapter2 extends ArrayAdapter {
        public Adapter2(Context context, Lista_hotel[] datosh) {
            super(context, R.layout.layout_hotel_list, datosh);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater2 = LayoutInflater.from(getContext());
            View item2 = inflater2.inflate(R.layout.layout_hotel_list, null);

            TextView hotel = (TextView) item2.findViewById(R.id.tHotel);
            hotel.setText(datosh[position].getHotel());

            TextView info2 = (TextView) item2.findViewById(R.id.tInfo2);
            info2.setText(datosh[position].getInfo2());

            ImageView imagen = (ImageView) item2.findViewById(R.id.imagen);
            imagen.setImageResource(datosh[position].getIdimage());


            return item2;
        }
    }
}
