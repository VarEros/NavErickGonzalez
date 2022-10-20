package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ni.edu.uca.naverickgonzalez.databinding.FragmentInssBinding
import ni.edu.uca.naverickgonzalez.model.Salario

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InssFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentInssBinding

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
        binding = FragmentInssBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener {
            val salNeto = binding.etSalario.text.toString().toDouble()
            val salario = Salario(salNeto)
            binding.tvMaterial.text = "Tiene que pagar ${String.format("%.2f", salario.aPagar)}C$ al INSS \n Su salario final seria de ${String.format("%.2f", salario.salFin)}C$"
        }
    }
}