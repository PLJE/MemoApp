package com.example.memo

import android.app.Activity
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val editTitle = findViewById<EditText>(R.id.editTitle)
        val editContent = findViewById<EditText>(R.id.editContent)
        val imageSave = findViewById<ImageButton>(R.id.imageSave)
        val imageDelete = findViewById<ImageButton>(R.id.imageDelete)

        var memo = intent.getSerializableExtra("memo") as Memo

        editTitle.setText(memo.title)
        editContent.setText(memo.content)


        imageSave.setOnClickListener{
            //제목과 내용 둘다 있을때 main으로 돌아감
            if(editTitle.text.toString().isNotEmpty() && editContent.text.toString().isNotEmpty()){
                memo.title = editTitle.text.toString()
                memo.content = editContent.text.toString()

                val returnIntent = Intent()
                returnIntent.putExtra("returnMemo",memo)

                setResult(Activity.RESULT_OK,returnIntent)

                finish()
            }
            else if(editTitle.text.toString().isNotEmpty()){
                Toast.makeText(this,"내용이 비었습니다.",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this,"내용이 비었습니다.",Toast.LENGTH_SHORT).show()
            }
        }
        imageDelete.setOnClickListener{
            setResult(Activity.RESULT_CANCELED,Intent().putExtra("returnMemo",memo))

            finish()
        }
    }
}