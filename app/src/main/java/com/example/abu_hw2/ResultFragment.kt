package com.example.abu_hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abu_hw2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private val binding by lazy {
        FragmentResultBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getInt("percentage")

        binding.tvFirstNameResult.text = firstName
        binding.tvSecondNameResult.text = secondName
        binding.tvPercentage.text = "$percentage%"

        binding.btnTryAgain.setOnClickListener {
            val loveFragment = LoveFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loveFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}