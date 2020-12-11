package com.example.navigationbar.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.navigationbar.R

class GameFragment : Fragment(R.layout.fragment_game), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var restartButton: Button

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private var buttonNumber = 0
    var activePlayer = 1
    private var movesMade = 0
    var winnerPlayer = 0

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            when (clickedView.id) {

                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.resetButton -> buttonNumber = 0

            }

            if (buttonNumber != 0) {

                playGame(clickedView, buttonNumber)

            } else {

                clearButtons()
                enableButton()

                firstPlayer.clear()
                secondPlayer.clear()

                winnerPlayer = 0
                movesMade = 0
                activePlayer = 1

            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GRAY)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
            movesMade += 1
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.DKGRAY)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
            movesMade += 1
        }

        clickedView.isEnabled = false
        check()

    }

    private fun check() {

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (movesMade == 9 && winnerPlayer == 0) {
            Toast.makeText(requireContext(), "draw!", Toast.LENGTH_LONG).show()

        } else if (movesMade == 9 && winnerPlayer == 1) {
            Toast.makeText(requireContext(), "X wins!", Toast.LENGTH_LONG).show()

        } else if (movesMade == 9 && winnerPlayer == 2) {
            Toast.makeText(requireContext(), "O wins!", Toast.LENGTH_LONG).show()
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(requireContext(), "X wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "O wins!", Toast.LENGTH_LONG).show()
            }

            disableButton()

        }

    }

    private fun disableButton() {
        if (winnerPlayer == 1 || winnerPlayer == 2) {

            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false

        }
    }

    private fun enableButton() {

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

    }

    private fun clearButtons() {

        button1.setBackgroundColor(Color.BLACK)
        button1.setText("")
        button2.setBackgroundColor(Color.BLACK)
        button2.setText("")
        button3.setBackgroundColor(Color.BLACK)
        button3.setText("")
        button4.setBackgroundColor(Color.BLACK)
        button4.setText("")
        button5.setBackgroundColor(Color.BLACK)
        button5.setText("")
        button6.setBackgroundColor(Color.BLACK)
        button6.setText("")
        button7.setBackgroundColor(Color.BLACK)
        button7.setText("")
        button8.setBackgroundColor(Color.BLACK)
        button8.setText("")
        button9.setBackgroundColor(Color.BLACK)
        button9.setText("")

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button1 = view.findViewById(R.id.button1)
        button2 = view.findViewById(R.id.button2)
        button3 = view.findViewById(R.id.button3)
        button4 = view.findViewById(R.id.button4)
        button5 = view.findViewById(R.id.button5)
        button6 = view.findViewById(R.id.button6)
        button7 = view.findViewById(R.id.button7)
        button8 = view.findViewById(R.id.button8)
        button9 = view.findViewById(R.id.button9)
        restartButton = view.findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        restartButton.setOnClickListener(this)

    }

}