package com.example.asm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class motoAdapter extends BaseAdapter {
    private ArrayList<MotoModel> list;
    private Context context;
    public motoAdapter(ArrayList<MotoModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.item_fitness,viewGroup ,false);
        TextView txtname = view1.findViewById(R.id.txtname);
        TextView txtnam = view1.findViewById(R.id.txtyear);
        TextView txthang = view1.findViewById(R.id.txtbranch);
        TextView txtgia = view1.findViewById(R.id.txtprice);
        ImageView img = view1.findViewById(R.id.img);
        txtname.setText(list.get(i).getTen());
        txtnam.setText(list.get(i).getNamSx());
        txthang.setText(list.get(i).getHangsx());
        txtgia.setText(list.get(i).getGia());
        img.setImageResource(R.drawable.img_7);
        return view1;
    }
}
