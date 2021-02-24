package com.calculadoradiv;

import android.app.Activity;
import android.content.ClipData;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private final List<ItemRel> lista;
    private final Activity act;

    public MyAdapter(List<ItemRel> lista, Activity act) {
        this.act = act;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.mylist, parent, false);
        ItemRel item = lista.get(position);

        //pegando as referências das Views
        TextView vlrTot = (TextView) view.findViewById(R.id.tvVlrTotal);
        TextView qtdCot = (TextView) view.findViewById(R.id.tvQtdCotas);
        TextView div = (TextView) view.findViewById(R.id.tvDiv);

        //populando as Views
        vlrTot.setText("Valor Total Investido: " + FuncoesConversao.bdParaMoeda(item.getValorTotal()));
        qtdCot.setText("Quantidade de Cotas: " + FuncoesConversao.bdparaQuantidade(item.getQtdCotas()));
        div.setText("Dividendos: " + FuncoesConversao.bdParaMoeda(item.getValorDiv()));

        return view;

    }
}
