package com.example.abu_hw2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.abu_hw2.R
import com.example.abu_hw2.data.LoveResult
import com.example.abu_hw2.databinding.FragmentLovaBinding
import com.example.abu_hw2.mvp.LoveContract
import com.example.abu_hw2.mvp.LoveModel
import com.example.abu_hw2.mvp.LovePresenter

class LoveFragment : Fragment(), LoveContract.View {

    private val binding: FragmentLovaBinding by lazy {
        FragmentLovaBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: LoveContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter = LovePresenter(this, LoveModel())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val secondName = binding.etSecondName.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            presenter.calculateLovePercentage(firstName, secondName)
        }
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showResult(loveResult: LoveResult) {
        val bundle = Bundle().apply {
            putString("firstName", loveResult.firstName)
            putString("secondName", loveResult.secondName)
            putInt("percentage", loveResult.percentage.toIntOrNull() ?: 0)
        }
        val resultFragment = LoveFragment().apply {
            arguments = bundle
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, resultFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }
}