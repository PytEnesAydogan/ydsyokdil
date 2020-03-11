package com.example.ydsyokdil;

public class kolayKelimeler {

    String[] Eng_kelimeler = {

    };

    String[] Tur_Anlamlar = {


    };

    int[][] Kelime_pozisyonlari = {{1, 0, 7}, {0, 2, 0}, {1, 2, 8}, {1, 2, 1}
            , {0, 1, 11}, {1, 1, 11}, {0, 4, 11}, {1, 1, 14},
            {0, 3, 7}, {0, 4, 4}, {0, 7, 12}, {1, 4, 4}, {0, 7, 3}, {1, 7, 3}, {1, 7, 12},
            {1, 7, 6}, {0, 9, 1}
    };


    public String[] getWords() {
        return Eng_kelimeler;
    }

    public String[] getMeans() {
        return Tur_Anlamlar;
    }

    public int[][] getPositions() {
        return Kelime_pozisyonlari;
    }


        public static class kolay2Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "GREAT", "AVERAGE",
                    "LENGTH", "BONE","PAINFUL",
                    "MANAGEMENT","ABSORB", "CLIMB","COIN",
                    "NEUTRAL","MENTION","THEORY","LEND","ENERGY",
                    "GOVERN","GOVERNOR","INFER","WRONG","REFERENCE","REPORT"
            };

            String[] Tur_Anlamlar = {"BÜYÜK,MÜKEMMEL", "ORTALAMA",
                    "UZUNLUK,BOY", "KEMİK" ,"AĞRILI,ACI VERİCİ",
                    "YÖNETİM,İDARE","EMMEK,SOĞURMAK" ,"TIRMANIŞ","BOZUK PARA",
                    "NÖTR","BAHSETMEK,SÖYLEMEK","TEORİ,KURAM","ÖDÜNÇ VERMEK",
                    "ENERJİ,GÜÇ","İDARE ETMEK,YÖNETMEK","VALİ","SONUÇ ÇIKARMAK",
                    "YANLIŞ,HATALI","BAŞVURMA,DANIŞMA","RAPOR,BİLDİRİM"

            };

            int[][] Kelime_pozisyonlari = { {1,0,7}, {0,1,4}, {1,0,10},{1,0,13}
                    ,{1,0,2}, {0,3,6},{1,1,4} ,{0,2,0},
                    {1,2,0},{0,5,0},{1,3,12},{1,3,15},{1,5,6},{0,7,5},{1,7,9},
                    {0,9,7},{1,9,4},{0,10,1},{0,12,3},{1,9,14}};



            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay3Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay4Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "FENER", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay5Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay6Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay7Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay8Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay9Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

        public static class kolay10Kelimeler extends AppCompatActivity {

            String[] Eng_kelimeler = { "PASSAGE", "pale",
                    "de", "souza","DESCRIBE",
                    "WRITE","WIRE", "THEIR","SIGHT",
                    "SHIP","INSECT","RESENT","ROPE","IT",
                    "TODAY","PATTERN","SETTING","RAIN","GROW","TOWN",
                    "STAY","ICE","YARD","ITS","SIT","LIGHT","LAY"
            };

            String[] Tur_Anlamlar = {"leyla", "KARŞISINDA",
                    "FİKİR,DÜŞÜNCE", "ENDÜSTRİ" ,"AÇIKLAMAK",
                    "YAZMAK","KABLO" ,"ONLARIN","GÖRME,GÖRÜNÜŞ",
                    "GEMİ","BÖCEK","GÜCENMEK,ALINMAK","HALAT",
                    "O","BUGÜN","DESEN,MODEL","AYAR,DÜZENLEME",
                    "YAĞMUR","BÜYÜMEK","KASABA,KENT","KALMAK",
                    "BUZ","AVLU,BAHÇE","ONUN",
                    "OTURMAK,BİNMEK","IŞIK,AYDINLIK","UZANMAK"

            };

            int[][] Kelime_pozisyonlari = { {0,0,0}, {1,0,0}, {1,0,2},{1,0,4} ,{0,2,4}, {0,0,8},{1,0,8} ,{1,0,11},
                    {0,5,0},{0,4,4},{1,4,6},{0,6,4},{0,4,11},{0,3,11},{1,3,12},{1,0,14},{1,4,9},{0,6,11},{1,5,2},
                    {0,8,0},{1,7,0},{0,8,5},{0,10,0},{0,8,9},{1,8,11},{0,10,7},{1,8,14}};





            public String[] getWords(){
                return Eng_kelimeler;
            }

            public String[] getMeans(){
                return Tur_Anlamlar;
            }

            public int[][] getPositions(){
                return Kelime_pozisyonlari;
            }
        }

    private static class AppCompatActivity {
    }
}
