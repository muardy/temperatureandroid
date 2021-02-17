package com.testtest.testtest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class RecyclerView_Config {
    private Context mContext;
    private sensadapter msensadapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Sens> sens, List<String> keys){

        mContext= context;
        msensadapter = new sensadapter(sens, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(msensadapter);
    }

    class sensitemview extends RecyclerView.ViewHolder{

           private TextView msens;

           private String key;



           public sensitemview(ViewGroup parent)
           {
               super(LayoutInflater.from(mContext).inflate(R.layout.sens_list_item, parent,false  ));

                  msens = (TextView) itemView.findViewById(R.id.txt_sens);


           }

           public void bind (Sens sen, String key){

               msens.setText(sen.gettest());
               this.key = key;

           }


    }
    class sensadapter extends RecyclerView.Adapter<sensitemview>
    {

        private List<Sens> msenslist;
        private List<String> mKeys;

        public sensadapter(List<Sens> msenslist, List<String>mkeys)
        {
            this.msenslist = msenslist;
            this.mKeys = mkeys;

        }

      //  public sensadapter() {
          //  super();
        //}

        @NonNull
        @Override
        public sensitemview onCreateViewHolder( ViewGroup parent, int viewType) {
            return new sensitemview(parent);
        }

        @Override
        public void onBindViewHolder(sensitemview holder, int position) {
          holder.bind(msenslist.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return msenslist.size();
        }
    }
}
