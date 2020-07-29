package yuresko.affsub2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        supportActionBar?.title = "Profile"

        val extras: Bundle? = intent.extras
        if (extras != null) {
            Picasso.get().load(extras.getString("image"))
                .into(imageViewProfile)
            firstNameProfile.text = extras.getString("firstName")
            secondNameProfile.text = extras.getString("lastName")
            profileAge.text = extras.getString("age")
            profileNUmber.text = extras.getString("number")
            profileEmail.text = extras.getString("email")
            profileSkype.text = extras.getString("skype")
        }

    }
}