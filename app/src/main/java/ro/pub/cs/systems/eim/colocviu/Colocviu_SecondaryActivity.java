package ro.pub.cs.systems.eim.colocviu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Colocviu_SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu__secondary);
        String text = getIntent().getStringExtra("text");
        TextView instructions = findViewById(R.id.textViewSecondary);
        instructions.setText(text);
        Toast.makeText(getApplicationContext(), "Length", Toast.LENGTH_SHORT);
    }

    public void register(View view) {
        Intent intent = new Intent(Colocviu_SecondaryActivity.this, ColocviuMainActivity.class);
//        Toast.makeText(getApplicationContext(), "register", Toast.LENGTH_SHORT).show();
        intent.putExtra("rezultat", "register");
        Colocviu_SecondaryActivity.this.startActivity(intent);
    }

    public void cancel(View view) {
        Intent intent = new Intent(Colocviu_SecondaryActivity.this, ColocviuMainActivity.class);
//        Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
        intent.putExtra("rezultat", "cancel");
        Colocviu_SecondaryActivity.this.startActivity(intent);
    }
}
