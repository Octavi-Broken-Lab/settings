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
			R.drawable.whyred
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
		//Phoenix
		data.add(new AboutPhoneData(4,
			"phoenix",
			"6 x 2.21GHz, 2 x 1.80Ghz",
			"Snapdragon 730G",
			"4500",
			"1080 x 2400, 6.67 inches",
			"64MP + 8MP + 2MP + 2MP",
			R.drawable.phoenix
		));
		//Violet
		data.add(new AboutPhoneData(5,
			"violet",
			"8 x 2.20GHz",
			"Snapdragon 675",
			"4000",
			"1080 x 2340, 6.3 inches",
			"48MP + 5MP + 13MP",
			R.drawable.violet
		));
		//X01BD
		data.add(new AboutPhoneData(6,
			"x01bd",
			"4 x 2.2Ghz, 4 x 1.8Ghz",
			"Snapdragon 660",
			"5000",
			"2280 x 1080, 6.26 inches",
			"12MP + 5MP + 13MP",
			R.drawable.x01bd
		));
		//CPH1859
		data.add(new AboutPhoneData(7,
			"cph1859",
			"8 x 2.0GHz",
			"Mediatek Helio p60",
			"3450",
			"1080 x 2160, 5.99 inches",
			"13MP + 5MP",
			R.drawable.cph1859
		));
		//Vince
		data.add(new AboutPhoneData(8,
			"vince",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"4000",
			"1080 x 2160, 5.99 inches",
			"12MP + 5MP",
			R.drawable.vince
		));
		//RMX1901
		data.add(new AboutPhoneData(9,
			"rmx1901",
			"8 x 2.30GHz",
			"Snapdragon 710",
			"3760",
			"1080 x 2340, 6.53 inches",
			"48MP + 5MP AI ",
			R.drawable.rmx1901
		));
		//Begonia
		data.add(new AboutPhoneData(10,
			"begonia",
			"2 x 2.05GHz + 6 x 2,0Ghz",
			"Helio G90T",
			"4500",
			"1080 x 2340, 6,53 inches",
			"64MP+20MP",
			R.drawable.begonia
		));
		//RMX1801
		data.add(new AboutPhoneData(11,
			"rmx1801",
			"8 x 2.02GHz",
			"Snapdragon 660",
			"3500",
			"1080 x 2340, 6.3 inches",
			"16MP + 2MP , 16MP ",
			R.drawable.rmx1801
		));
		//RMX1831
		data.add(new AboutPhoneData(12,
			"rmx1831",
			"4 x 2.1GHz + 4 x 2,0Ghz",
			"Mediatek Helio P70",
			"3500",
			"1080 x 2340, 6,3 inches",
			"13MP+2MP, 16MP",
			R.drawable.rmx1831
		));
		//sanders
		data.add(new AboutPhoneData(13,
			"sanders",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"3050",
			"2160 x 1440, 5.5 inches",
			"13MP + 13MP",
			R.drawable.sanders
		));
		//beryllium
		data.add(new AboutPhoneData(14,
			"beryllium",
			"4 x 2.8 GHz + 4 x 1.8 GHz",
			"Snapdragon 845",
			"4000",
			"1080 x 2246, 6.18 inches",
			"12MP + 5MP + 20MP",
			R.drawable.beryllium
		));
		//Phoenixin
		data.add(new AboutPhoneData(15,
			"phoenixin",
			"6 x 2.21GHz, 2 x 1.80Ghz",
			"Snapdragon 730G",
			"4500",
			"1080 x 2400, 6.67 inches",
			"64MP + 8MP + 2MP + 2MP",
			R.drawable.phoenix
		));
		//X2
		data.add(new AboutPhoneData(16,
			"X2",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP",
			R.drawable.X2
		));
		//daisy
		data.add(new AboutPhoneData(17,
			"daisy",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"4000",
			"1080 x 2280, 5.84 inches",
			"12MP + 5MP, 5MP",
			R.drawable.daisy
		));
		//miatoll
		data.add(new AboutPhoneData(18,
			"gram",
			"8 x 2.0 GHz",
			"Snapdragon 720G",
			"5000",
			"2400 x 1080, 6.67 inches",
			"48MP + 8MP + 5MP + 2MP",
			R.drawable.miatoll
		));
		data.add(new AboutPhoneData(19,
			"curtana",
			"4 x 2.3 GHz + 4 x 1.8 GHz",
			"Snapdragon 720G",
			"5020",
			"2400 x 1080, 6.67 inches",
			"48MP + 8MP + 5MP + 2MP",
			R.drawable.miatoll
		));
		data.add(new AboutPhoneData(20,
			"excalibur",
			"4 x 2.3 GHz + 4 x 1.8 GHz",
			"Snapdragon 720G",
			"5020",
			"2400 x 1080, 6.67 inches",
			"64MP + 8MP + 5MP + 2MP",
			R.drawable.miatoll
		));
		data.add(new AboutPhoneData(21,
			"joyeuse",
			"8 x 2.3 GHz",
			"Snapdragon 720G",
			"5020",
			"2400 x 1080, 6.67 inches",
			"48MP + 8MP + 5MP + 2MP",
			R.drawable.miatoll
		));
		//lavender
		data.add(new AboutPhoneData(22,
			"lavender",
			"8 x 2.20GHz",
			"Snapdragon 660",
			"4000",
			"1080 x 2340, 6.3 inches",
			"48MP + 5MP + 13MP",
			R.drawable.lavender
		));
		//RMX2001
		data.add(new AboutPhoneData(23,
			"rmx2001",
			"6 x 2.0GHz, 2 x 2.05GHz",
			"Mediatek Helio G90T",
			"4300",
			"1080 x 2400, 6.5 inches",
			"64MP + 8MP + 2MP + 2MP, 16MP",
			R.drawable.rmx2001
		));
		// Raphael 
		data.add(new AboutPhoneData(24,
			"raphael",
			"1 x 2.84 + 3 x 2.42 GHz + 4 x 1.78",
			"Snapdragon 855 (7 nm)",
			"4000",
			"1080 x 2340 ,6.39 inches",
			"48MP + 8MP + 13MP, 20MP",
			R.drawable.raphael
		));
		// Raphaelin      
		data.add(new AboutPhoneData(25,
			"raphaelin",
			"1 x 2.84 + 3 x 2.42 GHz + 4 x 1.78",
			"Snapdragon 855 (7 nm)",
			"4000",
			"1080 x 2340 ,6.39 inches",
			"48MP + 8MP + 13MP, 20MP",
			R.drawable.raphael
		));
		//X2
		data.add(new AboutPhoneData(26,
			"RMX1993L1",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP",
			R.drawable.X2
		));

		//X2
		data.add(new AboutPhoneData(27,
			"RMX1992L1",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP",
			R.drawable.X2
                ));
		//X2
		data.add(new AboutPhoneData(28,
			"RMX1991CN",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP",
			R.drawable.X2
		));
	        //wayne
        	data.add(new AboutPhoneData(29,
                	"wayne",
	                "4 x 2.2GHz, 4 x 1.8GHz",
        	        "Snapdragon 660",
                	"3000",
	                "1080 x 2160, 5.99 inches",
        	        "20MP + 12MP, 20MP",
                	R.drawable.wayne
	        ));
		//jasmine_sprout
		  data.add(new AboutPhoneData(30,
        	        "jasmine_sprout",
                	"4 x 2.2GHz, 4 x 1.8GHz",
	                "SDM 660",
        	        "3000",
                	"1080 x 2160, 5.99 inches",
	                "20MP + 12MP, 20MP",
        	        R.drawable.whyred
		));

	        //Payton
        	data.add(new AboutPhoneData(31,
                	"payton",
	                "4 x 2.2GHz, 4 x 1.80GHz",
        	        "Snapgradon 630",
                	"3000",
	                "1080 x 1920, 5.2 inches",
        	        "12MP + 8MP",
                	R.drawable.payton
	        ));
                //Z01R
                data.add(new AboutPhoneData(32,
                        "z01r",
                        "4 x 2.7GHz, 4 x 1.7GHz",
                        "Snapdragon 845",
                        "3300",
                        "1080 x 2246, 6.2 inches",
                        "12MP + 8MP, 8MP",
                        R.drawable.Z01R
               ));
		//le_x2
        	data.add(new AboutPhoneData(33,
	                "le_x2",
                	"2 x 2.15GHz, 2 x 1.6Ghz",
        	        "Snapdragon 820",
		        "3200",
                	"1440 x 2560, 5.7 inches",
        	        "21MP + 8MP",
	                R.drawable.le_x2
               ));
	        //land
	        data.add(new AboutPhoneData(34,
	               "land",
	                "4 x 1.4GHz, 4 x 1.1GHz",
        	        "Snapgradon 430",
                	"4000",
	                "720 x 1280, 5.0 inches",
        	        "13MP",
                	R.drawable.land
	        ));
		//grus
	        data.add(new AboutPhoneData(35,
	               "grus",
	                "2 x 2.3 GHz, 6 x 1.7 GHz",
        	        "Snapgradon 710",
                	"3070",
	                "1080 x 2340, 5.97 inches",
        	        "48 MP + 13 MP + 8 MP",
                	R.drawable.grus
	        ));
                //deen
	        data.add(new AboutPhoneData(36,
	                "deen",
	                "8 x 2.0GHz",
        	        "Snapgradon 625",
                	"3000",
	                "720 x 1520, 5.90 inches",
        	        "13MP + 2MP, 8MP",
                	R.drawable.deen
	        ));
}
    public static List<AboutPhoneData> getData() {
	return data;
    }
}

