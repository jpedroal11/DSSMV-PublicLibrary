package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.dssmv_1211066_1210939.R;
import model.Library;

import java.util.List;

public class ListViewAdapterLibraryBook extends BaseAdapter {

    private Context context;
    private List<Library> items;

    public ListViewAdapterLibraryBook(Context context, List<Library> items) {
        this.context = context;
        this.items = items;
    }

    public String getName(int position) {
        return this.items.get(position).getName();
    }


    public int getCount() {
        return this.items.size();
    }


    public Object getItem(int position) {
        return this.items.get(position);
    }


    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.list_item, null);
        } else {
            itemView = convertView;
        }

        TextView tv = (TextView) itemView.findViewById(R.id.textview_line);

        tv.setText(getName(position));

        return itemView;
    }

}
