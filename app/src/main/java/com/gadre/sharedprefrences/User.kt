import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class User(
    val username: String,
    val password: String,
    val mobilenumber: String
)

class UserManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUser(user: User) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(user)
        editor.putString("user_key", json)
        editor.apply()
    }

    fun getUser(): User? {
        val json = sharedPreferences.getString("user_key", null)
        return if (json != null) {
            gson.fromJson(json, User::class.java)
        } else {
            null
        }
    }
}
