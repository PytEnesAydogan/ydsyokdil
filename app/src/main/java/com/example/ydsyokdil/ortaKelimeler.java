package com.example.ydsyokdil;

public  class ortaKelimeler extends AppCompatActivity {

    String[] Eng_kelimeler = {"PEOPLE", "EMPLOYMENT", "PROFIT",
            "YET", "SEVERAL", "EXPRESS", "RIDE", "SPEND", "LIKELY",
            "TASTE", "SURVEY"


    };

    String[] Tur_Anlamlar = {"İNSANLAR", "İŞ,İSTİHDAM", "KAR,FAYDA", "HENÜZ",
            "BİR KAÇ", "SÜRATLİ,HIZLI", "BİNME", "PARA HARCAMAK", "MUHTEMEL,OLASI",
            "TATMAK", "ARAŞTIRMAK,ANKET"


    };

    int[][] Kelime_pozisyonlari = {{1, 0, 5}, {0, 1, 5}, {0, 3, 5}, {0, 4, 0}
            , {0, 5, 4}, {1, 4, 1}, {0, 7, 1}, {1, 5, 4},
            {1, 5, 10}, {0, 8, 6}, {0, 10, 5}
    };


    public String[] getWords() { return Eng_kelimeler;
    }

    public String[] getMeans() {
        return Tur_Anlamlar;
    }
    public int[][] getPositions() {
        return Kelime_pozisyonlari;
    }


