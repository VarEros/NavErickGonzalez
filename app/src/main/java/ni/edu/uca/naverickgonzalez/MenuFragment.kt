package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ni.edu.uca.naverickgonzalez.databinding.FragmentLoginBinding
import ni.edu.uca.naverickgonzalez.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnInss.setOnClickListener {
                findNavController().navigate(R.id.inssFragment)
            }
            btnNota.setOnClickListener {
                findNavController().navigate(R.id.notaFragment)
            }
            btnBeca.setOnClickListener {
                findNavController().navigate(R.id.becaFragment)
            }
        }
    }
}