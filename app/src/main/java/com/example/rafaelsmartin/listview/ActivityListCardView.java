package com.example.rafaelsmartin.listview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Rafael S Martin on 25/07/2017.
 */

public class ActivityListCardView extends AppCompatActivity {

    private ListView lstOpciones;


    private ItemLista[] datos =
            new ItemLista[]{
                    new ItemLista("Título caca",R.mipmap.ic_launcher),
                    new ItemLista("Título 2", R.mipmap.ic_launcher),
                    new ItemLista("Título 3", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 4", R.mipmap.ic_launcher),
                    new ItemLista("Título 15", R.mipmap.ic_launcher)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card_view);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);




        //Cabecera
       /* View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpciones.addHeaderView(header);*/

        //Instancio adaptador del tipo Miadaptador y lo setteo
        ActivityListCardView.MiAdaptador adaptador = new ActivityListCardView.MiAdaptador(this, datos);
        lstOpciones.setAdapter(adaptador);



        //Native AdView


        //Pongo a escuchar los items de la lista
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Capturo los string de cada item y los comparo para hacer luego cosas
                String aux=((ItemLista)a.getItemAtPosition(position)).getTitulo();

                if(aux == "Título caca"){
                    gotoweb();
                } else{
                    Toast.makeText(getApplicationContext(),aux, Toast.LENGTH_SHORT).show();
                }



                //Alternativa 1:
                // if(((ItemLista)a.getItemAtPosition(position)).getTitulo()==null){
                //    gotoweb();
                // }else{
                //     String opcionSeleccionada =
                //             ((ItemLista)a.getItemAtPosition(position)).getTitulo();
                //     lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
                // }
                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();


            }
        });
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

    //Creacion del Adaptador personalizado
    class MiAdaptador extends ArrayAdapter<ItemLista> {

        public MiAdaptador(Context context, ItemLista[] datos) {
            super(context, R.layout.item_list_card_view, datos);
        }
        //Creo la vista cargando los elementos del layout
        public View getView(int position, View convertView, ViewGroup parent) {
            //Forma que consume recursos
            /*LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_list, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            ImageView lblImagen = (ImageView) item.findViewById(R.id.LblImagen);
            lblImagen.setImageResource(datos[position].getImagen());

            return(item);*/

            //Forma mas rapida y menos recursos consume pero aun findView consume mas
            /*View item = convertView;
            if(item == null)
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.item_list, null);
            }

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            ImageView lblImagen = (ImageView) item.findViewById(R.id.LblImagen);
            lblImagen.setImageResource(datos[position].getImagen());

            return(item);*/

            //La mejor forma de hacerlo con ViewHolder incluido
            View item = convertView;
            ActivityList.ViewHolder holder;

            if(item == null)
            {
                //Inflamos el layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.item_list_card_view, null);

                //Creamos nuestro holder y guardamos los elementos
                holder = new ActivityList.ViewHolder();
                holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
                holder.imagen = (ImageView) item.findViewById(R.id.LblImagen);
                //Guardamos los elementos
                item.setTag(holder);
            }
            else
            {
                //Recuperamos los elementos
                holder = (ActivityList.ViewHolder)item.getTag();
            }
            //Metemos el contenido en los elementos
            holder.titulo.setText(datos[position].getTitulo());
            holder.imagen.setImageResource(datos[position].getImagen());

            return(item);
        }
    }

    public void gotoweb(){
        Uri uri = Uri.parse("http://www.google.es/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    //Creacion de la clase ViewHolder para guardar datos de ListView
    static class ViewHolder{
        TextView titulo;
        ImageView imagen;
    }

}