package com.latihan.simulasiuk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BarangAdapter(val list: MutableList<Barang>)
    : RecyclerView.Adapter<BarangAdapter.Holder>()
{
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val kode : TextView = itemView.findViewById(R.id.tvAdpBrgKode)
        val nama : TextView = itemView.findViewById(R.id.tvAdpBrgNama)
        val stok : TextView = itemView.findViewById(R.id.tvAdpBrgStok)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_barang, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.kode.text = list[position].kode.toString()
        holder.nama.text = list[position].nama
        holder.stok.text = list[position].stok.toString()
    }

}