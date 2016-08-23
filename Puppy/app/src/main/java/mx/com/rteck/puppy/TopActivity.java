package mx.com.rteck.puppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class TopActivity extends AppCompatActivity {
    ArrayList<Perro> perros;
    private RecyclerView listaPerros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        Toolbar miAccionBar = (Toolbar) findViewById(R.id.miAccionBar);
        setSupportActionBar(miAccionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaPerros =   (RecyclerView)  findViewById(R.id.rvPerros);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayout.VERTICAL);
        listaPerros.setLayoutManager(llm);
        inicializarPerros();
        inicializarAdaptador();

    }

    public void inicializarPerros()
    {
        perros =    new ArrayList<Perro>();
        perros.add(new Perro("Lobo",3,R.drawable.perro1));
        perros.add(new Perro("Charlie",4,R.drawable.perro2));
        perros.add(new Perro("Puppy",5,R.drawable.perro3));
        perros.add(new Perro("Cookie",2,R.drawable.perro4));
        perros.add(new Perro("Woody",3,R.drawable.perro5));
    }

    public void inicializarAdaptador()
    {
        PerroAdaptador adaptador = new PerroAdaptador(perros,this);
        listaPerros.setAdapter(adaptador);
    }
}
