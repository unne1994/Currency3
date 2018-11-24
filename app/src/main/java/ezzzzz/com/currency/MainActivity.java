package ezzzzz.com.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  EditText price;
    private  Button Go;
    Money M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        price = findViewById(R.id.ntd);
        Go = findViewById(R.id.btn_go);
        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                M = new Money();
                if ("".equals(price.getText().toString().trim())){
                    AlertDialog("Problem",
                                "Plese enter you NTD amount",
                                "OK");
                }else {
                    M.setPric(Double.parseDouble(price.getText().toString().trim()));
                    AlertDialog("Result","USD is " + String.valueOf(M.ConvertUS()),"OK");
                }
            }
        });
    }
    public void AlertDialog(String Title , String Message ,String Positive ) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle(Title);
        dialog.setMessage(Message);
        dialog.setPositiveButton(Positive, null).show();
    }
}
