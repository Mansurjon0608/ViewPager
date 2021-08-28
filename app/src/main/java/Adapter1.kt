import Modul.MyDataClass
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewhomework.R
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.item_rv.view.*
import java.lang.reflect.Field


class Adapter1(val context: Context, private val list: List<MyDataClass>) :
    RecyclerView.Adapter<Adapter1.Vh>() {

    inner class Vh(var itemRv: View) : RecyclerView.ViewHolder(itemRv) {

        @SuppressLint("DiscouragedPrivateApi")
        fun onBind(user: MyDataClass) {
            itemRv.txt_name_itemRv.text = user.name
            itemRv.txt_number_itemRv.text = user.number

            itemRv.popup_menu.setOnClickListener {

                val popupMenu = android.widget.PopupMenu(context, itemRv.popup_menu)
                popupMenu.inflate(R.menu.popup)
                popupMenu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.menu_call -> {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_DIAL,
                                    Uri.parse("tel:${user.number}")
                                )
                            )
                            true
                        }
                        R.id.menu_sms -> {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_SENDTO,
                                    Uri.parse("smsto:${user.number}")
                                )
                            )
                            true
                        }
                        else -> true
                    }
                }

                try {
                    val popup: Field =
                        android.widget.PopupMenu::class.java.getDeclaredField("mPopup")
                    popup.isAccessible = true
                    val menu = popup.get(popupMenu)
                    menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                        .invoke(menu, true)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    popupMenu.show()
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}
