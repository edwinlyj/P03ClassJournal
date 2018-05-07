package com.example.a16022895.p03_classjournal;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter{
    private ArrayList<DailyGrade> dailyGrades;
    private Context context;
    private TextView week, dg;

    public DGAdapter(Context context, int resource, ArrayList<DailyGrade> objects){
        super(context, resource, objects);
        dailyGrades = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        week = (TextView)rowView.findViewById(R.id.week);
        dg = (TextView) rowView.findViewById(R.id.dg);

        DailyGrade currentDailyGrade = dailyGrades.get(position);

        week.setText("week " + currentDailyGrade.getWeek());
        dg.setText(currentDailyGrade.getGrade());

        return rowView;
    }

}
