package project.seo.combinepicture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import project.seo.combinepicture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pictureView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            firstPicture.setOnClickListener {
                pictureView = firstPicture
                loadImage.launch("image/*")
            }
            secondPicture.setOnClickListener {
                pictureView = secondPicture
                loadImage.launch("image/*")
            }
        }

    }

    private val loadImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            Glide.with(this@MainActivity).load(uri).into(pictureView)
        }
}