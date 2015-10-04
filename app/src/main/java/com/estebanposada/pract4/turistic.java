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

public class turistic extends AppCompatActivity {

    ArrayAdapter<String> adaptador4;
    ListView lstturistic;
    int seltu;

    private Lista_turistic[] datostu =
            new Lista_turistic[]{
                    new Lista_turistic(R.drawable.tucali_zoo, "Cali Zoo", "Visit us"),
                    new Lista_turistic(R.drawable.tucana_azucar, "Caña de azucar museum", "Visit us"),
                    new Lista_turistic(R.drawable.tucristorey, "Cristo Rey", "Visit us"),
                    new Lista_turistic(R.drawable.tuferia_cali, "Feria de Cali", "Visit us")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turistic);

        Adapter4 adaptador4 = new Adapter4(this, datostu);
        lstturistic = (ListView)findViewById(R.id.lsttu);
        lstturistic.setAdapter(adaptador4);

        lstturistic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seltu = (int)parent.getItemIdAtPosition(position);
                switch (seltu){
                    case 0:
                        Toast.makeText(turistic.this, "Cali Zoo", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(turistic.this, "Caña de azucar museum", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(turistic.this, "Cristo Rey", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(turistic.this, "Zaproco", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(turistic.this, "Feria de Cali", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public class Adapter4 extends ArrayAdapter {
        public Adapter4(Context context, Lista_turistic[] datostu){
            super(context, R.layout.layout_turistic_list, datostu);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater4 = LayoutInflater.from(getContext());
            View item4 = inflater4.inflate(R.layout.layout_turistic_list, null);

            TextView sitetu = (TextView) item4.findViewById(R.id.tturi);
            sitetu.setText(datostu[position].getTuri());

            TextView info = (TextView) item4.findViewById(R.id.tInfo4);
            info.setText(datostu[position].getInfo4());

            ImageView imagentu = (ImageView) item4.findViewById(R.id.imagetu);
            imagentu.setImageResource(datostu[position].getIdimagen());

            return item4;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_turistic, menu);
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
