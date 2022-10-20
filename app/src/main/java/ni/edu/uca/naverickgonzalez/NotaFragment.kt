package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.naverickgonzalez.databinding.FragmentInssBinding
import ni.edu.uca.naverickgonzalez.databinding.FragmentMenuBinding
import ni.edu.uca.naverickgonzalez.databinding.FragmentNotaBinding


class NotaFragment : Fragment() {
    lateinit var binding: FragmentNotaBinding
    val notas: MutableList<Double> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAgregar.setOnClickListener {
            try {
                notas.add(binding.etNota.text.toString().toDouble())
                binding.etNota.setText("")
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "El dato digitado no es valido", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCalcular.setOnClickListener {
            if (notas.size >= 3) {
                notas.sortDescending()
                binding.tvMaterial.text =
                    "Las tres mejores notas son: ${
                        String.format(
                            "%.2f",
                            notas[0]
                        )
                    }, ${String.format("%.2f", notas[1])} y ${
                        String.format(
                            "%.2f",
                            notas[2]
                        )
                    }"
            } else {
                Toast.makeText(context, "Faltan agregar datos para realizar esta operacion", Toast.LENGTH_SHORT).show()
            }
        }
    }

}