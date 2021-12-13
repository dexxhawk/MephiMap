package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WayFounding {

    ArrayList<Nodes> nodes = new ArrayList<Nodes>();
    Map<String, Boolean> vertexes = new HashMap<String, Boolean>();

    public void fillData(){
        //Nodes Data:
        nodes.add(new Nodes("G2", "G1"));
        nodes.add(new Nodes("G2", "G3"));
        nodes.add(new Nodes("G2", "G4"));
        nodes.add(new Nodes("G2", "A2"));
        nodes.add(new Nodes("G2", "B2"));
        nodes.add(new Nodes("G1", "G2"));
        nodes.add(new Nodes("G3", "G2"));
        nodes.add(new Nodes("G4", "G2"));
        nodes.add(new Nodes("B2", "G2"));
        nodes.add(new Nodes("В2", "A2"));
        nodes.add(new Nodes("B2", "B3"));
        nodes.add(new Nodes("B3", "B2"));
        nodes.add(new Nodes("A2", "G2"));
        nodes.add(new Nodes("A2", "B2"));
        nodes.add(new Nodes("A2", "W2"));
        nodes.add(new Nodes("W2", "A2"));
        nodes.add(new Nodes("W2", "W1"));
        nodes.add(new Nodes("W2", "W3"));
        nodes.add(new Nodes("W2", "W4"));
        nodes.add(new Nodes("W1", "W2"));
        nodes.add(new Nodes("W3", "W2"));
        nodes.add(new Nodes("W4", "W2"));
        //Vertexes Data:
        vertexes.put ("G1", true);
        vertexes.put ("G2", true);
        vertexes.put ("G3", true);
        vertexes.put ("G4", true);
        vertexes.put ("B2", true);
        vertexes.put ("B3", true);
        vertexes.put ("A2", true);
        vertexes.put ("W1", true);
        vertexes.put ("W2", true);
        vertexes.put ("W3", true);
        vertexes.put ("W4", true);
    }


//    public class Vertexes{
//        String Key;
//        String Value;
//        String NameKey;
//
//        Vertexes(String key, String value, String nameKey){
//            Key = key;
//            Value = value;
//            NameKey = nameKey;
//        }
//    }


    ArrayList<String> WayStr = new ArrayList<String>();
    int wayCount = 9999;
    ArrayList<String> localWayStr = new ArrayList<String>();
    int localWayCount = -1;


    public void recursionSearch(String start, String end) {
        //vertexes.get(start) = false;
        vertexes.remove(start);
        vertexes.put(start, false);
        localWayCount++;
        localWayStr.add(start);
        if (start.equals(end)) {
            if (localWayCount < wayCount) {
                wayCount = localWayCount;
                WayStr = (ArrayList<String>) localWayStr.clone();
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).S.equals(start)) {
                if (vertexes.get(nodes.get(i).E)) {
                    recursionSearch(nodes.get(i).E, end);
                    localWayCount--;
                    localWayStr.remove(localWayStr.size() - 1);
                    //vertexes.get(nodes.get(i).E) = true;
                    vertexes.remove(nodes.get(i).E);
                    vertexes.put(nodes.get(i).E, true);
                }
            }
        }
    }

    public ArrayList<OBJ> wayfounding(String startInput, String endInput) {

        recursionSearch(startInput, endInput);

        ArrayList<OBJ> obj = new ArrayList<OBJ>();
        obj.add(new OBJ(wayCount, WayStr));
        return obj;
        }

    }
