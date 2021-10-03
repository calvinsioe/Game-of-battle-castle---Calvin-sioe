package com.example.binusuas.MainApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.binusuas.MainApp.Models.Player;
import com.example.binusuas.R;

public class MainActivity extends AppCompatActivity {

    TextView txtMatch1StatusPlayer1, txtMatch1StatusPlayer2, txtMatch1InfoPlayer1,
            txtMatch1InfoPlayer2, txtMatch2StatusPlayer1, txtMatch2StatusPlayer2,
            txtMatch2InfoPlayer1, txtMatch2InfoPlayer2;
    Button btnFight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMatch1InfoPlayer1 = findViewById(R.id.txt_match1_info_player1);
        txtMatch1InfoPlayer2 = findViewById(R.id.txt_match1_info_player2);
        txtMatch1StatusPlayer1 = findViewById(R.id.txt_match1_status_player1);
        txtMatch1StatusPlayer2 = findViewById(R.id.txt_match1_status_player2);

        txtMatch2InfoPlayer1 = findViewById(R.id.txt_match2_info_player1);
        txtMatch2InfoPlayer2 = findViewById(R.id.txt_match2_info_player2);
        txtMatch2StatusPlayer1 = findViewById(R.id.txt_match2_status_player1);
        txtMatch2StatusPlayer2 = findViewById(R.id.txt_match2_status_player2);

        btnFight = findViewById(R.id.btn_match);
        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match1();
                match2();
            }
        });

    }

    public void match1() {
        // player 1
        Player player1 = new Player(0, 100000, 0, 0, "Horse Castle");
        // heroes player 1
        player1.addCavalries(50);
        player1.addCavalries(50);
        player1.addCavalries(50);
        player1.addCavalries(50);
        player1.addCavalries(50);
        // set power
        player1.setPower();

        // player 2
        Player player2 = new Player(0, 0, 100000, 0, "Wood Castle");
        // heroes player 2
        player2.addArchers(50);
        player2.addArchers(50);
        player2.addArchers(50);
        player2.addArchers(50);
        player2.addArchers(50);
        // set power
        player2.setPower();

        player1.setDead(player2.getCavalryPower(), player2.getArcherPower(), player2.getInfantryPower());
        player2.setDead(player1.getCavalryPower(), player1.getArcherPower(), player1.getInfantryPower());

        txtMatch1InfoPlayer1.setText("Power\n" +
                "Infantry: " + player1.getInfantryPower()+
                "\nCavalry: "+player1.getCavalryPower()+
                "\nCatapult: "+player1.getCatapultPower()+
                "\nArcher: "+player1.getArcherPower()+
                "\nDead\n"+
                "Infantry: "+player1.getDeadInfantry()+
                "\nCavalry: "+player1.getDeadCavalry()+
                "\nCatapult: "+0+
                "\nArcher: "+player1.getDeadArcher());
        txtMatch1InfoPlayer2.setText("Power\n" +
                "Infantry: " + player2.getInfantryPower()+
                "\nCavalry: "+player2.getCavalryPower()+
                "\nCatapult: "+player2.getCatapultPower()+
                "\nArcher: "+player2.getArcherPower()+
                "\nDead\n"+
                "Infantry: "+player2.getDeadInfantry()+
                "\nCavalry: "+player2.getDeadCavalry()+
                "\nCatapult: "+0+
                "\nArcher: "+player2.getDeadArcher());

        if (player1.getDeadArcher()+player1.getDeadCavalry()+player1.getDeadInfantry() < player2.getDeadCavalry()+player2.getDeadInfantry()+player2.getDeadArcher()){
            txtMatch1StatusPlayer1.setText("Win");
            txtMatch1StatusPlayer2.setText("Lose");
        } else if(player1.getDeadArcher()+player1.getDeadCavalry()+player1.getDeadInfantry() > player2.getDeadCavalry()+player2.getDeadInfantry()+player2.getDeadArcher()){
            txtMatch1StatusPlayer1.setText("Lose");
            txtMatch1StatusPlayer2.setText("Win");
        }else{
            txtMatch1StatusPlayer1.setText("Draw");
            txtMatch1StatusPlayer2.setText("Draw");
        }

    }


    public void match2(){
        // player 1
        Player player1 = new Player(25000,25000,25000,25000,"Stone Castle");
        // heroes player 1
        player1.addCavalries(50);
        player1.addCavalries(50);
        player1.addCavalries(50);
        player1.addCavalries(50);
        player1.addCavalries(50);
        // set power
        player1.setPower();

        // player 2
        Player player2 = new Player(100000,0,0,0,"Steel Castle");
        // heroes player 2
        player2.addInfantries(50);
        player2.addInfantries(50);
        player2.addInfantries(50);
        player2.addInfantries(50);
        player2.addInfantries(50);
        // set power
        player2.setPower();

        player1.setDead(player2.getCavalryPower(), player2.getArcherPower(), player2.getInfantryPower());
        player2.setDead(player1.getCavalryPower(), player1.getArcherPower(), player1.getInfantryPower());

        txtMatch2InfoPlayer1.setText("Power\n" +
                "Infantry: " + player1.getInfantryPower()+
                "\nCavalry: "+player1.getCavalryPower()+
                "\nCatapult: "+player1.getCatapultPower()+
                "\nArcher: "+player1.getArcherPower()+
                "\nDead\n"+
                "Infantry: "+player1.getDeadInfantry()+
                "\nCavalry: "+player1.getDeadCavalry()+
                "\nCatapult: "+0+
                "\nArcher: "+player1.getDeadArcher());
        txtMatch2InfoPlayer2.setText("Power\n" +
                "Infantry: " + player2.getInfantryPower()+
                "\nCavalry: "+player2.getCavalryPower()+
                "\nCatapult: "+player2.getCatapultPower()+
                "\nArcher: "+player2.getArcherPower()+
                "\nDead\n"+
                "Infantry: "+player2.getDeadInfantry()+
                "\nCavalry: "+player2.getDeadCavalry()+
                "\nCatapult: "+0+
                "\nArcher: "+player2.getDeadArcher());

        if (player1.getDeadArcher()+player1.getDeadCavalry()+player1.getDeadInfantry() < player2.getDeadCavalry()+player2.getDeadInfantry()+player2.getDeadArcher()){
            txtMatch2StatusPlayer1.setText("Win");
            txtMatch2StatusPlayer2.setText("Lose");
        } else if(player1.getDeadArcher()+player1.getDeadCavalry()+player1.getDeadInfantry() > player2.getDeadCavalry()+player2.getDeadInfantry()+player2.getDeadArcher()){
            txtMatch2StatusPlayer1.setText("Lose");
            txtMatch2StatusPlayer2.setText("Win");
        }else{
            txtMatch2StatusPlayer1.setText("Draw");
            txtMatch2StatusPlayer2.setText("Draw");
        }

    }

}
