package ni.edu.uca.naverickgonzalez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ni.edu.uca.naverickgonzalez.databinding.FragmentLoginBinding
import ni.edu.uca.naverickgonzalez.model.Usuario

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentLoginBinding
    private val userCt = Usuario("UCA", "Damo1")
    private var param1: String? = null
    private var param2: String? = null

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
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            with(binding){
                val nickname = etUser.text.toString()
                val password = etPwd.text.toString()
                val User = Usuario(nickname,password)
                if(verificarUsuario(User)){
                    findNavController().navigate(R.id.menuFragment)
                }else{
                    limpiar()
                    Toast.makeText(requireActivity(), "Contraseña Incorrecta", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun limpiar(){
        binding.etUser.setText("")
        binding.etPwd.setText("")
    }

    private fun verificarUsuario(user: Usuario): Boolean {
        return user.nickname==userCt.nickname && user.password == userCt.password
    }

}