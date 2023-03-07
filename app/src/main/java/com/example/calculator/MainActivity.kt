package com.example.calculator

import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.calculator.Calculating.Companion.calculate

import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backSpace.setBackgroundResource(R.drawable.vector)

        binding.button0.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '0'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button1.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '1'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button2.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '2'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button3.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '3'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button4.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '4'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button5.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '5'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button6.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '6'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button7.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '7'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button8.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '8'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.button9.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '9'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.divide.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '/'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.clear.setOnClickListener()
        {
            binding.expression.text = ""
            binding.answer.text = ""
            binding.backSpace.setBackgroundResource(R.drawable.vector)
        }

        binding.comma.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '.'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.inversion.setOnClickListener()
        {
            if (binding.expression.text.isNotEmpty())
            {
                if (binding.expression.text[0] != '-') binding.expression.text = '-' + binding.expression.text.toString()
                else binding.expression.text = binding.expression.text.toString().substring(1, binding.expression.text.length)
            }
        }

        binding.minus.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '-'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.multiply.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '*'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.percent.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '%'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.plus.setOnClickListener()
        {
            binding.expression.text = binding.expression.text.toString() + '+'
            binding.backSpace.setBackgroundResource(R.drawable.vector__1_)
        }

        binding.result.setOnClickListener()
        {
            binding.answer.text = calculate(binding.expression.text.toString())
            if (binding.answer.text != "Error")
            {
                binding.expression.text = ""
                binding.backSpace.setBackgroundResource(R.drawable.vector)
            }
        }

        binding.backSpace.setOnClickListener()
        {
            if (binding.expression.text.isNotEmpty())
            {
                binding.expression.text = binding.expression.text.toString().substring(0, binding.expression.text.length - 1)
                if (binding.expression.text.isEmpty())
                {
                    binding.backSpace.setBackgroundResource(R.drawable.vector)
                }
            }
        }



    }

}
