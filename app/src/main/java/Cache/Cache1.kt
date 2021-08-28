package Cache

import Modul.MyDataClass
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Cache1 {
    private const val NAME = "KeshXotira"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init (context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)

    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor)-> Unit){
        val editor = edit()

        operation(editor)
        editor.apply()
    }

    var objectString: ArrayList<MyDataClass>
        get() = gsonStringToArray(preferences.getString("obekt0", "[]")!!)
        set(value) = preferences.edit{
            if (value!=null){
                it.putString("obekt0", arrayToGsonString(value))
            }
        }

    fun arrayToGsonString (arrayList:ArrayList<MyDataClass>): String {
        return Gson().toJson(arrayList)
    }

    fun gsonStringToArray(gsonString: String): ArrayList<MyDataClass>{

        val typeToken = object : TypeToken<ArrayList<MyDataClass>>() {}.type

        return Gson().fromJson(gsonString, typeToken)
        }
    }