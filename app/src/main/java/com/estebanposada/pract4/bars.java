package com.estebanposada.pract4;

import android.content.Context;
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

public class bars extends AppCompatActivity {

    ArrayAdapter<String> adaptador3;
    ListView lstbar;
    int selb;

    private Lista_bars[] datosb =
            new Lista_bars[]{
                    new Lista_bars(R.drawable.bciudad_deli, "Delirio bar", "Visit us"),
                    new Lista_bars(R.drawable.bfonda_la_matraca, "Fonda la Matraca", "Visit us"),
                    new Lista_bars(R.drawable.bkukaramakara, "Kukaramakara", "Visit us"),
                    new Lista_bars(R.drawable.bzape, "Zaperoco", "Visit us")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);

        Adapter3 adaptador3 = new Adapter3(this, datosb);
        lstbar = (ListView) findViewById(R.id.lstb);
        lstbar.setAdapter(adaptador3);

        lstbar.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selb = (int)parent.getItemIdAtPosition(position);
                switch (selb){
                    case 0:
                        Toast.makeText(bars.this, "Delirio bar", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(bars.this, "Fonda la Matrac", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(bars.this, "Kukaramakara", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(bars.this, "Zaperoco", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public class Adapter3 extends ArrayAdapter {
        public Adapter3(Context context, Lista_bars[] datosb) {
            super(context, R.layout.layout_bar_list, datosb);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater3 = LayoutInflater.from(getContext());
            View item3 = inflater3.inflate(R.layout.layout_bar_list, null);


            TextView bares = (TextView) item3.findViewById(R.id.tbar);
            bares.setText(datosb[position].getBar());

            TextView info3 = (TextView) item3.findViewById(R.id.tInfo3);
            info3.setText(datosb[position].getInfo3());

            ImageView  imagenb = (ImageView) item3.findViewById(R.id.imageb);
            imagenb.setImageResource(datosb[position].getIdimage());

            return item3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bars, menu);
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
