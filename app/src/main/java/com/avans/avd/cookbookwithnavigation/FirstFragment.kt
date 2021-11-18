package com.avans.avd.cookbookwithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.avans.avd.cookbookwithnavigation.databinding.FragmentFirstBinding
import com.avans.avd.cookbookwithnavigation.model.RecipeDAOImpl

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val recipeDAO = RecipeDAOImpl()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.showDescriptionBtn.setOnClickListener {
            val recipe = binding.recipeSelectionSpn.selectedItem.toString()
            binding.descriptionTextview.text = getRecipeDescription(recipe)
        }

        binding.recipeDetailsBtn.setOnClickListener {
            val recipe = binding.recipeSelectionSpn.selectedItem.toString()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(recipe)
            findNavController().navigate(action)
        }
    }

    private fun getRecipeDescription(recipe: String): String =
        recipeDAO.find(recipe)?.description ?: "no recipe found"


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}