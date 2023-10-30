package adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.dssmv_1211066_1210939.R;
import model.Book;


public class ListViewAdapterBook extends BaseAdapter{

        private Context context;
        private List<Book> items;

        public ListViewAdapterBook(Context context, List<Book> bookList) {
            this.context = context;
            this.items = bookList;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public String getTitle(int position) {
            return items.get(position).getTitle();
        }

        public String getAuthorName(int position) {
            return items.get(position).getAuthor().getName(); // Assuming Author has a getName() method.
        }

        public String getDescription(int position) {
            return items.get(position).getDescription();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                itemView = inflater.inflate(R.layout.book_list_item, null); // Assuming you have a layout file named book_list_item.xml.
            } else {
                itemView = convertView;
            }

            ImageView bookIcon = itemView.findViewById(R.id.book_icon);
            TextView titleTextView = itemView.findViewById(R.id.title_text_view);
            TextView authorTextView = itemView.findViewById(R.id.author_text_view);
            TextView descriptionTextView = itemView.findViewById(R.id.description_text_view);

            // Set the values in the views
            Book book = items.get(position);
            bookIcon.setImageBitmap(book.getIcon());
            titleTextView.setText(book.getTitle());
            authorTextView.setText(getAuthorName(position));
            descriptionTextView.setText(getDescription(position));

            return itemView;
        }

}
