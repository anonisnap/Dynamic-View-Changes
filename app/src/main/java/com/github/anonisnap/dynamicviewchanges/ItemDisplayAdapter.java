package com.github.anonisnap.dynamicviewchanges;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemDisplayAdapter extends RecyclerView.Adapter<ItemDisplayAdapter.ViewHolder> {
	private List<ItemDisplay> celebrities;
	private OnClickListener listener;

	public ItemDisplayAdapter(List<ItemDisplay> celebrities) {
		this.celebrities = celebrities;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inf = LayoutInflater.from(parent.getContext());
		View view = inf.inflate(R.layout.item_display_list, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.name.setText(celebrities.get(position).getName());
		holder.desc.setText(celebrities.get(position).getDescription());
		holder.img.setImageResource(celebrities.get(position).getImage());
		holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
		int c = getBackgroundColour(celebrities.get(position));
		holder.cardBackground.setBackgroundColor(c);
	}

	private int getBackgroundColour(ItemDisplay celebrity) {
		switch (celebrity.getGender()) {
			case 'm':
				return Color.argb(80,  33, 150, 243);
			case 'f':
				return Color.argb(80, 233, 30, 99);
			default:
				return Color.argb(80, 139, 195, 74);
		}
	}

	@Override
	public int getItemCount() {
		return celebrities.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private final LinearLayout cardBackground;
		private final TextView name, desc;
		private final ImageView img;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			name = itemView.findViewById(R.id.celeb_name);
			desc = itemView.findViewById(R.id.celeb_desc);
			img = itemView.findViewById(R.id.celeb_img);
			cardBackground = itemView.findViewById(R.id.card_background);

			itemView.setOnClickListener(view -> listener.onClick(celebrities.get(getBindingAdapterPosition())));
		}
	}

	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	public interface OnClickListener {
		void onClick(ItemDisplay itemDisplay);
	}
}
