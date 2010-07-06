package com.evancharlton.mileage.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.evancharlton.mileage.provider.tables.FillupsTable;

public class CsvFieldAdapter implements SpinnerAdapter {
	private final LayoutInflater mInflater;

	public CsvFieldAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
		}

		Holder holder = (Holder) convertView.getTag();
		if (holder == null) {
			holder = new Holder((TextView) convertView.findViewById(android.R.id.text1));
			convertView.setTag(holder);
		}
		holder.text.setText(getText(position));

		return convertView;
	}

	@Override
	public int getCount() {
		return FillupsTable.PROJECTION.length;
	}

	@Override
	public Object getItem(int position) {
		return FillupsTable.PROJECTION[position];
	}

	@Override
	public long getItemId(int position) {
		return FillupsTable.PROJECTION[position].hashCode();
	}

	private int getText(int position) {
		return FillupsTable.PLAINTEXT[position];
	}

	@Override
	public int getItemViewType(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(android.R.layout.simple_spinner_item, parent, false);
		}

		TextView tv = (TextView) convertView.getTag();
		if (tv == null) {
			tv = (TextView) convertView.findViewById(android.R.id.text1);
			convertView.setTag(tv);
		}
		tv.setText(getText(position));

		return convertView;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	private static class Holder {
		public final TextView text;

		public Holder(TextView text) {
			this.text = text;
		}
	}
}