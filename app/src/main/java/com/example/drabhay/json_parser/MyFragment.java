package com.example.drabhay.json_parser;



        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import com.example.drabhay.json_parser.MainActivity;

        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;


public class MyFragment extends Fragment{

    private static final String TAG ="Testing: " ;
    int mCurrentPage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Getting the arguments to the Bundle object */
        Bundle data = getArguments();

        /** Getting integer data of the key current_page from the bundle */
        mCurrentPage = data.getInt("current_page", 0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.myfragment_layout, container,false);
        TextView tv = (TextView ) v.findViewById(R.id.tv);
        // dp=new DataParsing();
        //MainActivity ma=new MainActivity();
        String data=parse(mCurrentPage);

        tv.setText(""+data);
        return v;
    }
    public String parse(int uid)
    {
        String list="";
        HashMap<Integer, ArrayList<DataBean>> contentMap = new HashMap<Integer, ArrayList<DataBean>>();

        try {
            for (int i = 0; i < MainActivity.jsa.length(); i++) {
                ArrayList<DataBean> contentList = new ArrayList<DataBean>();
                JSONObject jso1 = (JSONObject) MainActivity.jsa.get(i);
                String tempUid = jso1.get("userId") + "";
                int userId = Integer.parseInt(tempUid);
                String tempId = jso1.get("id") + "";
                String title = jso1.get("title") + "";
                String body = jso1.get("body") + "";
                int id = Integer.parseInt(tempId);
                DataBean db = new DataBean(id, title, body);
                if (contentMap.containsKey(userId)) {
                    ArrayList<DataBean> tempList = contentMap.get(userId);
                    tempList.add(db);
                    contentMap.put(userId, tempList);
                } else {
                    ArrayList<DataBean> tempList = new ArrayList<DataBean>();
                    tempList.add(db);
                    contentMap.put(userId, tempList);
                }
            }

            ArrayList<DataBean> tempList = contentMap.get(uid);

            for (DataBean obj1 : tempList) {

                list += obj1.title + "\n";
                list += obj1.body + "\n";
                list += "\n\n";
            }
            Log.i(TAG, list);
        }
        catch (Exception e)
        {
            Log.i(TAG,"Exception in parse body"+e.toString());
            list="Error";
        }

        return list;

    }

}
