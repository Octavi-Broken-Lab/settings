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
			"13 MP + 5MP"
		));

		//whyred
		data.add(new AboutPhoneData(2,
			"whyred",
			"8 x 1.8GHz",
			"Snapdragon 636",
			"4000",
			"2160 x 1080, 5.9 inches",
			"12MP + 5MP + 20MP"
		));
		//RMX1921
		data.add(new AboutPhoneData(3,
			"rmx1921",
			"8 x 2.30GHz",
			"Snapdragon 712",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP"
		));
		//Phoenix
		data.add(new AboutPhoneData(4,
			"phoenix",
			"6 x 2.21GHz, 2 x 1.80Ghz",
			"Snapdragon 730G",
			"4500",
			"1080 x 2400, 6.67 inches",
			"64MP + 8MP + 2MP + 2MP"
		));
		//Violet
		data.add(new AboutPhoneData(5,
			"violet",
			"8 x 2.20GHz",
			"Snapdragon 675",
			"4000",
			"1080 x 2340, 6.3 inches",
			"48MP + 5MP + 13MP"
		));
		//X01BD
		data.add(new AboutPhoneData(6,
			"x01bd",
			"4 x 2.2Ghz, 4 x 1.8Ghz",
			"Snapdragon 660",
			"5000",
			"2280 x 1080, 6.26 inches",
			"12MP + 5MP + 13MP"
		));
		//CPH1859
		data.add(new AboutPhoneData(7,
			"cph1859",
			"8 x 2.0GHz",
			"Mediatek Helio p60",
			"3450",
			"1080 x 2160, 5.99 inches",
			"13MP + 5MP"
		));
		//Vince
		data.add(new AboutPhoneData(8,
			"vince",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"4000",
			"1080 x 2160, 5.99 inches",
			"12MP + 5MP"
		));
		//RMX1901
		data.add(new AboutPhoneData(9,
			"rmx1901",
			"8 x 2.30GHz",
			"Snapdragon 710",
			"3760",
			"1080 x 2340, 6.53 inches",
			"48MP + 5MP AI "
		));
		//Begonia
		data.add(new AboutPhoneData(10,
			"begonia",
			"2 x 2.05GHz + 6 x 2,0Ghz",
			"Helio G90T",
			"4500",
			"1080 x 2340, 6,53 inches",
			"64MP+20MP"
		));
		//RMX1801
		data.add(new AboutPhoneData(11,
			"rmx1801",
			"8 x 2.02GHz",
			"Snapdragon 660",
			"3500",
			"1080 x 2340, 6.3 inches",
			"16MP + 2MP , 16MP "
		));
		//RMX1831
		data.add(new AboutPhoneData(12,
			"rmx1831",
			"4 x 2.1GHz + 4 x 2,0Ghz",
			"Mediatek Helio P70",
			"3500",
			"1080 x 2340, 6,3 inches",
			"13MP+2MP, 16MP"
		));
		//sanders
		data.add(new AboutPhoneData(13,
			"sanders",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"3050",
			"2160 x 1440, 5.5 inches",
			"13MP + 13MP"
		));
		//beryllium
		data.add(new AboutPhoneData(14,
			"beryllium",
			"4 x 2.8 GHz + 4 x 1.8 GHz",
			"Snapdragon 845",
			"4000",
			"1080 x 2246, 6.18 inches",
			"12MP + 5MP + 20MP"
		));
		//Phoenixin
		data.add(new AboutPhoneData(15,
			"phoenixin",
			"6 x 2.21GHz, 2 x 1.80Ghz",
			"Snapdragon 730G",
			"4500",
			"1080 x 2400, 6.67 inches",
			"64MP + 8MP + 2MP + 2MP"
		));
		//X2
		data.add(new AboutPhoneData(16,
			"X2",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP"
		));
		//daisy
		data.add(new AboutPhoneData(17,
			"daisy",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"4000",
			"1080 x 2280, 5.84 inches",
			"12MP + 5MP, 5MP"
		));
		//miatoll
		data.add(new AboutPhoneData(18,
			"gram",
			"8 x 2.0 GHz",
			"Snapdragon 720G",
			"5000",
			"2400 x 1080, 6.67 inches",
			"48MP + 8MP + 5MP + 2MP"
		));
		data.add(new AboutPhoneData(19,
			"curtana",
			"4 x 2.3 GHz + 4 x 1.8 GHz",
			"Snapdragon 720G",
			"5020",
			"2400 x 1080, 6.67 inches",
			"48MP + 8MP + 5MP + 2MP"
		));
		data.add(new AboutPhoneData(20,
			"excalibur",
			"4 x 2.3 GHz + 4 x 1.8 GHz",
			"Snapdragon 720G",
			"5020",
			"2400 x 1080, 6.67 inches",
			"64MP + 8MP + 5MP + 2MP"
		));
		data.add(new AboutPhoneData(21,
			"joyeuse",
			"8 x 2.3 GHz",
			"Snapdragon 720G",
			"5020",
			"2400 x 1080, 6.67 inches",
			"48MP + 8MP + 5MP + 2MP"
		));
		//lavender
		data.add(new AboutPhoneData(22,
			"lavender",
			"8 x 2.20GHz",
			"Snapdragon 660",
			"4000",
			"1080 x 2340, 6.3 inches",
			"48MP + 5MP + 13MP"
		));
		//RMX2001
		data.add(new AboutPhoneData(23,
			"rmx2001",
			"6 x 2.0GHz, 2 x 2.05GHz",
			"Mediatek Helio G90T",
			"4300",
			"1080 x 2400, 6.5 inches",
			"64MP + 8MP + 2MP + 2MP, 16MP"
		));
		// Raphael
		data.add(new AboutPhoneData(24,
			"raphael",
			"1 x 2.84 + 3 x 2.42 GHz + 4 x 1.78",
			"Snapdragon 855 (7 nm)",
			"4000",
			"1080 x 2340, 6.39 inches",
			"48MP + 8MP + 13MP, 20MP"
		));
		// Raphaelin
		data.add(new AboutPhoneData(25,
			"raphaelin",
			"1 x 2.84 + 3 x 2.42 GHz + 4 x 1.78",
			"Snapdragon 855 (7 nm)",
			"4000",
			"1080 x 2340, 6.39 inches",
			"48MP + 8MP + 13MP, 20MP"
		));
		//X2
		data.add(new AboutPhoneData(26,
			"RMX1993L1",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP"
		));

		//X2
		data.add(new AboutPhoneData(27,
			"RMX1992L1",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP"
                ));
		//X2
		data.add(new AboutPhoneData(28,
			"RMX1991CN",
			"2 x 2.2GHz, 6 x 1.8Ghz",
			"Snapdragon 730G",
			"4000",
			"1080 x 2340, 6.4 inches",
			"64MP + 8MP + 2MP + 2MP"
		));
		//wayne
		data.add(new AboutPhoneData(29,
			"wayne",
			"4 x 2.2GHz, 4 x 1.8GHz",
			"Snapdragon 660",
			"3000",
			"1080 x 2160, 5.99 inches",
			"20MP + 12MP, 20MP"
		));
		//jasmine_sprout
		  data.add(new AboutPhoneData(30,
			"jasmine_sprout",
			"4 x 2.2GHz, 4 x 1.8GHz",
			"SDM 660",
			"3000",
			"1080 x 2160, 5.99 inches",
			"20MP + 12MP, 20MP"
		));

		//Payton
		data.add(new AboutPhoneData(31,
			"payton",
			"4 x 2.2GHz, 4 x 1.80GHz",
			"Snapgradon 630",
			"3000",
			"1080 x 1920, 5.2 inches",
			"12MP + 8MP"
	
		));
		//Z01R
		data.add(new AboutPhoneData(32,
			"z01r",
			"4 x 2.7GHz, 4 x 1.7GHz",
			"Snapdragon 845",
			"3300",
			"1080 x 2246, 6.2 inches",
			"12MP + 8MP, 8MP"
		));
		//le_x2
		data.add(new AboutPhoneData(33,
			"le_x2",
			"2 x 2.15GHz, 2 x 1.6Ghz",
			"Snapdragon 820",
			"3200",
			"1440 x 2560, 5.7 inches",
			"21MP + 8MP"
		));
		//land
		data.add(new AboutPhoneData(34,
			"land",
			"4 x 1.4GHz, 4 x 1.1GHz",
			"Snapgradon 430",
			"4000",
			"720 x 1280, 5.0 inches",
			"13MP"
		));
		//grus
		data.add(new AboutPhoneData(35,
			"grus",
			"2 x 2.3 GHz, 6 x 1.7 GHz",
			"Snapgradon 710",
			"3070",
			"1080 x 2340, 5.97 inches",
			"48 MP + 13 MP + 8 MP"
		));
		//deen
		data.add(new AboutPhoneData(36,
			"deen",
			"8 x 2.0GHz",
			"Snapgradon 625",
			"3000",
			"720 x 1520, 5.90 inches",
			"13MP + 2MP, 8MP"
		));
		//sweet
		data.add(new AboutPhoneData(37,
			"sweet",
			"2x2.3GHz,6x1.8GHz",
			"Snapdragon 732G",
			"5020Mah",
			"1080x2400, 6.67 inches",
			"108MP + 8MP + 5MP + 2MP, 16MP"
		));
		//surya
		data.add(new AboutPhoneData(38,
			"surya",
			"2 x 2.3 GHz + 6 x 1.8 Ghz",
			"Snapdragon 732G",
			"5160",
			"2400 x 1080, 6.67 inches",
			"64MP + 13MP + 2MP + 2MP"
		));
		//karna
		data.add(new AboutPhoneData(39,
			"karna",
			"2 x 2.3 GHz + 6 x 1.8 Ghz",
			"Snapdragon 732G",
			"6000",
			"2400 x 1080, 6.67 inches",
			"64MP + 13MP + 2MP + 2MP"
		));
		//ysl
		data.add(new AboutPhoneData(40,
			"ysl",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"3080",
			"1440 x 720, 5.99 inches",
			"12MP + 5MP, 16MP"
		));
		//GSIs
		data.add(new AboutPhoneData(41,
			"phhgsi_arm64_ab",
			"4x1.74GHz, 4x2.31 GHz",
			"Sexynos 6900",
			"4000",
			"1080x2400, 6.47' inches",
			"48+12+5+2MP"
		));
		data.add(new AboutPhoneData(42,
			"phhgsi_arm64_a",
			"4x1.74GHz, 4x2.31 GHz",
			"Sexynos 6900",
			"4000",
			"1080x2400, 6.47' inches",
			"48+12+5+2MP"
		));
		data.add(new AboutPhoneData(43,
			"phhgsi_a64_ab",
			"4x1.74GHz, 4x2.31 GHz",
			"Snappy 999+",
			"3200",
			"1080x1920, 5.5' inches",
			"12MP"
		));
		data.add(new AboutPhoneData(44,
			"phhgsi_a64_a",
			"4x1.74GHz, 4x2.31 GHz",
			"Snappy 999+",
			"3200",
			"1080x1920, 5.5' inches",
			"12MP"
		)); //EndGSIs
		//gauguin
		data.add(new AboutPhoneData(45,
			"gauguin",
			"2 x 2.2 GHz, 6 x 1.8 GHz",
			"Snapdragon 750G",
			"4820",
			"1080 x 2400, 6.67 inchles",
			"64 MP + 16 MP + 8 MP + 2 MP"
		));
		data.add(new AboutPhoneData(46,
			"gauguininpro",
			"2 x 2.2 GHz, 6 x 1.8 GHz",
			"Snapdragon 750G",
			"4820",
			"1080 x 2400, 6.67 inchles",
			"108 MP + 16 MP + 8 MP + 2 MP"
		));
		data.add(new AboutPhoneData(47,
			"gauguinpro",
			"2 x 2.2 GHz, 6 x 1.8 GHz",
			"Snapdragon 750G",
			"4820",
			"1080 x 2400, 6.67 inchles",
			"108 MP + 16 MP + 8 MP + 2 MP"
		));
		//sweetin
		data.add(new AboutPhoneData(48,
			"sweetin",
			"2x2.3GHz,6x1.8GHz",
			"Snapdragon 732G",
			"5020Mah",
			"1080x2400, 6.67 inches",
			"64MP + 8MP + 5MP + 2MP, 16MP"
		));
		//sweetin
		data.add(new AboutPhoneData(49,
			"sweetinpro",
			"2x2.3GHz,6x1.8GHz",
			"Snapdragon 732G",
			"5020Mah",
			"1080x2400, 6.67 inches",
			"108MP + 8MP + 5MP + 2MP, 16MP"
		));
		//dumpling
		data.add(new AboutPhoneData(50,
			"dumpling",
			"4 x 2.45 GHz, 4 x 1.9 GHz",
			"Snapdragon 835",
			"3300",
			"1080 x 2160, 6.01 inches",
			"R: 16 MP + 20MP, F: 16MP"
		));
		//sakura
		data.add(new AboutPhoneData(51,
			"sakura",
			"8 x 2.0GHz",
			"Snapdragon 625",
			"4000",
			"1080 x 2280, 5.84 inches",
			"12MP + 5MP, 5MP"
		));
		//tucana
	        data.add(new AboutPhoneData(52,
			"tucana",
			"2 x 2.2 GHz, 6 x 1.8 GHz",
			"Snapdragon 730G",
			"5260",
			"1080 x 2340, 6.47 inches",
			"108MP+12MP+8MP+20MP+2MP, 32MP"
		));
}
    public static List<AboutPhoneData> getData() {
	return data;
    }
}

