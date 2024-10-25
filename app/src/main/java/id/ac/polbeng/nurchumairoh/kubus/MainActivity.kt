package id.ac.polbeng.nurchumairoh.kubus

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sideLengthInput = findViewById<EditText>(R.id.sideLengthInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val volumeResult = findViewById<TextView>(R.id.volumeResult)
        val surfaceAreaResult = findViewById<TextView>(R.id.surfaceAreaResult)

        calculateButton.setOnClickListener {
            val sideLengthText = sideLengthInput.text.toString()

            if (sideLengthText.isNotEmpty()) {
                val sideLength = sideLengthText.toDouble()

                val volume = calculateCubeVolume(sideLength)
                val surfaceArea = calculateCubeSurfaceArea(sideLength)

                volumeResult.text = "Volume: $volume cm³"
                surfaceAreaResult.text = "Luas Permukaan: $surfaceArea cm²"
            } else {
                volumeResult.text = "Masukkan panjang sisi!"
                surfaceAreaResult.text = ""
            }
        }
    }

    private fun calculateCubeVolume(sideLength: Double): Double {
        return sideLength * sideLength * sideLength
    }

    private fun calculateCubeSurfaceArea(sideLength: Double): Double {
        return 6 * sideLength * sideLength
    }
}