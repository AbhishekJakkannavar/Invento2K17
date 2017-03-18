package infinityinc.com.invento2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class details extends AppCompatActivity {


    TabHost tabs;
    ListView Technical;
    ListView nonTechnical;
    ListView Cultural;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tabs = (TabHost)findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec1=tabs.newTabSpec("TECHNICAL");
        spec1.setIndicator("TECHNICAL");
        spec1.setContent(R.id.layout1);

        TabHost.TabSpec spec2=tabs.newTabSpec("NON TECHNICAL");
        spec2.setIndicator("NON TECHNICAL");
        spec2.setContent(R.id.layout2);

        TabHost.TabSpec spec3=tabs.newTabSpec("CULTURAL");
        spec3.setIndicator("CULTURAL");
        spec3.setContent(R.id.layout3);


        tabs.addTab(spec1);
        tabs.addTab(spec2);
        tabs.addTab(spec3);


        //CODE TO FIND TECHNICAL TAB AND INSERT TECHNICAL EVENTS AND THEIR INTENTS
        Technical = (ListView)findViewById(R.id.TechListView);
        final String[] dataTechnical = new String[]{
        "QUIZ","MOCK INTERVIEW","ROBOT","OPERATING SYSTEM","LINUX"
        };

        ArrayAdapter<String> listAdapter;
        listAdapter = new ArrayAdapter<String>(details.this,android.R.layout.simple_list_item_1,dataTechnical);
        Technical.setAdapter(listAdapter);


Technical.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            Intent sendToDanceActivity = new Intent(details.this,dance_Activity.class);
            startActivity(sendToDanceActivity);
        }

        if (position==1){
            Toast.makeText(details.this,dataTechnical[1].toString(),Toast.LENGTH_LONG).show();
        }

    }
});



        //CODE TO FIND NONTECHNICAL TAB AND INSERT NONTECHNICAL EVENTS AND THEIR INTENTS
        nonTechnical = (ListView)findViewById(R.id.nonTechListView);
        final String[] dataNonTechnical = new String[]{
                "DANCE","RANGOLI","TREASURE HUNT","BOX CRICKET","PAINTING"
        };

        ArrayAdapter<String> nonTechlistAdapter;
        nonTechlistAdapter = new ArrayAdapter<String>(details.this,android.R.layout.simple_list_item_1,dataNonTechnical);
        nonTechnical.setAdapter(nonTechlistAdapter);


        nonTechnical.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent sendToDanceActivity = new Intent(details.this,dance_Activity.class);
                    startActivity(sendToDanceActivity);
                }



            }
        });


        //CODE TO FIND NONTECHNICAL TAB AND INSERT NONTECHNICAL EVENTS AND THEIR INTENTS
        Cultural = (ListView)findViewById(R.id.culturalListView);
        final String[] dataCultural = new String[]{
                "DANCE","SOLO SONG","MIMICRY","MUSIC","DJ"
        };

        ArrayAdapter<String> culturallistAdapter;
        culturallistAdapter = new ArrayAdapter<String>(details.this,android.R.layout.simple_list_item_1,dataCultural);
        Cultural.setAdapter(culturallistAdapter);


        Cultural.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent sendToDanceActivity = new Intent(details.this,dance_Activity.class);
                    startActivity(sendToDanceActivity);
                }



            }
        });




    }
}
