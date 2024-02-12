package com.latihan.simulasiuk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.simulasiuk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var find : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        find = ActivityMainBinding.inflate(layoutInflater)
        setContentView(find.root)

        val data = mutableListOf<Barang>()
        find.rvBarang.layoutManager = LinearLayoutManager(this)

        find.btnFormBarangSubmit.setOnClickListener {
            val kode = find.etFormBarangKode.text
            val nama = find.etFormBarangNama.text
            val stok = find.etFormBarangStok.text

            if(kode.isNotEmpty() && nama.isNotEmpty() && stok.isNotEmpty()){

                data.add(Barang(
                    kode.toString().toInt(),
                    nama.toString(),
                    stok.toString().toInt()
                ))

                val msgAdapter = BarangAdapter(data)
                find.rvBarang.adapter = msgAdapter
                msgAdapter.notifyDataSetChanged()

                kode.clear()
                nama.clear()
                stok.clear()

                alert("data berhasil ditambahkan!")

                hideKeyboard(find.btnFormBarangSubmit)
            } else {
               alert("Isi semua form terlebih dahulu")
            }
        }
    }

    fun alert(msg: String){
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun hideKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}