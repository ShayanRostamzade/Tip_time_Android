package TipTime.Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_button.setOnClickListener{calculateTip()}
    }
    fun calculateTip(){
        val stringInTextField = cost_of_service_edit_text.text.toString()
        var cost = stringInTextField.toDouble()
        val selectedID = radio_group.checkedRadioButtonId
        val tipPercentage = when(selectedID) {
            R.id.option_20_percent -> 0.20
            R.id.option_18_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = round_up_switch.isChecked
        if(roundUp)
            tip = ceil(tip)

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tip_amount.text = getString(R.string.tip_amount, formattedTip)
    }
}