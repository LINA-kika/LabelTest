package vk.test.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.submitBTN)
        val input: TextInputLayout = findViewById(R.id.inputFieldForm)
        val field: TextView = findViewById(R.id.textLabel)
        btn.setOnClickListener {
            field.text = input.editText?.text.toString()
        }
    }
}