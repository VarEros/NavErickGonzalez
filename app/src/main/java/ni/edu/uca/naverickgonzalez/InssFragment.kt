package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.naverickgonzalez.databinding.FragmentInssBinding
import ni.edu.uca.naverickgonzalez.model.Salario

class InssFragment : Fragment() {
    lateinit var binding: FragmentInssBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInssBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener {
            try {
                val salNeto = binding.etSalario.text.toString().toDouble()
                val salario = Salario(salNeto)
                binding.tvMaterial.text = "Tiene que pagar ${String.format("%.2f", salario.aPagar)}C$ al INSS \n" +
                                          "Su salario final seria de ${String.format("%.2f", salario.salFin)}C$"
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Digite un dato valido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}