package br.com.bicmsystems.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.bicmsystems.calculaflex.extensions.format
import kotlinx.android.synthetic.main.gasto_reais_km.*
import kotlinx.android.synthetic.main.sugestao_abastecimento.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if (intent.extras == null) {
            Toast.makeText(this, "Não foi possível realizar a operação",
                    Toast.LENGTH_SHORT).show()
        } else {
            calculate()
        }

    }

    private fun calculate() {
        val gasPrice = intent.extras.getDouble("GAS_PRICE", 0.0)
        val ethanolPrice = intent.extras.getDouble("ETHANOL_PRICE", 0.0)
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE", 0.0)
        val ethanolAverage = intent.extras.getDouble("ETHANOL_AVERAGE", 0.0)
        val performanceOfMyCar = ethanolAverage / gasAverage
        val priceOfFuelIndice = ethanolPrice / gasPrice
        if (priceOfFuelIndice <= performanceOfMyCar) {
            tvCombustivelSugerido.text = getString(R.string.etanol)
        } else {
            tvCombustivelSugerido.text = getString(R.string.gasolina)
        }
        tvGastoAlcoolPorKm.text = (ethanolPrice / ethanolAverage).format(2)
        tvGastoGasolinaPorKm.text = (gasPrice / gasAverage).format(2)
        tvPerformanceCombustivel.text = getString(R.string.hint_fuel_ratio, performanceOfMyCar.format(2).toDouble())
    }

}
