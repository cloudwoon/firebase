package test.app.testfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.app.testfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityMainBinding
    private var textDTO = TestModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        sendData()
    }

    private fun sendData() {
        mbinding.BTFirst.setOnClickListener{
            inputData()
        }
    }
    private fun inputData() {
        val et_fist = mbinding.ETFirst.text.toString()
        val et_second = mbinding.ETSecond.text.toString()

        when {
            et_fist.isEmpty() -> {
                mbinding.ETFirst.error = "이름을 입력해주세요."
            }
            et_second.isEmpty() -> {
                mbinding.ETSecond.error = "나이를 입력해주세요."
            }
            else-> {
                initView(et_fist, et_second)
            }
        }
    }

    private fun initView(etFist: String, etSecond: String) {
        textDTO.name = etFist
        textDTO.age = etSecond
        FirebaseViewModel(application).uploadItem(textDTO)

    }
}