        public static class orta2Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"ADMIRE", "DISTURB", "BASE",
                "ASSERT", "TAVERN", "ESCAPE", "SHIP", "ESTATE", "TROOP",
                "TEMPT", "MARRIAGE"

        };

        String[] Tur_Anlamlar = {"HAYRAN OLMAK", "RAHATSIZ ETMEK",
                "TEMEL,BAZ", "İDDİA ETMEK",
                "MEYHANE", ",KAÇMAK", "GEMİ", "ARAZİ",
                "ASKERİ BİRLİK",
                "ÖZENDİRMEK", "EVLİLİK"


        };

        int[][] Kelime_pozisyonlari = {{1, 0, 3}, {0, 1, 3}, {1,1,9}, {0,2,9}
                , {1,2,14}, {0,5,3}, {1,5,4}, {1,5,8},
                {0,7,8}, {0,8,1}, {0, 10, 1}
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

    }
    public static class orta3Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"WASTE", "WEALTHY", "REDUCE",
                "IMPROVE", "ADAPT", "IMPATIENT", "ATTACH", "INTENT", "WHOM",
                "TEAM", "WIT", "ACTIVITY"

        };

        String[] Tur_Anlamlar = {"ATIK", "ZENGİN,VARLIKLI",
                "AZALTMAK", "GELİŞMEK,İLERLEMEK",
                "UYUM SAĞLAMAK", "SABIRSIZ", "İLİŞTİRMEK", "NİYET,AMAÇ",
                "KİMİ,KİME",
                "TAKIM", "İNCE ESPRİ", "ETKİNLİK"


        };

        int[][] Kelime_pozisyonlari = {{0, 0, 5}, {1, 0, 5}, {0, 1, 0},
                {1, 1, 12}
                , {0, 3, 9}, {0, 4, 1}, {1, 3, 9}, {1, 4, 1},
                {0, 8, 8}, {0, 9, 1}, {1, 8, 8}, {0, 10, 6}
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
    }

    public static class orta4Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"CENTURY", "CONSTRUCT", "FEAR",
                "APTITUDE", "ABSENT", "BEHIND", "VOYAGER", "EVENLY",
                "DEAF",
                "ESTABLISH", "THEORY","COVER"

        };

        String[] Tur_Anlamlar = {"YÜZYIL,ASIR", "İNŞAA ETMEK,YAPIM",
                "KORKU", "YETENEK,YATKINLIK",
                "YOK,BULUNMAYAN", "ARKASINDA", "SEYYAH", "EŞİT HİZALI",
                "SAĞIR",
                "KURMAK,SAPTAMAK", "TEORİ,KURAM","ÖRTMEK,KAPAK"


        };

        int[][] Kelime_pozisyonlari = {{0,0,5}, {1,0,5}, {0,1,0},
                {1,1,12}
                , {0,3,9}, {0,4,1}, {1,3,9}, {1,4,1},
                {0,8,8}, {0,9,1}, {1,8,8},{0,10,6}
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

    }
    public static class orta6Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"REACH", "SPACE", "ADDITIVE",
                "SUCCESS", "ADDED", "DESIGN", "SPEND", "WINNER",
                "WIFE",
                "WRONG", "WOOL","REVEAL","BIAS","GRAND"

        };

        String[] Tur_Anlamlar = {"ERİŞİM", "UZAY,BOŞLUK",
                "KATKI MADDESİ", "BAŞARI",
                "EKLENMİŞ", "TASARIM", "HARCAMAK", "KAZANAN",
                "EŞ,KARI",
                "YANLIŞ,HATALI", "YÜN","ORTAYA ÇIKARTMAK","ÖN YARGI",
                "BÜYÜK,GÖRKEMLİ"


        };

        int[][] Kelime_pozisyonlari = {{1,0,6}, {0,1,2}, {1,0,13},
                {0,3,4}
                , {0,1,9}, {1,1,10}, {1,3,4}, {1,4,2},
                {0,5,1}, {0,6,7}, {1,6,7},{0,9,2},{0,8,9},{1,7,11}
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

    }
    public static class orta5Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"BRAIN", "CHILDREN", "SNACK",
                "SENIOR", "ADVANCE", "SILK", "BLOCK", "CHANGE",
                "SAFETY",
                "EAST"

        };

        String[] Tur_Anlamlar = {"BEYİN", "ÇOCUKLAR",
                "APERATİF,ATIŞTIRMALIK", "ÜST,KIDEMLİ",
                "İLERLEME,GELİŞME", "İPEK", "ENGEL", "DEĞİŞMEK",
                "GÜVENLİK",
                "DOĞU"


        };

        int[][] Kelime_pozisyonlari = {{1,0,7}, {0,3,5}, {1,0,5},
                {1,1,12}
                , {1,2,9}, {1,2,2}, {0,4,1}, {1,4,4},
                {0,9,1}, {0,8,9}
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

    }
    public static class orta7Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"FOUND", "NATION", "NATURAL",
                "TOTALLY", "COST", "CENTRE", "FREE", "WHATEVER",
                "UNDERSTAND",
                "NAMELY", "MOREOVER","LIVE","LAZY"

        };

        String[] Tur_Anlamlar = {"KURMAK", "ULUS,MİLLET",
                "DOĞAL", "TAMAMEN",
                "MALİYET", "MERKEZ", "ÜCRETSİZ", "HER NEYSE",
                "ANLAMA,BİLME",
                "YANİ,ŞÖYLE Kİ", "DAHASI,ÜSTELİK","CANLI","TEMBEL"


        };

        int[][] Kelime_pozisyonlari = {{1,0,7}, {0,1,3}, {1,1,3},
                {1,2,1}
                , {0,3,0}, {1,2,13}, {1,3,9}, {1,1,11},
                {0,4,5}, {1,4,6}, {0,6,6},{0,7,3},{0,9,3}
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

    }
    public static class orta8Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"WASTE", "WEALTHY", "REDUCE",
                "IMPROVE", "ADAPT", "IMPATIENT", "ATTACH", "INTENT", "WHOM",
                "TEAM", "WIT","ACTIVITY"

        };

        String[] Tur_Anlamlar = {"ATIK", "ZENGİN,VARLIKLI",
                "AZALTMAK", "GELİŞMEK,İLERLEMEK",
                "UYUM SAĞLAMAK", "SABIRSIZ", "İLİŞTİRMEK", "NİYET,AMAÇ",
                "KİMİ,KİME",
                "TAKIM", "İNCE ESPRİ","ETKİNLİK"


        };

        int[][] Kelime_pozisyonlari = {{0,0,5}, {1,0,5}, {0,1,0},
                {1,1,12}
                , {0,3,9}, {0,4,1}, {1,3,9}, {1,4,1},
                {0,8,8}, {0,9,1}, {1,8,8},{0,10,6}
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

    }public static class orta9Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"WASTE", "WEALTHY", "REDUCE",
                "IMPROVE", "ADAPT", "IMPATIENT", "ATTACH", "INTENT", "WHOM",
                "TEAM", "WIT","ACTIVITY"

        };

        String[] Tur_Anlamlar = {"ATIK", "ZENGİN,VARLIKLI",
                "AZALTMAK", "GELİŞMEK,İLERLEMEK",
                "UYUM SAĞLAMAK", "SABIRSIZ", "İLİŞTİRMEK", "NİYET,AMAÇ",
                "KİMİ,KİME",
                "TAKIM", "İNCE ESPRİ","ETKİNLİK"


        };

        int[][] Kelime_pozisyonlari = {{0,0,5}, {1,0,5}, {0,1,0},
                {1,1,12}
                , {0,3,9}, {0,4,1}, {1,3,9}, {1,4,1},
                {0,8,8}, {0,9,1}, {1,8,8},{0,10,6}
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

    }
    public static class orta10Kelimeler extends AppCompatActivity {

        String[] Eng_kelimeler = {"WASTE", "WEALTHY", "REDUCE",
                "IMPROVE", "ADAPT", "IMPATIENT", "ATTACH", "INTENT", "WHOM",
                "TEAM", "WIT","ACTIVITY"

        };

        String[] Tur_Anlamlar = {"ATIK", "ZENGİN,VARLIKLI",
                "AZALTMAK", "GELİŞMEK,İLERLEMEK",
                "UYUM SAĞLAMAK", "SABIRSIZ", "İLİŞTİRMEK", "NİYET,AMAÇ",
                "KİMİ,KİME",
                "TAKIM", "İNCE ESPRİ","ETKİNLİK"


        };

        int[][] Kelime_pozisyonlari = {{0,0,5}, {1,0,5}, {0,1,0},
                {1,1,12}
                , {0,3,9}, {0,4,1}, {1,3,9}, {1,4,1},
                {0,8,8}, {0,9,1}, {1,8,8},{0,10,6}
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

    }




}
