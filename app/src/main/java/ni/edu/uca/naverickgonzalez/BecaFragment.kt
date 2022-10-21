package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.naverickgonzalez.databinding.FragmentBecaBinding
import kotlin.math.round

class BecaFragment : Fragment() {
    lateinit var binding: FragmentBecaBinding
    var prom = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBecaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener {
            try {
                prom = binding.etProm.text.toString().toDouble()
                if (prom in 0.0..100.0)
                    binding.tvMaterial.text = calcularBeca(prom)
                else
                    Toast.makeText(context, "Digite una nota real.", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Digite un dato valido.", Toast.LENGTH_SHORT).show()
            }
            binding.etProm.setText("")
        }
    }

    private fun calcularBeca(prom: Double): String {
        return when (round(prom).toInt()) {
            in 85..89 -> "El estudiante puede optar a una beca del 25%."
            in 90..94 -> "El estudiante puede optar a una beca del 50%."
            in 95..99 -> "El estudiante puede optar a una beca del 75%."
            100 -> "El estudiante puede optar a una beca del 100%."
            else -> "El estudiante no cumple con el promedio suficiente para poder optar a beca."
        }
    }
}