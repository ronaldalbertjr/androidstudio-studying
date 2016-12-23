package com.albert.ronald.exlistviewspinner;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class ActMain extends AppCompatActivity implements View.OnClickListener
{
    private EditText edtValor;
    private Spinner spnOpcoes;
    private Button btnAdicionar;
    private Button btnExcluir;
    private ListView lstDados;


    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpDados;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        edtValor = (EditText) findViewById(R.id.edtValor);
        spnOpcoes = (Spinner) findViewById(R.id.spnOpcoes);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        lstDados = (ListView) findViewById(R.id.lstDados);

        btnAdicionar.setOnClickListener(this);
        btnExcluir.setOnClickListener(this);

        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpcoes.setAdapter(adpOpcoes);
        adpOpcoes.add("Albert");
        adpOpcoes.add("Marques");
        adpOpcoes.add("Silva");
        adpOpcoes.add("Otario");

        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);
    }


    @Override
    public void onClick(View view)
    {
        String item ;
        if (view == btnAdicionar)
        {
            item = edtValor.getText().toString();
            item += " " + spnOpcoes.getSelectedItem();
            adpDados.add(item);
        }
        else if (view == btnExcluir && adpDados.getCount() > 0)
        {
            item = adpDados.getItem(0);
            adpDados.remove(item);
        }
    }
}
