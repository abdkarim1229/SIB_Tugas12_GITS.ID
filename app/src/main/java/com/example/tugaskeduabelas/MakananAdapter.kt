import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaskeduabelas.Makanan
import com.example.tugaskeduabelas.R
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class MakananAdapter(private val makananList: ArrayList<Makanan>) :
    RecyclerView.Adapter<MakananAdapter.MyViewHolder>() {

    private lateinit var mClick: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mClick = listener
    }


    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val imageMakanan: ImageView = itemView.findViewById(R.id.img_makanan)
        val namaMakanan: TextView = itemView.findViewById(R.id.nama_makanan)
        val hargaMakanan: TextView = itemView.findViewById(R.id.harga_makanan)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_makanan, parent, false)
        return MyViewHolder(itemView, mClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = makananList[position]
        holder.imageMakanan.setImageResource(item.image)
        holder.namaMakanan.text = item.nama
        holder.hargaMakanan.text = item.harga
    }

    override fun getItemCount(): Int {
        return makananList.size
    }
}