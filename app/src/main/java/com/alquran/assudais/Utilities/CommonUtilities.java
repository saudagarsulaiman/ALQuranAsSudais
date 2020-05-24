package com.alquran.assudais.Utilities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alquran.assudais.R;

public final class CommonUtilities {

    public static final String SALAAMSOUND = "SALAAMSOUND";

    public static boolean isConnectionAvailable(Context ctx) {
        //boolean bConnection = false;
        ConnectivityManager connMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void ShowToastMessage(Context mContext, String xMessage) {
        Toast mToast = Toast.makeText(mContext, xMessage, Toast.LENGTH_SHORT);
//        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    public static void onCall(String number, Activity thiss) {
        Intent callIntent = new Intent(Intent.ACTION_CALL); //use ACTION_CALL class
        callIntent.setData(Uri.parse("tel:" + number));    //this is the phone number calling
        //check permission
        //If the device is running Android 6.0 (API level 23) and the app's targetSdkVersion is 23 or higher,
        //the system asks the user to grant approval.
        if (ActivityCompat.checkSelfPermission(thiss, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //request permission from user if the app hasn't got the required permission
            ActivityCompat.requestPermissions(thiss,
                    new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                    10);
            return;
        } else {     //have got permission
            try {
                thiss.startActivity(callIntent);  //call activity and make phone call
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(thiss, "yourActivity is not founded", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static MediaPlayer mediaPlayer;


    public static boolean checkPermissions(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }
    public static void getPermissions(Context context, Activity activity) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
//                            Manifest.permission.READ_SMS,
//                            Manifest.permission.RECEIVE_SMS,
//                            Manifest.permission.CAMERA,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.CALL_PHONE}, 456);
        }
    }

    public static MediaPlayer getSurah(Context context, String selectedSurahName) {
        MediaPlayer mPlayer2;
        switch (selectedSurahName) {
            case "s1":
                mPlayer2 = MediaPlayer.create(context, R.raw.s1);
                break;
            case "s2":
                mPlayer2 = MediaPlayer.create(context, R.raw.s2);
                break;
            case "s3":
                mPlayer2 = MediaPlayer.create(context, R.raw.s3);
                break;
            case "s4":
                mPlayer2 = MediaPlayer.create(context, R.raw.s4);
                break;
            case "s5":
                mPlayer2 = MediaPlayer.create(context, R.raw.s5);
                break;
            case "s6":
                mPlayer2 = MediaPlayer.create(context, R.raw.s6);
                break;
            case "s7":
                mPlayer2 = MediaPlayer.create(context, R.raw.s7);
                break;
            case "s8":
                mPlayer2 = MediaPlayer.create(context, R.raw.s8);
                break;
            case "s9":
                mPlayer2 = MediaPlayer.create(context, R.raw.s9);
                break;
            case "s10":
                mPlayer2 = MediaPlayer.create(context, R.raw.s10);
                break;
            case "s11":
                mPlayer2 = MediaPlayer.create(context, R.raw.s11);
                break;
            case "s12":
                mPlayer2 = MediaPlayer.create(context, R.raw.s12);
                break;
            case "s13":
                mPlayer2 = MediaPlayer.create(context, R.raw.s13);
                break;
            case "s14":
                mPlayer2 = MediaPlayer.create(context, R.raw.s14);
                break;
            case "s15":
                mPlayer2 = MediaPlayer.create(context, R.raw.s15);
                break;
            case "s16":
                mPlayer2 = MediaPlayer.create(context, R.raw.s16);
                break;
            case "s17":
                mPlayer2 = MediaPlayer.create(context, R.raw.s17);
                break;
            case "s18":
                mPlayer2 = MediaPlayer.create(context, R.raw.s18);
                break;
            case "s19":
                mPlayer2 = MediaPlayer.create(context, R.raw.s19);
                break;
            case "s20":
                mPlayer2 = MediaPlayer.create(context, R.raw.s20);
                break;
            case "s21":
                mPlayer2 = MediaPlayer.create(context, R.raw.s21);
                break;
            case "s22":
                mPlayer2 = MediaPlayer.create(context, R.raw.s22);
                break;
            case "s23":
                mPlayer2 = MediaPlayer.create(context, R.raw.s23);
                break;
            case "s24":
                mPlayer2 = MediaPlayer.create(context, R.raw.s24);
                break;
            case "s25":
                mPlayer2 = MediaPlayer.create(context, R.raw.s25);
                break;
            case "s26":
                mPlayer2 = MediaPlayer.create(context, R.raw.s26);
                break;
            case "s27":
                mPlayer2 = MediaPlayer.create(context, R.raw.s27);
                break;
            case "s28":
                mPlayer2 = MediaPlayer.create(context, R.raw.s28);
                break;
            case "s29":
                mPlayer2 = MediaPlayer.create(context, R.raw.s29);
                break;
            case "s30":
                mPlayer2 = MediaPlayer.create(context, R.raw.s30);
                break;
            case "s31":
                mPlayer2 = MediaPlayer.create(context, R.raw.s31);
                break;
            case "s32":
                mPlayer2 = MediaPlayer.create(context, R.raw.s32);
                break;
            case "s33":
                mPlayer2 = MediaPlayer.create(context, R.raw.s33);
                break;
            case "s34":
                mPlayer2 = MediaPlayer.create(context, R.raw.s34);
                break;
            case "s35":
                mPlayer2 = MediaPlayer.create(context, R.raw.s35);
                break;
            case "s36":
                mPlayer2 = MediaPlayer.create(context, R.raw.s36);
                break;
            case "s37":
                mPlayer2 = MediaPlayer.create(context, R.raw.s37);
                break;
            case "s38":
                mPlayer2 = MediaPlayer.create(context, R.raw.s38);
                break;
            case "s39":
                mPlayer2 = MediaPlayer.create(context, R.raw.s39);
                break;
            case "s40":
                mPlayer2 = MediaPlayer.create(context, R.raw.s40);
                break;
            case "s41":
                mPlayer2 = MediaPlayer.create(context, R.raw.s41);
                break;
            case "s42":
                mPlayer2 = MediaPlayer.create(context, R.raw.s42);
                break;
            case "s43":
                mPlayer2 = MediaPlayer.create(context, R.raw.s43);
                break;
            case "s44":
                mPlayer2 = MediaPlayer.create(context, R.raw.s44);
                break;
            case "s45":
                mPlayer2 = MediaPlayer.create(context, R.raw.s45);
                break;
            case "s46":
                mPlayer2 = MediaPlayer.create(context, R.raw.s46);
                break;
            case "s47":
                mPlayer2 = MediaPlayer.create(context, R.raw.s47);
                break;
            case "s48":
                mPlayer2 = MediaPlayer.create(context, R.raw.s48);
                break;
            case "s49":
                mPlayer2 = MediaPlayer.create(context, R.raw.s49);
                break;
            case "s50":
                mPlayer2 = MediaPlayer.create(context, R.raw.s50);
                break;
            case "s51":
                mPlayer2 = MediaPlayer.create(context, R.raw.s51);
                break;
            case "s52":
                mPlayer2 = MediaPlayer.create(context, R.raw.s52);
                break;
            case "s53":
                mPlayer2 = MediaPlayer.create(context, R.raw.s53);
                break;
            case "s54":
                mPlayer2 = MediaPlayer.create(context, R.raw.s54);
                break;
            case "s55":
                mPlayer2 = MediaPlayer.create(context, R.raw.s55);
                break;
            case "s56":
                mPlayer2 = MediaPlayer.create(context, R.raw.s56);
                break;
            case "s57":
                mPlayer2 = MediaPlayer.create(context, R.raw.s57);
                break;
            case "s58":
                mPlayer2 = MediaPlayer.create(context, R.raw.s58);
                break;
            case "s59":
                mPlayer2 = MediaPlayer.create(context, R.raw.s59);
                break;
            case "s60":
                mPlayer2 = MediaPlayer.create(context, R.raw.s60);
                break;
            case "s61":
                mPlayer2 = MediaPlayer.create(context, R.raw.s61);
                break;
            case "s62":
                mPlayer2 = MediaPlayer.create(context, R.raw.s62);
                break;
            case "s63":
                mPlayer2 = MediaPlayer.create(context, R.raw.s63);
                break;
            case "s64":
                mPlayer2 = MediaPlayer.create(context, R.raw.s64);
                break;
            case "s65":
                mPlayer2 = MediaPlayer.create(context, R.raw.s65);
                break;
            case "s66":
                mPlayer2 = MediaPlayer.create(context, R.raw.s66);
                break;
            case "s67":
                mPlayer2 = MediaPlayer.create(context, R.raw.s67);
                break;
            case "s68":
                mPlayer2 = MediaPlayer.create(context, R.raw.s68);
                break;
            case "s69":
                mPlayer2 = MediaPlayer.create(context, R.raw.s69);
                break;
            case "s70":
                mPlayer2 = MediaPlayer.create(context, R.raw.s70);
                break;
            case "s71":
                mPlayer2 = MediaPlayer.create(context, R.raw.s71);
                break;
            case "s72":
                mPlayer2 = MediaPlayer.create(context, R.raw.s72);
                break;
            case "s73":
                mPlayer2 = MediaPlayer.create(context, R.raw.s73);
                break;
            case "s74":
                mPlayer2 = MediaPlayer.create(context, R.raw.s74);
                break;
            case "s75":
                mPlayer2 = MediaPlayer.create(context, R.raw.s75);
                break;
            case "s76":
                mPlayer2 = MediaPlayer.create(context, R.raw.s76);
                break;
            case "s77":
                mPlayer2 = MediaPlayer.create(context, R.raw.s77);
                break;
            case "s78":
                mPlayer2 = MediaPlayer.create(context, R.raw.s78);
                break;
            case "s79":
                mPlayer2 = MediaPlayer.create(context, R.raw.s79);
                break;
            case "s80":
                mPlayer2 = MediaPlayer.create(context, R.raw.s80);
                break;
            case "s81":
                mPlayer2 = MediaPlayer.create(context, R.raw.s81);
                break;
            case "s82":
                mPlayer2 = MediaPlayer.create(context, R.raw.s82);
                break;
            case "s83":
                mPlayer2 = MediaPlayer.create(context, R.raw.s83);
                break;
            case "s84":
                mPlayer2 = MediaPlayer.create(context, R.raw.s84);
                break;
            case "s85":
                mPlayer2 = MediaPlayer.create(context, R.raw.s85);
                break;
            case "s86":
                mPlayer2 = MediaPlayer.create(context, R.raw.s86);
                break;
            case "s87":
                mPlayer2 = MediaPlayer.create(context, R.raw.s87);
                break;
            case "s88":
                mPlayer2 = MediaPlayer.create(context, R.raw.s88);
                break;
            case "s89":
                mPlayer2 = MediaPlayer.create(context, R.raw.s89);
                break;
            case "s90":
                mPlayer2 = MediaPlayer.create(context, R.raw.s90);
                break;
            case "s91":
                mPlayer2 = MediaPlayer.create(context, R.raw.s91);
                break;
            case "s92":
                mPlayer2 = MediaPlayer.create(context, R.raw.s92);
                break;
            case "s93":
                mPlayer2 = MediaPlayer.create(context, R.raw.s93);
                break;
            case "s94":
                mPlayer2 = MediaPlayer.create(context, R.raw.s94);
                break;
            case "s95":
                mPlayer2 = MediaPlayer.create(context, R.raw.s95);
                break;
            case "s96":
                mPlayer2 = MediaPlayer.create(context, R.raw.s96);
                break;
            case "s97":
                mPlayer2 = MediaPlayer.create(context, R.raw.s97);
                break;
            case "s98":
                mPlayer2 = MediaPlayer.create(context, R.raw.s98);
                break;
            case "s99":
                mPlayer2 = MediaPlayer.create(context, R.raw.s99);
                break;
            case "s100":
                mPlayer2 = MediaPlayer.create(context, R.raw.s100);
                break;
            case "s101":
                mPlayer2 = MediaPlayer.create(context, R.raw.s101);
                break;
            case "s102":
                mPlayer2 = MediaPlayer.create(context, R.raw.s102);
                break;
            case "s103":
                mPlayer2 = MediaPlayer.create(context, R.raw.s103);
                break;
            case "s104":
                mPlayer2 = MediaPlayer.create(context, R.raw.s104);
                break;
            case "s105":
                mPlayer2 = MediaPlayer.create(context, R.raw.s105);
                break;
            case "s106":
                mPlayer2 = MediaPlayer.create(context, R.raw.s106);
                break;
            case "s107":
                mPlayer2 = MediaPlayer.create(context, R.raw.s107);
                break;
            case "s108":
                mPlayer2 = MediaPlayer.create(context, R.raw.s108);
                break;
            case "s109":
                mPlayer2 = MediaPlayer.create(context, R.raw.s109);
                break;
            case "s110":
                mPlayer2 = MediaPlayer.create(context, R.raw.s110);
                break;
            case "s111":
                mPlayer2 = MediaPlayer.create(context, R.raw.s111);
                break;
            case "s112":
                mPlayer2 = MediaPlayer.create(context, R.raw.s112);
                break;
            case "s113":
                mPlayer2 = MediaPlayer.create(context, R.raw.s113);
                break;
            case "s114":
                mPlayer2 = MediaPlayer.create(context, R.raw.s114);
                break;
            default:
                mPlayer2 = MediaPlayer.create(context, R.raw.s1);
                break;
        }
        return mPlayer2;
    }

    public static String getSurahRomanTitles(int i) {
        String[] romanTitles = {"Al-Fatihah", "Al-Baqarah", "Al-'Imran", "An-Nisa'", "Al-Ma'idah", "Al-An'am", "Al-A'raf", "Al-Anfal",
                "Al-Bara'at / At-Taubah", "Yunus", "Hud", "Yusuf", "Ar-Ra'd", "Ibrahim", "Al-Hijr", "An-Nahl", "al-Isra'", "Al-Kahf",
                "Maryam", "Ta Ha", "Al-Anbiya'", "Al-Hajj", "Al-Mu'minun", "An-Nur", "Al-Furqan", "Ash-Shu'ara'", "An-Naml", "Al-Qasas", "Al-'Ankabut",
                "Ar-Rum", "Luqman", "As-Sajdah", "Al-Ahzab", "Al-Saba'", "Al-Fatir / Al-Mala'ikah", "Ya Sin", "As-Saffat", "Sad", "Az-Zumar",
                "Al-Ghafir / Al-Mu'min", "Ha Mim / Fussilat",
                "Ash-Shura", "Az-Zukhruf", "Ad-Dukhan", "Al-Jathiyah", "Al-Ahqaf", "Muhammad", "Al-Fath", "Al-Hujurat", "Qaf", "Ad-Dhariyat",
                "At-Tur", "An-Najm", "Al-Qamar", "Ar-Rahman", "Al-Waqi'ah", "Al-Hadid", "Al-Mujadilah", "Al-Hashr", "Al-Mumtahanah",
                "As-Saff", "Al-Jumu'ah", "Al-Munafiqun", "At-Taghabun", "At-Talaq", "At-Tahrim", "Al-Mulk", "Al-Qalam", "Al-Haqqah",
                "Al-Ma'arij", "Nuh", "Al-Jinn", "Al-Muzzammil", "Al-Muddaththir", "Al-Qiyamah", "Al-Insan / Ad-Dahr", "Al-Mursalat",
                "An-Naba'", "An-Nazi'at", "'Abasa", "At-Takwir", "Al-Infitar", "Al-Mutaffifin", "Al-Inshiqaq", "Al-Buruj", "At-Tariq",
                "Al-A'la", "Al-Ghashiyah", "Al-Fajr", "Al-Balad", "Ash-Shams", "Al-Lail", "Ad-Duha", "Al-Inshirah", "At-Tin", "Al-'Alaq", "Al-Qadr",
                "Al-Bayyinah", "Al-Zilzal", "Al-'Adiyat", "Al-Qari'ah", "At-Takathur", "Al-'Asr", "Al-Humazah", "Al-Fil", "Al-Quraish", "Al-Ma'un",
                "Al-Kauthar", "Al-Kafirun", "An-Nasr", "Al-Masad / Al-Lahab", "Al-Ikhlas / At-Tawhid", "Al-Falaq", "An-Nas"};
        return romanTitles[i];
    }

    public static String getSurahArabicTitles(int i) {
        String[] arabicTitles = {"الْفَاتِحَة", "البَقَرة", "آل عِمران", "النِّســاء", "المَـائِدة", "الأنْعـام", "الأعراف", "الأنْفـال", "التـَّوْبَة",
                "يُونُس", "هُود", "يُوسُف", "الرَّعد", "اِبراهيم", "الحِجْر", "النًّحل", "الاِسْرآء", "الكَهْف", "مَريَم", "طه", "الأنْبيآء", "الحَجّ",
                "المؤمِنون", "النّور", "الفُرقان", "الشُّـعَراء", "النَّـمْل", "القَصَص", "العَنْـكَبُوت", "الرُّوم", "لُقْمان", "السَّـجْدة", "الأحزاب",
                "ســَبَأ'", "فاطِر (المَلائِكة)", "يــس", "الصّــافّات", "ص", "الزُّمَر", "المُؤْمِن", "فُصِّلَت", "الشُّوری", "الزُّخْرُف", "الدُّخان",
                "الجاثِية", "الأحقاف", "مُحَمّد (ص)", "الفَتْح", "الحُجُرات", "ق", "الذ ّارِيات", "الطُّور", "النَّجْم", "القَمَر", "الرَّحمن", "الواقِعَة",
                "الحَديد", "المُجادَلة", "الحَشْر", "المُمتَحَنة", "الصَّف", "الجُّمُعة", "المُنافِقُون", "التَّغابُن", "الطَّلاق", "التَّحْريم", "المُلْك",
                "القَلـََم", "الحَاقّـَة", "المَعارِج", "نُوح", "الجِنّ", "المُزَّمّـِل", "المُدَّثــِّر", "القِيامَة", "الدَّهر (الإنسان)", "المُرسَلات", "النـَّبأ'",
                "النـّازِعات", "عَبَس", "التـَّكْوير", "الإنفِطار", "المُطـَفِّفين", "الإنشِقاق", "البُروج", "الطّارق", "الأعلی", "الغاشِيَة", "الفَجْر",
                "البَـلـَد", "الشــَّمْس", "اللـَّيل", "الضُّحی", "الإنشـِراح", "التـِّين", "العَلـَق", "القـَدر", "البَيِّنَة", "الزِّلزال", "العـَاديات",
                "القارِعَة", "التَكاثـُر", "العَصْر", "الهُمَزَة", "الفيل", "قـُرَيْش", "الماعُون", "الكـَوْثَر", "الكافِرون", "النـَّصر", "تَبَّت",
                "الإخـْلاص (التـَّوحيد)", "الفـَلَق", "النـَّاس"};
        return arabicTitles[i];
    }

    public static String getSurahEnglishTitles(int i) {
        String[] englishTitles = {
                "The Opening",
                "The Cow",
                "The Family of Imran",
                "The Women",
                "The Table",
                "The Cattle",
                "The Heights",
                "The Spoils of War",
                "The Repentance",
                "Yunus",
                "Hud",
                "Yusuf",
                "The Thunder",
                "Ibrahim",
                "The Rocky Tract",
                "The Bees",
                "The Night Journey",
                "The Cave",
                "Maryam",
                "Ta Ha",
                "The Prophets'",
                "The Pilgrimage",
                "The Believers",
                "The Light",
                "The Criterion",
                "The Poets",
                "The Ants",
                "The Stories",
                "The Spider",
                "The Romans",
                "Luqman",
                "The Prostration",
                "The Combined Forces",
                "The Sabeans",
                "The Originator / The Angels",
                "Ya Sin",
                "Those Ranges in Ranks",
                "Ṣād",
                "The Groups",
                "The Forgiver",
                "Distinguished",
                "The Consultation",
                "The Gold",
                "The Smoke",
                "The Kneeling",
                "The Winding Sand Tracks",
                "Muhammad",
                "The Victory",
                "The Dwellings",
                "Qaf",
                "The Scatterers",
                "The Mount",
                "The Star",
                "The Moon",
                "The Most Gracious",
                "The Event",
                "The Iron",
                "The Pleading",
                "The Gathering",
                "The Tested",
                "The Ranks",
                "Friday / The Day of Congregation",
                "The Hypocrites",
                "The Loss & Gain",
                "Divorce",
                "The Prohibition",
                "The Kingdom",
                "The Pen",
                "The Inevitable Truth",
                "The Elevated Passages",
                "Nuh",
                "The Jinn",
                "The Enwrapped One",
                "The Cloaked One",
                "Resurrection",
                "The Human/ The Time",
                "Those Sent Forth",
                "The Great News",
                "Those Who Pull Out",
                "He Frowned",
                "The Overthrowing",
                "The Cleaving",
                "Those Who Deal in Fraud",
                "The Splitting Asunder",
                "The Stars",
                "The Nightcomer",
                "The Most High",
                "The Overwhelming",
                "The Dawn",
                "The City",
                "The Sun",
                "The Night",
                "The Forenoon",
                "The Opening Forth",
                "The Fig",
                "The Clot",
                "The Night of Decree",
                "The Proof",
                "The Earthquake",
                "The Runners",
                "The Striking Hour",
                "The Piling Up",
                "The Time",
                "The Slanderer",
                "The Elephant",
                "Quraish",
                "The Assistance",
                "The River of Abundance",
                "The Disbelievers",
                "The Help",
                "The Palm Fiber",
                "The Sincerity",
                "The Daybreak",
                "Mankind"
        };
        return englishTitles[i];
    }

    public static int getSurahNumber(int i) {
        int[] Number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
                101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114};
        return Number[i];
    }

    public static String getParaRomanTitles(int i) {
        String[] romanTitles = {"Alif Lam Meem", "Sayaqool", "Tilkal Rusull", "Lan Tana Loo", "Wal Mohsanat",
                "La Yuhibbullah", "Wa Iza Samiu", "Wa Lau Annana", "Qalal Malao", "Wa A'lamu",
                "Yatazeroon", "Wa Mamin Da'abat", "Wa Ma Ubrioo", "Rubama", "Subhanallazi",
                "Qal Alam", "Aqtarabo", "Qadd Aflaha", "Wa Qalallazina", "A'man Khalaq",
                "Utlu Ma Oohi", "Wa Manyaqnut", "Wa Mali", "Faman Azlam", "Elahe Yuruddo",
                "Ha'a Meem", "Qala Fama Khatbukum", "Qadd Sami Allah", "Tabarakallazi", "Amma Yatasa'aloon"};
        return romanTitles[i];
    }

    public static String getParaArabicTitles(int i) {
        String[] arabicTitles = {"الم", "سَيَقُولُ", "تِلْكَ الرُّسُل", "لَنْ تَنَالُوا", "وَالْمُحْصَنَاتُ",
                "لَا يُحِبُّ اللَّهُ", "وَإِذَا سَمِعُوا", "وَلَوْ أَنَّنَا", "قَالَ الْمَلَأُ", "وَاعْلَمُوا",
                "يَعْتَذِرُونَ", "وَمَا مِنْ دَابَّةٍ", "وَمَا أُبَرِّئُ", "رُبَمَا", "سُبْحَانَ الَّذِي",
                "قَالَ أَلَمْ", "اقْتَرَبَ", "قَدْ أَفْلَحَ", "وَقَالَ الَّذِينَ", "أَمَّنْ خَلَقَ",
                "اتْلُ مَا أُوحِيَ", "وَمَنْ يَقْنُتْ", "وَمَا لِيَ", "فَمَنْ أَظْلَمُ", "إِلَيْهِ يُرَدُّ",
                "حم", "قَالَ فَمَا خَطْبُكُمْ", "قَدْ سَمِعَ اللَّهُ", "تَبَارَكَ الَّذِي", "عَمَّ يَتَسَاءَلُونَ"};
        return arabicTitles[i];
    }

    public static String getParaNumber(int i) {
        String[] Number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        return Number[i];
    }

    public static void shareAddress(CharSequence str_data_address, Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, str_data_address);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

}