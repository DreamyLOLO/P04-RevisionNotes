package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	ArrayList<Note> notes;
	int resource;
	TextView tvcontent;
	TextView tvid;
	ImageView iv1, iv2, iv3, iv4, iv5;

	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.row, parent, false);
		tvcontent = (TextView)rowView.findViewById(R.id.textViewNote);
		tvid = (TextView)rowView.findViewById(R.id.tvid);
		iv1 = rowView.findViewById(R.id.imageView1star);
		iv2 = rowView.findViewById(R.id.imageView2star);
		iv3 = rowView.findViewById(R.id.imageView3star);
		iv4 = rowView.findViewById(R.id.imageView4star);
		iv5 = rowView.findViewById(R.id.imageView5star);

		//Match the UI components with Java variables

		Note note = notes.get(position);

		//Check if the property for starts >= 5, if so, "light" up the stars
		if (note.getStars() == 5) {
			iv5.setImageResource(android.R.drawable.btn_star_big_on);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (note.getStars() == 4) {
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (note.getStars() == 3) {
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (note.getStars() == 2) {
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (note.getStars() == 1) {
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}

		tvcontent.setText(note.getNoteContent());
		tvid.setText("Revision Note #"+note.getId());

		return rowView;
	}



}
