package sample;

import java.util.ArrayList;
import java.util.List;

public class Controls {


        public static List<Control> filtered(List<Control> controls, String search) {
            List<Control> filtered = new ArrayList();

            for(int i = 0; i < controls.size(); ++i) {
                if (((Control)controls.get(i)).getType().toString().toLowerCase().contains(search.toLowerCase())) {
                    filtered.add((Control)controls.get(i));
                }
            }

            return filtered;
        }
    }


