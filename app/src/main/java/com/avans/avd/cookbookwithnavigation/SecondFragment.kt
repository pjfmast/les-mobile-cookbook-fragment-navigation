package com.avans.avd.cookbookwithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.avans.avd.cookbookwithnavigation.databinding.FragmentSecondBinding
import com.avans.avd.cookbookwithnavigation.model.RecipeDAOImpl

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    val args: SecondFragmentArgs by navArgs()
    val recipes = RecipeDAOImpl()

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val recipe = recipes.find(args.recipe)
        binding.textviewSecond.text = recipe?.toString() ?: "no recipe found with name ${args.recipe}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}