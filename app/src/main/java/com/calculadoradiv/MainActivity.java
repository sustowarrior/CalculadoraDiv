package com.calculadoradiv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText edtDiv;
    private EditText edtVlr;
    private List<ItemRel> lista;
    private ListView listView;
    private MyAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();

        btn = findViewById(R.id.button);
        edtDiv = findViewById(R.id.edtDiv);
        edtVlr = findViewById(R.id.edtValor);

        arrayAdapter = new MyAdapter(lista, this);
        listView = findViewById(R.id.listViewItem);
        listView.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validaCampos()) {
                    if(!lista.isEmpty())
                        lista.clear();
                    BigDecimal div = new BigDecimal(edtDiv.getText().toString());
                    BigDecimal valorAcao = new BigDecimal(edtVlr.getText().toString());
                    lista.add(criaItemRet(div, valorAcao, valorAcao));
                    lista.add(criaItemRet(div, valorAcao, new BigDecimal(100)));
                    lista.add(criaItemRet(div, valorAcao, new BigDecimal(200)));
                    lista.add(criaItemRet(div, valorAcao, new BigDecimal(500)));
                    lista.add(criaItemRet(div, valorAcao, new BigDecimal(1000)));
                    lista.add(criaItemRet(div, valorAcao, new BigDecimal(5000)));
                    lista.add(criaItemRet(div, valorAcao, new BigDecimal(10000)));

                    InputMethodManager imm = (InputMethodManager) getSystemService(v.getContext().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    arrayAdapter.notifyDataSetChanged();
                }

            }
        });

    }

    private ItemRel criaItemRet(BigDecimal div, BigDecimal valorAcao, BigDecimal i) {
        ItemRel item = new ItemRel();
        BigDecimal total = BigDecimal.ZERO;
        total = valorAcao.multiply(i).divide(div, MathContext.DECIMAL32);
        item = new ItemRel();
        item.setValorTotal(total);
        item.setValorDiv(i);
        item.setQtdCotas(total.divide(valorAcao, MathContext.DECIMAL32));
        item.setQtdCotas(item.getQtdCotas().setScale(0, RoundingMode.UP));
        return item;
    }

    private Boolean validaCampos() {

        if (edtDiv.getText() == null || edtDiv.getText().toString().isEmpty()) {
            Toast.makeText(this, "Informe os valores corretamente!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtVlr.getText() == null || edtVlr.getText().toString().isEmpty()) {
            Toast.makeText(this, "Informe os valores corretamente!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}