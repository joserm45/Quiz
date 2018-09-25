package com.example.joserm45.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private PreguntaTest pregunta;
    private RadioGroup respostesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        generarPregunta();
        TextView textView = findViewById(R.id.textView);
        respostesView = findViewById(R.id.respostesView);
        RadioButton button_resp0 = findViewById(R.id.button_resp0);
        RadioButton button_resp1 = findViewById(R.id.button_resp1);
        RadioButton button_resp2 = findViewById(R.id.button_resp2);
        RadioButton button_resp3 = findViewById(R.id.button_resp3);

        textView.setText(pregunta.getText());
        button_resp0.setText(pregunta.getRespostes()[0]);
        button_resp1.setText(pregunta.getRespostes()[1]);
        button_resp2.setText(pregunta.getRespostes()[2]);
        button_resp3.setText(pregunta.getRespostes()[3]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_comprova:
                comprovaResposta();

                break;
            case R.id.menu_reset:
                respostesView.clearCheck();
                break;
        }
        return true;
    }

    private void comprovaResposta() {
        int index = getIndex();
        if(index == pregunta.getCorrecta()){
            Toast.makeText(this,"Molt bé!!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Looser",Toast.LENGTH_SHORT).show();
        }
    }

    private int getIndex() {
        int index = -1;
        int selected = respostesView.getCheckedRadioButtonId();
        int ids[] = {R.id.button_resp0, R.id.button_resp1, R.id.button_resp2, R.id.button_resp3};
        for (int i=0;i< ids.length; i++) {
            if(ids[i] == selected){
                index = i;
                break;
            }
        }
        return index;
    }

    private void generarPregunta() {
        String[] respostes = new String[4];
        respostes[0] = "Barcelona";
        respostes[1] = "Paris";
        respostes[2] = "Londres";
        respostes[3] = "Hanoi";
        pregunta = new PreguntaTest("Quina és la capital de Vietnam?",respostes,3);
    }
}
