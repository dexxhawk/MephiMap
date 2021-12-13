package com.example.myapplication;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    public Integer CountRooms;
    public Map<String, String> TransitPoints = new HashMap<String, String>();
    public Map<String, String> Center = new HashMap<String, String>();
    public Map<String,String> rooms = new HashMap<String, String>();

    public DataStore fillG1(){
        DataStore G1 = new DataStore();
        G1.CountRooms = 35;
        G1.TransitPoints.put("G2", "964 592");
        G1.Center.put("Center", "970 735");
        G1.rooms.put("G101", "207 735");
        G1.rooms.put("G102", "135 735");
        G1.rooms.put("G103", "260 735");
        G1.rooms.put("G104", "261 735");
        G1.rooms.put("G105", "324 735");
        G1.rooms.put("G106", "383 735");
        G1.rooms.put("G107", "381 735");
        G1.rooms.put("G108", "492 735");
        G1.rooms.put("G109", "531 735");
        G1.rooms.put("G109a", "490 735");
        G1.rooms.put("G110", "590 735");
        G1.rooms.put("G111", "590 735");
        G1.rooms.put("G113", "640 735");
        G1.rooms.put("G114", "636 735");
        G1.rooms.put("G115", "677 735");
        G1.rooms.put("G116", "682 735");
        G1.rooms.put("G117", "1219 735");
        G1.rooms.put("G119", "1269 735");
        G1.rooms.put("G120", "1220 735");
        G1.rooms.put("G121", "1322 735");
        G1.rooms.put("G122", "1270 735");
        G1.rooms.put("G124", "1320 735");
        G1.rooms.put("G126", "1374 735");
        G1.rooms.put("G126a", "1426 735");
        G1.rooms.put("G123a", "1425 735");
        G1.rooms.put("G128", "1497 735");
        G1.rooms.put("G125", "1558 735");
        G1.rooms.put("G127", "1612 735");
        G1.rooms.put("G130", "1612 735");
        G1.rooms.put("G129", "1673 735");
        G1.rooms.put("G131", "1673 735");
        G1.rooms.put("G132", "1739 735");



        return G1;
    }

    public DataStore fillG2(){
        DataStore G2 = new DataStore();
        G2.CountRooms = 36;
        G2.TransitPoints.put("A2", "47 842");
        G2.TransitPoints.put("B2", "1881 831");
        G2.TransitPoints.put("G1", "1072 656");
        G2.Center.put("Center", "968 835");
        G2.rooms.put("G201", "246 817");
        G2.rooms.put("G202", "147 869");
        G2.rooms.put("G203", "412 814");
        G2.rooms.put("G203a", "357 812");
        G2.rooms.put("G204", "248 867");
        G2.rooms.put("G205", "519 812");
        G2.rooms.put("G206", "356 869");
        G2.rooms.put("G207", "571 807");
        G2.rooms.put("G208", "521 868");
        G2.rooms.put("G209", "625 805");
        G2.rooms.put("G209a", "678 805");
        G2.rooms.put("G210", "624 867");
        G2.rooms.put("G211", "730 805");
        G2.rooms.put("G212", "624 867");
        G2.rooms.put("G213", "838 802");
        G2.rooms.put("G214", "730 864");
        G2.rooms.put("G215", "1121 799");
        G2.rooms.put("G216", "835 866");
        G2.rooms.put("G217", "1175 796");
        G2.rooms.put("G218", "835 866");
        G2.rooms.put("G219", "1225 797");
        G2.rooms.put("G221", "1273 797");
        G2.rooms.put("G223", "1325 799");
        G2.rooms.put("G224", "1172 862");
        G2.rooms.put("G225", "1428 796");
        G2.rooms.put("G225a", "1378 796");
        G2.rooms.put("G226a", "1213 862");
        G2.rooms.put("G227", "1587 796");
        G2.rooms.put("G229", "1640 796");
        G2.rooms.put("G237", "1693 796");
        G2.rooms.put("G231", "1750 797");
        G2.rooms.put("G226", "1393 863");
        G2.rooms.put("G228", "1485 861");
        G2.rooms.put("G230", "1535 861");
        G2.rooms.put("G232", "1643 862");
        G2.rooms.put("G234", "1753 862");

        return G2;
    }


    public DataStore fillB2(){
        DataStore B2 = new DataStore();
        B2.CountRooms = 22;
        B2.TransitPoints.put("A2", "209 684");
        B2.TransitPoints.put("G2", "1576 983");
        B2.TransitPoints.put("B3", "1421 569");
        B2.Center.put("Center", "1568 375");
        B2.rooms.put("B201", "1722 431");
        B2.rooms.put("B202", "1830 362");
        B2.rooms.put("B203", "1655 431");
        B2.rooms.put("B204", "1721 305");
        B2.rooms.put("B205", "1521 868");
        B2.rooms.put("B206", "1655 304");
        B2.rooms.put("B207", "1522 711");
        B2.rooms.put("B208", "1318 320");
        B2.rooms.put("B210", "1161 318");
        B2.rooms.put("B211", "1126 421");
        B2.rooms.put("B212", "985 320");
        B2.rooms.put("B212st", "825 320");
        B2.rooms.put("B213", "983 422");
        B2.rooms.put("B214", "686 321");
        B2.rooms.put("B215", "828 420");
        B2.rooms.put("B216", "542 316");
        B2.rooms.put("B217", "686 422");
        B2.rooms.put("B218", "408 317");
        B2.rooms.put("B219", "544 419");
        B2.rooms.put("B220", "194 315");
        B2.rooms.put("B222", "89 315");
        B2.rooms.put("B221", "404 421");

        return B2;
    }

    public DataStore fillB3(){
        DataStore B3 = new DataStore();
        B3.CountRooms = 18;
        B3.Center.put("Center", "1586 331");
        B3.TransitPoints.put("B2", "1432 544");
        B3.rooms.put("B301", "1585 875");
        B3.rooms.put("B303", "1585 708");
        B3.rooms.put("B304", "1585 479");
        B3.rooms.put("B306", "1340 330");
        B3.rooms.put("B307", "1129 330");
        B3.rooms.put("B308", "1220 330");
        B3.rooms.put("B309", "908 330");
        B3.rooms.put("B310", "1119 330");
        B3.rooms.put("B311", "803 330");
        B3.rooms.put("B312", "1003 330");
        B3.rooms.put("B313", "705 330");
        B3.rooms.put("B314a","754 330");
        B3.rooms.put("B315", "598 330");
        B3.rooms.put("B316", "549 330");
        B3.rooms.put("B317", "476 330");
        B3.rooms.put("B318", "352 330");
        B3.rooms.put("B319", "280 330");
        B3.rooms.put("B320", "204 330");
        B3.rooms.put("B322", "98 330");
        return B3;
    }
}

