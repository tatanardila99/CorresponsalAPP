package com.semillero.corresponsalapp.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semillero.corresponsalapp.R;

import java.util.List;

public class RecyclerAdminAdapter extends RecyclerView.Adapter<RecyclerAdminAdapter.RecyclerHolderAdmin> {
    private List<ItemInicioAdmin> items;

    public RecyclerAdminAdapter(List<ItemInicioAdmin> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolderAdmin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.list_item_incio_admin,parent,false);
        return new RecyclerHolderAdmin( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderAdmin holder, int position) {
        ItemInicioAdmin item = items.get( position );
        holder.imgItem.setImageResource(item.getItemsOpcion());
        holder.tvOpcion.setText( item.getOpcion());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolderAdmin extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView tvOpcion;

        public RecyclerHolderAdmin(@NonNull View itemView) {
            super( itemView );
            imgItem = itemView.findViewById(R.id.imgOpcion);
            tvOpcion = itemView.findViewById( R.id.txtaccionAdministrador );
        }
    }
}
