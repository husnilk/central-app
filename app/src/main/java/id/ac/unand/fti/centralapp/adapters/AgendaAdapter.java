package id.ac.unand.fti.centralapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.unand.fti.centralapp.R;
import id.ac.unand.fti.centralapp.models.Agenda;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder>{

    ArrayList<Agenda> listAgenda = new ArrayList<>();
    ItemAgendaClickListener listener;

    public AgendaAdapter(ArrayList<Agenda> listAgenda) {
        this.listAgenda = listAgenda;
    }

    public AgendaAdapter(ArrayList<Agenda> listAgenda, ItemAgendaClickListener listener) {
        this.listAgenda = listAgenda;
        this.listener = listener;
    }

    public void setListAgenda(ArrayList<Agenda> listAgenda) {
        this.listAgenda = listAgenda;
    }

    public void setListener(ItemAgendaClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kelas, parent, false);
        return new AgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaViewHolder holder, int position) {
        Agenda agenda = listAgenda.get(position);
        holder.imageAgenda.setImageResource(R.drawable.logo_unand);
        holder.textNamaAgenda.setText(agenda.getNamaAgenda());
        if(agenda.getTipeAgenda() == 1){
            holder.textAgendaType.setText("Kuliah");
        }else{
            holder.textAgendaType.setText("Seminar");
        }
        holder.textWaktu.setText(agenda.getWaktu());
        holder.textTempat.setText(agenda.getTempat());
    }

    @Override
    public int getItemCount() {
        return listAgenda.size();
    }

    public interface ItemAgendaClickListener{
        void onItemAgendaClick(Agenda agenda);
    }

    public class AgendaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageAgenda, imageStatus;
        public TextView textAgendaType, textNamaAgenda, textWaktu, textTempat;

        public AgendaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAgenda = itemView.findViewById(R.id.imageAgenda);
            imageStatus = itemView.findViewById(R.id.imageStatus);
            textAgendaType = itemView.findViewById(R.id.textAgendaType);
            textNamaAgenda = itemView.findViewById(R.id.textNamaAgenda);
            textWaktu = itemView.findViewById(R.id.textWaktu);
            textTempat = itemView.findViewById(R.id.textTempat);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Agenda agenda = listAgenda.get(getAdapterPosition());
            listener.onItemAgendaClick(agenda);
        }
    }
}

