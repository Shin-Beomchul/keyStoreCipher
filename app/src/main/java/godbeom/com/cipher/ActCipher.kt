package godbeom.com.cipher

import AndroidRsaCipherHelper
import SecureSharedPreferences
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main._act_cipher.*
import kotlinx.android.synthetic.main.content_act_cipher.*

class ActCipher : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._act_cipher)
        setSupportActionBar(toolbar)

        //init Storage
        AndroidRsaCipherHelper.init(applicationContext)
        var normalPref:SharedPreferences = getSharedPreferences("normalPref", Context.MODE_PRIVATE)
        val securePref  = SecureSharedPreferences(normalPref)

        //init dummy Data
        etId.setText("godbeom")
        etPw.setText("beom1234")



        //암호화
        btnEnc.setOnClickListener {
            securePref.put("id", etId.text.toString())
            securePref.put("pw", etPw.text.toString())
            tvPrint.append("암호화 완료")

        }

        //복호화
        btnDec.setOnClickListener {
            securePref.get("id","NaN",{
                tvPrint.append(it + "\n" )
            })

            securePref.get("pw","NaN",{
                tvPrint.append(it+ "\n")
            })

            // * If you want to guarantee execution order bundle it with a Thread task




        }

        //암호문 보기
        btnCypStr.setOnClickListener {
                  tvPrint.append(securePref.getCyptStr("id") + "\n"
                    + securePref.getCyptStr("pw") + "\n")
        }


        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
