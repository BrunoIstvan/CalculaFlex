package br.com.bicmsystems.calculaflex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.bicmsystems.calculaflex.utils.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.consumo_medio_inputs.*
import kotlinx.android.synthetic.main.posto_gasolina_inputs.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        edtPrecoGasolina.addTextChangedListener(DecimalTextWatcher(edtPrecoGasolina))
        edtPrecoAlcool.addTextChangedListener(DecimalTextWatcher(edtPrecoAlcool))
        edtConsumoGasolina.addTextChangedListener(DecimalTextWatcher(edtConsumoGasolina, 1))
        edtConsumoAlcool.addTextChangedListener(DecimalTextWatcher(edtConsumoAlcool, 1))

        btnCalculate.setOnClickListener {

            val proximatela = Intent(this@FormActivity, ResultActivity::class.java)
            proximatela.putExtra("GAS_PRICE", edtPrecoGasolina.text.toString().toDouble())
            proximatela.putExtra("ETHANOL_PRICE", edtPrecoAlcool.text.toString().toDouble())
            proximatela.putExtra("GAS_AVERAGE", edtConsumoGasolina.text.toString().toDouble())
            proximatela.putExtra("ETHANOL_AVERAGE", edtConsumoAlcool.text.toString().toDouble())
            startActivity(proximatela)

        }

    }
}
