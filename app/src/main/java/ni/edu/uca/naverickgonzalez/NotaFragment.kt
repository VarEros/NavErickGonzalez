package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ni.edu.uca.naverickgonzalez.databinding.FragmentInssBinding
import ni.edu.uca.naverickgonzalez.databinding.FragmentMenuBinding
import ni.edu.uca.naverickgonzalez.databinding.FragmentNotaBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NotaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentNotaBinding
    val notas: MutableList<Double> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAgregar.setOnClickListener {
            notas.add(binding.etNota.text.toString().toDouble())
        }
        binding.btnCalcular.setOnClickListener {
            val Nota1: Double = 0.0
            val Nota2: Double = 0.0
            val Nota3: Double = 0.0
            binding.tvMaterial.text = "Las tres mejores notas son: ${notas[1]}, ${notas[2]} y ${notas[3]}"
        }
    }

}