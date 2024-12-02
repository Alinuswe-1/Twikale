package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.twikale.R;

import java.util.ArrayList;

import Models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    ArrayList<Post> postArrayList;
    Context context;

    public PostAdapter(ArrayList<Post> postArrayList, Context context) {
        this.postArrayList = postArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postArrayList.get(position);
        holder.favourite.setImageResource(R.drawable.ic_favorite);
        holder.comment.setImageResource(R.drawable.ic_comment);
        holder.more.setImageResource(R.drawable.ic_more);
        holder.share.setImageResource(R.drawable.ic_share);
        holder.location.setText(post.getLocation());
        holder.userName.setText(post.getUserName());
        holder.town.setText(post.getTown());
        holder.price.setText("k"+(int) post.getPrice());

        String imageUrl = post.getImageUrl();

        //glide
        Glide.with(context).load(imageUrl).fitCenter().placeholder(R.drawable.image_24).
                into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ImageButton favourite,comment,share,more;

        TextView location,town,userName,price;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagePost);
            favourite = itemView.findViewById(R.id.imageLike);
            comment = itemView.findViewById(R.id.imageComment);
            share = itemView.findViewById(R.id.imageShare);
            more = itemView.findViewById(R.id.imageMore);
            location = itemView.findViewById(R.id.txtProvince);
            town = itemView.findViewById(R.id.txtCity);
            userName = itemView.findViewById(R.id.txtUser);
            price = itemView.findViewById(R.id.txtPrice);

            favourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You liked post", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
