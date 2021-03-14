package alexbatista.br.edu.fateclins.crudsqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsuarioCustomAdapter extends RecyclerView.Adapter<UsuarioCustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList user_id, user_login, user_name, user_password;

    UsuarioCustomAdapter(Activity activity, Context context, ArrayList user_id, ArrayList user_name, ArrayList user_login, ArrayList user_password){
        this.activity = activity;
        this.context = context;
        this.user_id = user_id;
        this.user_login = user_login;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.usuario_my_row, parent, false);
        return new MyViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.txtid.setText(String.valueOf(user_id.get(position)));
        holder.txtnome.setText(String.valueOf(user_name.get(position)));
        holder.txtlogin.setText(String.valueOf(user_login.get(position)));
        holder.txtsenha.setText(String.valueOf(user_password.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout_2.setOnClickListener(new View.OnClickListener() {


            //MEXENDO//
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UsuarioUpdateActivty.class);
                intent.putExtra("user_id", String.valueOf(user_id.get(position)));
                intent.putExtra("user_name", String.valueOf(user_name.get(position)));
                intent.putExtra("user_login", String.valueOf(user_login.get(position)));
                intent.putExtra("user_password", String.valueOf(user_password.get(position)));
                activity.startActivityForResult(intent, 1);
            }
            // FIM MEXENDO//
        });
    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtid, txtnome, txtlogin, txtsenha;
        LinearLayout mainLayout_2;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.txtid);
            txtnome = itemView.findViewById(R.id.txtnome);
            txtsenha = itemView.findViewById(R.id.txtsenha);
            txtlogin = itemView.findViewById(R.id.txtlogin);
            mainLayout_2 = itemView.findViewById(R.id.mainLayout_2);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout_2.setAnimation(translate_anim);
        }
    }
}
