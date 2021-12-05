package id.ac.umn.guppyku;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagnosaActivity extends AppCompatActivity {

    boolean isChoosing = true;
    float countA, countB, countC, countD, countE, countF;

    TextView tvNamaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);

        tvNamaUser = findViewById(R.id.tvNamaUser);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();

            tvNamaUser.setText(name);

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();

            getSupportActionBar().hide();
        }


        final Button submit=findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView=inflater.inflate(R.layout.popup_window, null);

                int width= LinearLayout.LayoutParams.WRAP_CONTENT;
                int height=LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable=true;
                final PopupWindow popupWindow=new PopupWindow(popupView, width, height, focusable);

                popupWindow.showAtLocation(view, Gravity.CENTER, 0,0);

//                isChoosing = false;
                float probA, probB, probC, probD, probE, probF;
                probA = (countA/3) * 100;
                probB = (countB/3) * 100;
                probC = (countC/3) * 100;
                probD = (countD/4) * 100;
                probE = (countE/6) * 100;
                probF = (countF/2) * 100;

                String solusiA, solusiB, solusiC, solusiD, solusiE, solusiF, solusiAkhir;
                solusiA="- masukkan guppy ke air dalam wadah terpisah yang sudah diberi garam ikan.\n" +
                        "- beri ikan guppy , obat anti whitespot dalam dosis yang disarankan.\n" +
                        "- jaga kestabilan suhu dan ph air.\n" +
                        "- sedot kotoran dan lakukan pergantian air apabila sudah terlihat kotor.\n" +
                        "- lakukan tahap ini selama 5-7 hari.\n" +
                        "- ganti air wadah secara keseluruhan setelah ikan terbebas dari penyakit.";
                solusiB="- masukkan guppy ke air dalam wadah terpisah yang sudah diberi garam ikan.\n" +
                        "- beri ikan guppy , obat anti whitespot dalam dosis yang disarankan.\n" +
                        "- jaga kestabilan suhu dan ph air.\n" +
                        "- sedot kotoran dan lakukan pergantian air apabila sudah terlihat kotor.\n" +
                        "- lakukan tahap ini selama 5-7 hari.\n" +
                        "- ganti air wadah secara keseluruhan setelah ikan terbebas dari penyakit.";
                solusiC="- masukkan guppy ke air dalam wadah terpisah yang sudah diberi garam ikan.\n" +
                        "- beri ikan guppy , obat anti whitespot dalam dosis yang disarankan.\n" +
                        "- jaga kestabilan suhu dan ph air.\n" +
                        "- sedot kotoran dan lakukan pergantian air apabila sudah terlihat kotor.\n" +
                        "- lakukan tahap ini selama 5-7 hari.\n" +
                        "- ganti air wadah secara keseluruhan setelah ikan terbebas dari penyakit.";
                solusiD="- masukkan guppy ke air dalam wadah terpisah yang sudah diberi garam ikan.\n" +
                        "- beri ikan guppy , obat anti whitespot dalam dosis yang disarankan.\n" +
                        "- jaga kestabilan suhu dan ph air.\n" +
                        "- sedot kotoran dan lakukan pergantian air apabila sudah terlihat kotor.\n" +
                        "- lakukan tahap ini selama 5-7 hari.\n" +
                        "- ganti air wadah secara keseluruhan setelah ikan terbebas dari penyakit.";
                solusiE="- masukkan guppy ke air dalam wadah terpisah yang sudah diberi garam ikan.\n" +
                        "- beri ikan guppy , obat anti whitespot dalam dosis yang disarankan.\n" +
                        "- jaga kestabilan suhu dan ph air.\n" +
                        "- sedot kotoran dan lakukan pergantian air apabila sudah terlihat kotor.\n" +
                        "- lakukan tahap ini selama 5-7 hari.\n" +
                        "- ganti air wadah secara keseluruhan setelah ikan terbebas dari penyakit.";
                solusiF="- masukkan guppy ke air dalam wadah terpisah yang sudah diberi garam ikan.\n" +
                        "- beri ikan guppy , obat anti whitespot dalam dosis yang disarankan.\n" +
                        "- jaga kestabilan suhu dan ph air.\n" +
                        "- sedot kotoran dan lakukan pergantian air apabila sudah terlihat kotor.\n" +
                        "- lakukan tahap ini selama 5-7 hari.\n" +
                        "- ganti air wadah secara keseluruhan setelah ikan terbebas dari penyakit.";
                solusiAkhir="";

                if (probA > probB && probA>probC && probA>probD && probA>probE && probA>probF){
                    solusiAkhir=solusiA;
                }
                if (probB > probA && probB>probC && probB>probD && probB>probE && probB>probF){
                    solusiAkhir=solusiB;
                }
                if (probC > probA && probC>probB && probC>probD && probC>probE && probC>probF){
                    solusiAkhir=solusiC;
                }
                if (probD > probA && probD>probB && probD>probC && probD>probE && probD>probF){
                    solusiAkhir=solusiD;
                }
                if (probE > probA && probE>probB && probE>probC && probE>probD && probE>probF){
                    solusiAkhir=solusiE;
                }
                if (probF > probA && probF>probB && probF>probC && probF>probD && probF>probE){
                    solusiAkhir=solusiF;
                }

                TextView tvResults=(TextView) popupView.findViewById(R.id.tvResults);

                tvResults.setText("White Spots = "+probA+"\n"+
                        "Velvet = "+probB+"\n"+
                        "Fin Rot = "+probC+"\n"+
                        "Columnaris dan Jamur Mulut = "+probD+"\n"+
                        "Dropsy = "+probE+"\n"+
                        "Insang Bengkak dan Terengah = "+probF+"\n"+
                        "Solusi Penyakit:\n"+solusiAkhir);

                List<Float> probabilities = new ArrayList<>();
                probabilities.add(probA);
                probabilities.add(probB);
                probabilities.add(probC);
                probabilities.add(probD);
                probabilities.add(probE);
                probabilities.add(probF);

                Collections.sort(probabilities, Collections.reverseOrder());

                float result = probabilities.get(0);
                String finalSickness = "";
