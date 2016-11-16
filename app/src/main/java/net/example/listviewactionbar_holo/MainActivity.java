package net.example.listviewactionbar_holo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private static final String[] items = {"En", "un", "lugar", "de", "la",
            "Mancha", "de", "cuyo", "nombre", "no", "quiero", "acordarme",
            "no", "ha", "mucho", "tiempo", "que", "vivía", "un", "hidalgo",
            "de", "los", "de", "lanza", "en", "astillero", "adarga",
            "antigua", "rocín", "flaco", "y", "galgo", "corredor"};

    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //array adapter
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seisItems(items, 6)));


    }

    //para que aparezca la bar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return(super.onCreateOptionsMenu(menu));

    }

    //para las opciones del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.anyadir:
                anyadirItems();
                break;
            case R.id.reset:
                reseteo();
                break;

            case R.id.acercade:
                acercaDe();
                break;
        }

        return true;
    }

    //metodos de las opciones del menú
    public void anyadirItems(){

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seisItems(items, cont ++)));

    }

    public void reseteo(){

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seisItems(items, 6)));
    }

    public void acercaDe(){

        String s = "Aplicación realizada por Estefanía Cabrera Expósito, a día  15 de Noviembre del 2016, hora española: 1:13";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    //se crea el método que llamaremos desde el array adapter y le pasaremos el array de strings y el contador que queramos
    public String[] seisItems(String[] items, int cont){

        //nuevo array de string
        String[] itemsNuevos = new String[cont];

        //recorremos el array hasta la posicion que le pasemos como parámetro
        for(int i= 0; i<cont; i++){

            //igualamos el array que creamos dentro del método con el que le pasamos como parámetro
            itemsNuevos[i] = items[i];
        }

        //devolvemos el array que creamos en el método
        return itemsNuevos;
    }
}
