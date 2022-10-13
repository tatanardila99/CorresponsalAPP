package com.semillero.corresponsalapp.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.semillero.corresponsalapp.MVP.Interfaces.Callback;
import com.semillero.corresponsalapp.Views.ItemInicioAdmin;
import com.semillero.corresponsalapp.R;

import java.util.List;

public class RecyclerAdminAdapter extends RecyclerView.Adapter<RecyclerAdminAdapter.RecyclerHolderAdmin> {

    private final List<ItemInicioAdmin> items;
    //private final List<ItemInicioAdmin> itemsCorresponsal;
     Context context;
     Callback listenerCallback;


    public RecyclerAdminAdapter(List<ItemInicioAdmin> items, Context context, Callback listenerCallback) {
        this.items = items;
        this.context= context;
        this.listenerCallback = listenerCallback;

    }


    @NonNull
    @Override
    public RecyclerHolderAdmin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.list_item_incio_admin,parent,false);
        return new RecyclerHolderAdmin( view );

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderAdmin holder, int position) {
        ItemInicioAdmin item = items.get(position);
        //ItemInicioAdmin itemsCorresponsal = items.get(position);
        holder.imgItem.setImageResource(item.getItemsOpcion());
       //holder.imgItem.setImageResource(itemsCorresponsal.getItemsOpcion());
        holder.tvOpcion.setText( item.getOpcion());
       // holder.tvOpcion.setText( itemsCorresponsal.getOpcion());
        holder.listLayout.setOnClickListener(view -> listenerCallback.setListener(item));
        //holder.listLayout.setOnClickListener(view -> listenerCallback.setListenerCorresponsal(item));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class RecyclerHolderAdmin extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView tvOpcion;
        private ConstraintLayout listLayout;

        public RecyclerHolderAdmin(@NonNull View itemView) {
            super( itemView );
            imgItem = itemView.findViewById(R.id.imgOpcion);
            tvOpcion = itemView.findViewById( R.id.txtaccionAdministrador );
            listLayout = itemView.findViewById( R.id.listLayout);

        }
    }


}
