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


public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adaptador;
    ListView lstmenu;
    int sel;

    private Lista_menu[] datos =
            new Lista_menu[]{
                    new Lista_menu(R.drawable.publi, "Advertising", "Come to Cali"),
                    new Lista_menu(R.drawable.hotel, "Hotels", "Stay at Cali"),
                    new Lista_menu(R.drawable.bares, "Bars", "Enjoy Cali"),
                    new Lista_menu(R.drawable.turi, "Turistic Sites", "Visit Cali"),
                    new Lista_menu(R.drawable.demo, "Demographic", "Cali information"),
                    new Lista_menu(R.drawable.acerca, "About...", "About the city")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Adapter adaptador = new Adapter(this, datos);

        lstmenu = (ListView) findViewById(R.id.lst);
        lstmenu.setAdapter(adaptador);


        lstmenu.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, String.valueOf(parent.getItemIdAtPosition(position)), Toast.LENGTH_LONG).show();
                sel = (int)parent.getItemIdAtPosition(position);
                //seli=(int)sel;
                switch (sel) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Adversting Selected", Toast.LENGTH_SHORT).show();
                        //Intent i = new Intent(this, Publicidad.class);
                        startActivity(new Intent(getApplicationContext(), Publicidad.class));
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Hotels Selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), list_hotels.class));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Bars Selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), bars.class));
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Turistic Selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), turistic.class));
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "Demographic Selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Demografia.class));
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "About Selected", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), About.class));
                        break;
                }
            }
        });
    }

    public class Adapter extends ArrayAdapter {
        public Adapter(Context context, Lista_menu[] datos) {
            super(context, R.layout.layout_item_list, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item_list,null);

            TextView menu = (TextView) item.findViewById(R.id.tItem);
            menu.setText(datos[position].getMenu());

            TextView info = (TextView) item.findViewById(R.id.tInfo);
            info.setText(datos[position].getInfo());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdimage());

            return item;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
