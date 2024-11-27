package com.codegalaxy.mock21nov.view

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.codegalaxy.mock21nov.NetworkUtils
import com.codegalaxy.mock21nov.R
import com.codegalaxy.mock21nov.UiState
import com.codegalaxy.mock21nov.databinding.ActivityMainBinding
import com.codegalaxy.mock21nov.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        //uri for bookprovider
//        val BOOK_URI: Uri =Uri.parse("content://com.codegalaxy.customcontentprovidermock25nov/books")
//
//        //Query the BooksResolver
//        val cursor=contentResolver.query(
//            BOOK_URI,
//            null,
//            null,
//            null,
//            null
//        )
//
//        val books=StringBuilder("Books in Db:\n")
//
//        //read the data from the cursor and display it in the UI
//        cursor?.apply {
//            while (moveToNext()){
//                val bookId=getInt(getColumnIndexOrThrow("id"))
//                val bookName=getString(getColumnIndexOrThrow("name"))
//                val bookYear=getInt(getColumnIndexOrThrow("year"))
//
//                books.append("$bookId $bookName $bookYear\n")
//            }
//            close()
//        }
//
//        binding.textView.text=books.toString()





        binding.goToViewPagerButton.setOnClickListener{
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }


        binding.fetchButton.setOnClickListener{
            val intent = Intent(this, FetchActivity::class.java)
            startActivity(intent)
        }


        binding.submitButton.setOnClickListener{


            val name =binding.nameInput.text.toString()
            val year =binding.yearInput.text.toString()
            val price =binding.priceInput.text.toString()
            val cpuModel =binding.cpuInput.text.toString()
            val hardDiskSize =binding.hardDiskInput.text.toString()


//            if(NetworkUtils.isInternetAvailable(this))
//            {
//                viewModel.submitProduct(name,year,price,cpuModel,hardDiskSize)
//            }
//            else{
//
//                Toast.makeText(this,"No internet connection",Toast.LENGTH_LONG).show()
//
//            }

            viewModel.submitProduct(name,year,price,cpuModel,hardDiskSize)

        }

        observerState()
    }


    private fun observerState() {

        viewModel.uiState.observe(this){ state->

            when(state)
            {
                is UiState.Loading->{
                    showAlertDialog("Loading")
                }

                is UiState.Success->{
                    showAlertDialog("Success")
                    clearInput()
                }

                is UiState.Error->{
                    showAlertDialog("Error: ${state.message}")
                }
            }

        }
    }


    private fun showAlertDialog(message:String)
    {
        AlertDialog.Builder(this)
            .setTitle(message)
            .setMessage(message)
            .setPositiveButton("OK"){dialog,which->
                dialog.dismiss()
            }
            .show()
    }


    private fun clearInput()
    {
        binding.nameInput.text.clear()
        binding.yearInput.text.clear()
        binding.priceInput.text.clear()
        binding.cpuInput.text.clear()
        binding.hardDiskInput.text.clear()
    }
}