package com.android.settings;

import java.util.ArrayList;
import java.util.List;
import com.android.settings.R;

public final class PhoneData {
    public static List<AboutPhoneData> data = new ArrayList<>();

    static {
        data.add(new AboutPhoneData(0));

        //MIDO
        data.add(new AboutPhoneData(1,
                "mido",
                "8 x 2.0GHz",
                "Snapdragon 625",
                "4100",
                "1920 x 1080, 5.5 inches",
                "13 MP + 5MP",
                R.drawable.rmx1921
        ));

        //whyred
        data.add(new AboutPhoneData(2,
                "whyred",
                "8 x 1.8GHz",
                "Snapdragon 636",
                "4000",
                "2160 x 1080, 5.9 inches",
                "12MP + 5MP + 20MP",
                R.drawable.rmx1921
        ));
	//RMX1921
	data.add(new AboutPhoneData(3,
		"rmx1921",
                "8 x 2.30GHz",
                "Snapdragon 712",
                "4000",
                "1080 x 2340, 6.4 inches",
                "64MP + 8MP + 2MP + 2MP",
                R.drawable.rmx1921
	));
    }

    public static List<AboutPhoneData> getData() {
        return data;
    }
}