//                System.out.println(result);
                if (result == probA){
                    finalSickness = "White Spots";
                }else if(result == probB){
                    finalSickness = "Velvet";
                }else if(result == probC){
                    finalSickness = "Fin Rot";
                }else if(result == probD){
                    finalSickness = "Columnaris dan Jamur Mulut";
                }else if(result == probE){
                    finalSickness = "Dropsy";
                }else if(result == probF){
                    finalSickness = "Insang Bengkak dan Terengah";
                }else{
                    finalSickness = "Not Found";
                }
                System.out.println("Penyakit GuppyMu: "+finalSickness);
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();


//        while(isChoosing) {
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_bintik_putih:
                if (checked) {
                    System.out.println("Bintik Putih Checked");
                    countA = countA + 1;
                    countB = countB + 1;
                    countD = countD + 1;
                }
                else{
                    countA = countA - 1;
                    countB = countB - 1;
                    countD = countD - 1;
                }
                break;
            case R.id.checkbox_nafsu_makan:
                if (checked) {
                    System.out.println("Nafsu Makan Checked");
                    countA = countA + 1;
                    countD = countD + 1;
                }
                else{
                    countA = countA - 1;
                    countD = countD - 1;
                }
                break;
            case R.id.checkbox_mengelupas:
                if (checked) {
                    System.out.println("Mengelupas Checked");
                    countB = countB + 1;
                }
                else{
                    countB = countB - 1;
                }
                break;
            case R.id.checkbox_menggosokan_kulit:
                if (checked) {
                    System.out.println("Menggosokan Kulit Checked");
                    countA = countA + 1;
                }
                else{
                    countA = countA - 1;
                }
                break;
            case R.id.checkbox_berdarah:
                if (checked) {
                    System.out.println("Berdarah Checked");
                    countB = countB + 1;
                }
                else{
                    countB = countB - 1;
                }
                break;
            case R.id.checkbox_infeksi:
                if (checked) {
                    System.out.println("Infeksi/Jamuran Checked");
                    countC = countC + 1;
                    countD = countD + 1;
                    countE = countE + 1;
                }
                else{
                    countC = countC - 1;
                    countD = countD - 1;
                    countE = countE - 1;
                }
                break;
            case R.id.checkbox_menempel:
                if (checked) {
                    System.out.println("Sirip atau Ekor Menempel Checked");
                    countC = countC + 1;
                }
                else{
                    countC = countC - 1;
                }
                break;
            case R.id.checkbox_bintik_merah:
                if (checked)
                    System.out.println("Bintik Merah Checked");
                break;
            case R.id.checkbox_rusak:
                if (checked){
                    System.out.println("Sirip atau Ekor Rusak Checked");
                    countC = countC + 1;
                }
                else{
                    countC = countC - 1;
                }
                break;
            case R.id.checkbox_kesulitan_berenang:
                if (checked) {
                    System.out.println("Kesulitan Berenang Checked");
                    countD = countD + 1;
                    countE = countE + 1;
                }
                else{
                    countD = countD - 1;
                    countE = countE - 1;
                }
                break;
            case R.id.checkbox_bengkak:
                if (checked) {
                    System.out.println("Bengkak Checked");
                    countE = countE + 1;
                    countF = countF + 1;
                }
                else{
                    countE = countE - 1;
                    countF = countF - 1;
                }
                break;
            case R.id.checkbox_warna:
                if (checked) {
                    System.out.println("Berubah Warna Checked");
                    countE = countE + 1;
                }
                else{
                    countE = countE - 1;
                }
                break;
            case R.id.checkbox_terdistorsi:
                if (checked){
                    System.out.println("Bentuk Badan Terdistorsi Checked");
                    countE = countE + 1;
                }
                else{
                    countE = countE - 1;
                }
                break;
            case R.id.checkbox_sisik_menonjol:
                if (checked) {
                    System.out.println("Sisik Menonjol Checked");
                    countE = countE + 1;
                }
                else{
                    countE = countE - 1;
                }
                break;
            case R.id.checkbox_terengah:
                if (checked) {
                    System.out.println("Terengah-engah di Permukaan Checked");
                    countF = countF + 1;
                }
                else{
                    countF = countF - 1;
                }
                break;
        }
//        }
    }
}