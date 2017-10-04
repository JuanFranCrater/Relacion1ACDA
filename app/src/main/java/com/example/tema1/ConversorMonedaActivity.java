package com.example.tema1;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.Toast;

/**
 * Esta clase realiza el cambio de divisas de euros a dolares y viceversa
 * @author JuanFran
 */
public class ConversorMonedaActivity extends AppCompatActivity implements View.OnClickListener {

    //Instanciamos los objetos de editText, un radio button(para comprobar el tipo de cambio) y el boton (para el metodo onClick)
    Button boton;
    RadioButton rboton;
    EditText edText;
    EditText edText2;
    EditText edtCambio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_moneda);
        //Asignamos el boton del layout a la variable 'boton' y le asignamos el setOnClickListener
        boton =(Button) findViewById(R.id.botonConvertir);
        boton.setOnClickListener(this);

    }

     /*Metodo onClick que se llama al hacer click al boton asignado
    * Obtiene los valores de los PlainText y llama a los metodos de CambioA...
    */

    @Override
    public void onClick(View view) {
        //En este caso usaremos el boton de Euros a Dolares para comprobar el tipo de cambio
        rboton=(RadioButton) findViewById(R.id.rbEaD);
        if (rboton.isChecked())//Comprobamos si esta check, en caso contrario, haria el caso contrario
        {
            //guarda el valor del objeto plainText necesario
            edText = (EditText) findViewById(R.id.etDolar);
            edText2 = (EditText) findViewById(R.id.etEuro);
            //guardamos el valor del cambio
            edtCambio = (EditText)findViewById(R.id.edtCambio);
            try {
                //dentro del try, hace la llamada a los metodos convertirADolares/convertirAEuros y asigna en el momento el valor al plainText necesario
                edText.setText(convertirADolares(edText2.getText().toString(),edtCambio.getText().toString()));
            }catch (Exception e)
            {
                Toast.makeText(this,"Error al introducir € o el cambio no es valido", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            //guarda el valor del objeto plainText necesario
            edText = (EditText) findViewById(R.id.etEuro);
            edText2 = (EditText) findViewById(R.id.etDolar);
            //guardamos el valor del cambio
            edtCambio = (EditText)findViewById(R.id.edtCambio);
            try {
                //dentro del try, hace la llamada a los metodos convertirADolares/convertirAEuros y asigna en el momento el valor al plainText necesario

                edText.setText(convertirAEuros(String.format(edText2.getText().toString()),edtCambio.getText().toString()));
            }catch (Exception e){
                Toast.makeText(this,"Error al introducir $ o el cambio no es valido", Toast.LENGTH_SHORT).show();

            }
        }

    }
    /*Metodo que convierte cantidad en euros (string 'cantidad') a dolares(String 'valor')
    * Trata la operacion con un tipo valor Double
    */
    public String convertirADolares(String cantidad,String cambio) {
        //Transforma cantidad a double a la vez que realiza la operacion de cambio(el cambio se obtiene del cuadro de texto donde el usuario lo escriba)
        double valor =
                Double.parseDouble(cantidad) / Double.parseDouble(cambio);
        //Devuelve valor transformado a string
        return
                Double.toString(valor);
    }
    /*Metodo que convierte cantidad en dolares (string 'cantidad') a euros(String 'valor')
   * Trata la operacion con un tipo valor Double
   */
    public String convertirAEuros(String cantidad,String cambio) {
        //Transforma cantidad a double a la vez que realiza la operacion de cambio(el cambio se obtiene del cuadro de texto donde el usuario lo escriba)
        double valor =
                Double.parseDouble(cantidad) * Double.parseDouble(cambio);
        //Devuelve valor transformado a string
        return
                Double.toString(valor);
    }
}
