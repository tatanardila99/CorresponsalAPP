package com.semillero.corresponsalapp.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.semillero.corresponsalapp.ConsultarClienteAdmin;
import com.semillero.corresponsalapp.ConsultarCorresponsalAdmin;
import com.semillero.corresponsalapp.CrearClienteAdmin;
import com.semillero.corresponsalapp.ListadoClientesAdmin;
import com.semillero.corresponsalapp.LoginMain;
import com.semillero.corresponsalapp.R;
import com.semillero.corresponsalapp.RegistrarCorresponalAdmin;

import java.io.Serializable;
import java.util.List;

public class RecyclerAdminAdapter extends RecyclerView.Adapter<RecyclerAdminAdapter.RecyclerHolderAdmin>{


    private final List<ItemInicioAdmin> items;
     Context context;

    public RecyclerAdminAdapter(List<ItemInicioAdmin> items, Context context) {
        this.items = items;
        this.context= context;
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
        holder.imgItem.setImageResource(item.getItemsOpcion());
        holder.tvOpcion.setText( item.getOpcion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class RecyclerHolderAdmin extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView tvOpcion;

        public RecyclerHolderAdmin(@NonNull View itemView) {
            super( itemView );
            imgItem = itemView.findViewById(R.id.imgOpcion);
            tvOpcion = itemView.findViewById( R.id.txtaccionAdministrador );


                    itemView.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (items.get(getAdapterPosition()).getOpcion()){
                                case "crear cliente":
                                        Intent intent = new Intent(context, CrearClienteAdmin.class );
                                        context.startActivity(intent);
                                        break;

                                case "Registrar corresponsal":
                                        Intent intent2 = new Intent(context, RegistrarCorresponalAdmin.class );
                                        context.startActivity(intent2);
                                        break;

                                case "Consultar cliente":
                                        Intent intent3 = new Intent(context, ConsultarClienteAdmin.class );
                                        context.startActivity(intent3);
                                        break;

                                case "Consultar corresponsal":
                                        Intent intent4 = new Intent(context, ConsultarCorresponsalAdmin.class );
                                        context.startActivity(intent4);
                                        break;

                                case "Listado clientes":
                                        Intent intent5 = new Intent(context, ListadoClientesAdmin.class );
                                        context.startActivity(intent5);
                                        break;

                                case "Listado corresponsales":
                                        Intent intent6 = new Intent(context, ListadoClientesAdmin.class );
                                        context.startActivity(intent6);
                                        break;
                            }
                        }
                    } );

        }
    }


}
