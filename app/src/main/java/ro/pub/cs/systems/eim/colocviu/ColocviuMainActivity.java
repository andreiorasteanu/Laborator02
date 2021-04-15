package ro.pub.cs.systems.eim.colocviu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ColocviuMainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int nrButoane = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private final String key = "savedNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.buttonNorth);
        button.setOnClickListener(buttonClickListener);
        button = findViewById(R.id.buttonWest);
        button.setOnClickListener(buttonClickListener);
        button = findViewById(R.id.buttonEast);
        button.setOnClickListener(buttonClickListener);
        button = findViewById(R.id.buttonSouth);
        button.setOnClickListener(buttonClickListener);
//        if(savedInstanceState.containsKey(key)){
//            int no = savedInstanceState.getInt(key, 0);
//            Toast.makeText(getApplicationContext(), "Saved number of clicks: " + nrButoane , Toast.LENGTH_SHORT).show();
//        }
        String rezultat = getIntent().getStringExtra("rezultat");
        if(rezultat != null && !rezultat.equals("")){
            Toast.makeText(getApplicationContext(), "Am revenit cu butonul " + rezultat, Toast.LENGTH_SHORT).show();
        }
    }

    public void gotosecond(View view) {
        Intent intent = new Intent(ColocviuMainActivity.this, Colocviu_SecondaryActivity.class);

        intent.putExtra("text", textView.getText().toString());
        nrButoane = 0;
        textView.setText("");
        ColocviuMainActivity.this.startActivity(intent);
    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(nrButoane == 0) {
                textView.append(((Button) v).getText().toString());
            }
            else {
                textView.append(", " + ((Button) v).getText().toString());
            }
            nrButoane++;
            Toast.makeText(getApplicationContext(), "Am apasat :" +  nrButoane, Toast.LENGTH_SHORT).show();
        }
    }

//    public void onSaveInstanceState(Bundle savedInstanceState){
//        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putString(key, String.valueOf(nrButoane));
//    }
//    public void onRestoreInstanceState(Bundle savedInstanceState){
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState.containsKey(key)) {
//            nrButoane = savedInstanceState.getInt(key);
//        }
//    }
}
