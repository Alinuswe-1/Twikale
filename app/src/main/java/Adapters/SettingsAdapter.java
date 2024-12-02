package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twikale.R;
import com.example.twikale.Views.HostActivity;
import com.example.twikale.Views.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import Models.SettingModel;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    ArrayList<SettingModel> settingModels;
    Context context;

    public SettingsAdapter(ArrayList<SettingModel> settingModels, Context context) {
        this.settingModels = settingModels;
        this.context = context;
    }

    @NonNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_item,parent,false);
        return new SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsViewHolder holder, int position) {
        SettingModel settingModel = settingModels.get(position);
        holder.title.setText(settingModel.getTitle());
        holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_arrow_right));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(settingModel.getTitle() == "log out"){
                    Toast.makeText(context,"Signed Out, please sign back in!",Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }
                //else handle other settings
            }
        });

    }

    @Override
    public int getItemCount() {
        return settingModels.size();
    }


    class SettingsViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;

        CardView cardView;

        public SettingsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.settingText);
            image = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.settingLayout2);

        }
    }
}
