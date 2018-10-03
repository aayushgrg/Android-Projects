package com.example.neelansh.busfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "a";
    ArrayList<String> nameLowFloor = new ArrayList<>();
    ArrayList<String> nameminibus = new ArrayList<>();
    ArrayList<ArrayList<String>> bus_lowfloor = new ArrayList<>();
    ArrayList<ArrayList<String>> bus_MIni = new ArrayList<>();
    AutoCompleteTextView sourcet, dest;
    Button searcht;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sourcet = findViewById(R.id.sourcet);
        dest = findViewById(R.id.dest);
        searcht = findViewById(R.id.search);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getStops());
        sourcet.setAdapter(adapter);
        dest.setAdapter(adapter);
        try {
            initilization();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        searcht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (!(sourcet.getText().toString().isEmpty() && dest.getText().toString().isEmpty())) {
                    recyclerView.setAdapter(new Rcadapter(Search_bus(sourcet.getText().toString(),
                            dest.getText().toString()),MainActivity.this));
                } else {
                    sourcet.setError("This should not be leave blank");
                    dest.setError("This should not be leave blank");

                }


            }
        });


    }

    List<String> getStops() {
        ArrayList<String> busL = new ArrayList<>();
        try {
            InputStream is = getAssets().open("buses_stops.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            doc.getDocumentElement().normalize();
            NodeList newList = doc.getElementsByTagName("stops");
            if (newList != null) {
                newList = ((Element) newList.item(0)).getElementsByTagName("item");
                for (int k = 0; k < newList.getLength(); k++) {
                    busL.add(newList.item(k).getChildNodes().item(0).getNodeValue());
                }

            }

            return busL;

        } catch (Exception e) {

            return null;
        }
    }


    public void initilization() throws IOException, ParserConfigurationException, SAXException {
        int i, j;
        Element element2;
        NodeList newList;
        ArrayList<String> busL;
        InputStream lf = getAssets().open("buses_lowfloor.xml");
        InputStream mb = getAssets().open("buses_minibus.xml");
        Document ldoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(lf);
        ldoc.getDocumentElement().normalize();
        Document mdoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(mb);
        mdoc.getDocumentElement().normalize();

        NodeList nList = ldoc.getElementsByTagName("bus");
       /* element2= (Element) nList.item(0);
        newList=element2.getElementsByTagName("item");
        busL=new ArrayList();
        for(i=0;i<newList.getLength();i++){

            busL.add(newList.item(i).getChildNodes().item(0).getNodeValue());
            tv.append(newList.item(i).getChildNodes().item(0).getNodeValue().toString());
        }*/

        for (i = 0; i < nList.getLength(); i++) {

            busL = new ArrayList();

            element2 = (Element) nList.item(i);
            newList = element2.getElementsByTagName("item");
            nameLowFloor.add(element2.getAttribute("name"));
            for (j = 0; j < newList.getLength(); j++) {

                busL.add(newList.item(j).getChildNodes().item(0).getNodeValue());
            }

            bus_lowfloor.add(busL);

        }
               /* for(j=0;j<bus_lowfloor.size();j++){
               rse=getArray(bus_lowfloor,j);
                for(i=0;i<rse.length;i++){tv.append(rse[i]);}}*/
        /* for(i=0;i<nameLowfloor.size();i++){tv.append(nameLowfloor.get(i));}*/


        NodeList nList2 = mdoc.getElementsByTagName("bus");
        for (i = 0; i < nList2.getLength(); i++) {
            busL = new ArrayList();
            element2 = (Element) nList2.item(i);
            newList = element2.getElementsByTagName("item");
            nameminibus.add(element2.getAttribute("name"));
            for (j = 0; j < newList.getLength(); j++) {

                busL.add(newList.item(j).getChildNodes().item(0).getNodeValue());
            }
            bus_MIni.add(busL);

        }

        /*for(i=0;i<nameMinibus.size();i++){tv.append(nameMinibus.get(i));
        tv.append("\n");}*/



    }

    public String[] getArray(ArrayList<ArrayList<String>> array, int pos) {
        String[] result = new String[((ArrayList) array.get(pos)).size()];
        ((ArrayList) array.get(pos)).toArray(result);
        return result;
    }

    public List<String> Search_bus(String start, String stop){
        String[] res;
        ArrayList<String> bus_detail = new ArrayList();
        bus_detail.clear();
        for(int k=0;k<bus_lowfloor.size();k++){
            res=getArray(bus_lowfloor,k);
            if(Search_inArray(res,start)  && Search_inArray(res,stop)){
                bus_detail.add(nameLowFloor.get(k)+":L");
            }
        }
        for(int k=0;k<bus_MIni.size();k++){
            res=getArray(bus_MIni,k);
            if(Search_inArray(res,start)  && Search_inArray(res,stop)){
                bus_detail.add(nameminibus.get(k)+":M");
            }

        }


        return bus_detail;

    }


    public boolean Search_inArray(String[] obj,String find){

        for(String s : obj){
            if(s.equals(find)){
                return true;
            }
        }  return  false;
    }


        /*for(i=0;i<nameMinibus.size();i++){tv.append(nameMinibus.get(i));
        tv.append("\n");}*/


}




