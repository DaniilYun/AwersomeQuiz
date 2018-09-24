package com.taksebetudasuda.jopa.awersomequiz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniil on 09.08.2018.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Category> categoryList = new ArrayList<>();
    private LayoutInflater inflater;
    private ItemCliclListener itemCliclListener;
    Context context;

    public void setItemCliclListener(ItemCliclListener itemCliclListener) {
        this.itemCliclListener = itemCliclListener;
    }

    public MyAdapter(Context context, ArrayList<Category> list){
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        categoryList = list;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  inflater.inflate(R.layout.category_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String category = categoryList.get(position).getCategoty();
        holder.textView.setText(category);
        holder.resultText.setText(categoryList.get(position).getResultForView());
        holder.imageView.setImageResource(context.getResources().
                getIdentifier(categoryList.get(position).getImageName(),"drawable",context.getPackageName()));

    }

    @Override
    public int getItemCount() {
        return (null!=categoryList? categoryList.size():0);
    }

    public Category getItem(int id){
        return categoryList.get(id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public TextView resultText;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.category_image);
            textView = itemView.findViewById(R.id.category_name);
            resultText = itemView.findViewById(R.id.text_view_result);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemCliclListener!=null){
                itemCliclListener.onClick(v,getAdapterPosition());
            }
        }

    }
}
