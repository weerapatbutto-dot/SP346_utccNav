package com.example.sp346_utccnav;

import java.util.ArrayList;
import java.util.List;


public class BuildingRepository {
    private static List<Building> buildings;

    static {
        buildings = new ArrayList<>();
        // Adding UTCC Buildings in numerical order 10 building
        buildings.add(new Building("ตึก 0", 13.779989842269861, 100.55994166175604, "อาคาร ประชุม"));
        buildings.add(new Building("ตึก 1", 13.77928170188982, 100.55997880652406, "อาคาร 1"));
        buildings.add(new Building("ตึก 3", 13.779200252232616, 100.56058307726535, "อาคาร 3"));
        buildings.add(new Building("ตึก 5", 13.780841678457527, 100.56058472135702, "อาคาร 5"));
        buildings.add(new Building("ตึก 7", 13.779513125254471, 100.56108830609556, "อาคาร 7"));
        buildings.add(new Building("ตึก 8", 13.780436600775625, 100.55964259545465, "อาคาร จอดรถ"));
        buildings.add(new Building("ตึก 10", 13.778748975450544, 100.5602919544518, "อาคาร 10"));
        buildings.add(new Building("ตึก 21", 13.780405340722664, 100.56100582817675, "อาคาร 21"));
        buildings.add(new Building("ตึก 23", 13.779824424180603, 100.56117346622875, "อาคาร 23"));
        buildings.add(new Building("ตึก 24", 13.780329795615001, 100.5604076955666, "อาคาร 24"));
    }

    public static List<Building> getBuildings() {
        return buildings;
    }

    public static Building getBuildingByName(String name) {
        for (Building b : buildings) {
            if (b.getName().equals(name)) return b;
        }
        return null;
    }
}
